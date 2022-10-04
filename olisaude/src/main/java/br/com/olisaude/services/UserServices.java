package br.com.olisaude.services;


import br.com.olisaude.controllers.UserController;
import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.exceptions.RequiredObjectIsNullException;
import br.com.olisaude.exceptions.ResourceNotFoundException;
import br.com.olisaude.mapper.DozerMapper;
import br.com.olisaude.model.User;
import br.com.olisaude.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserDetailsService.class.getName());

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository){
        this.repository = repository;
    }

    public List<UserVO> findAll(){

        logger.info("Finding all users");

        var persons = DozerMapper.parseListObjects(repository.findAll(), UserVO.class);
        persons.stream().forEach(p -> p.add(linkTo(methodOn(UserController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    public UserVO findById(Long id){
        logger.info("Finding one user!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, UserVO.class);
        vo.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        return vo;
    }

    public UserVO create(UserVO user){

        if (user==null)throw new RequiredObjectIsNullException();

        logger.info("Creating one user!");

        var entity = DozerMapper.parseObject(user, User.class);
        var vo = DozerMapper.parseObject(repository.save(entity), UserVO.class);
        vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
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
        vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one user!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name " + username + "!");
        var user = repository.findByUsername(username);
        if (user != null){
            return user;
        }
        else{
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
    }
}
