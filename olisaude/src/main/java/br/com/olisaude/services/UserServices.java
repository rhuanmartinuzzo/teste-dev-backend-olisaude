package br.com.olisaude.services;


import br.com.olisaude.controllers.UserController;
import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.exceptions.RequiredObjectIsNullException;
import br.com.olisaude.exceptions.ResourceNotFoundException;
import br.com.olisaude.mapper.DozerMapper;
import br.com.olisaude.model.HealthProblemTop;
import br.com.olisaude.model.User;
import br.com.olisaude.repositories.UserRepository;
import br.com.olisaude.util.HealthProblemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices {

    private Logger logger = Logger.getLogger(UserServices.class.getName());


    @Autowired
    UserRepository repository;
    @Autowired
    HealthProblemServices healthProblemServices;
    @Autowired
    HealthProblemUtils healthProblemUtils;

    public UserServices(UserRepository repository, HealthProblemServices healthProblemServices, HealthProblemUtils healthProblemUtils){
        this.repository = repository;
        this.healthProblemServices = healthProblemServices;
        this.healthProblemUtils = healthProblemUtils;
    }

    public List<UserVO> findAll(){
        logger.info("Finding all users");

        var users = DozerMapper.parseListObjects(repository.findAll(), UserVO.class);
        System.out.println(users);
        return users;
    }

    public UserVO findById(Long id){
        logger.info("Finding one user!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, UserVO.class);
        return vo;
    }

    public UserVO create(UserVO user){

        if (user==null)throw new RequiredObjectIsNullException();

        logger.info("Creating one user!");

        var entity = DozerMapper.parseObject(user, User.class);
        var vo = DozerMapper.parseObject(repository.save(entity), UserVO.class);
        return vo;
    }

    public UserVO update(UserVO user) {

        if(user == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one user!");

        var entity = repository.findById(user.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(user.getName());
        entity.setBirth_day(user.getBirth_day());
        entity.setUpdated_at(new Date());
        entity.setGender(user.getGender());

        var vo =  DozerMapper.parseObject(repository.save(entity), UserVO.class);
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one user!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    public List<HealthProblemTop> findTopTen(){

        logger.info("Finding top ten users!");

        List<HealthProblemTop> topTen = new ArrayList<>();
        List<User> users = repository.findAll();
        List<Integer> healthLevel = new ArrayList<>();

        for (User user : users){
            healthLevel.add(healthProblemServices
                    .findAllById(user.getId())
                    .stream()
                    .reduce(0, (total, healthProblem) -> total + Math.toIntExact(healthProblem.getTier()), Integer::sum));
        }

        for (int index = 0; index < users.size(); index+=1) {
            HealthProblemTop newHealthProblemTop = new HealthProblemTop();
            User userFromList = users.get(index);
            newHealthProblemTop.setId(userFromList.getId());
            newHealthProblemTop.setName(userFromList.getName());
            newHealthProblemTop.setScore((float) healthProblemUtils.scoreRisk(healthLevel.get(index)));

            topTen.add(newHealthProblemTop);
        }

        Collections.sort(topTen, new Comparator<HealthProblemTop>() {
            @Override
            public int compare(HealthProblemTop o1, HealthProblemTop o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });


        final int ten = 10;
        return users.size() > ten ? topTen.subList(0,ten) : topTen.subList(0,users.size());
    }




}
