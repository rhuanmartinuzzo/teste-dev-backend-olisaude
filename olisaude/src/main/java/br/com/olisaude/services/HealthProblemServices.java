package br.com.olisaude.services;


import br.com.olisaude.data.vo.v1.HealthProblemVO;
import br.com.olisaude.exceptions.RequiredObjectIsNullException;
import br.com.olisaude.exceptions.ResourceNotFoundException;
import br.com.olisaude.mapper.DozerMapper;
import br.com.olisaude.model.HealthProblem;
import br.com.olisaude.repositories.HealthProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class HealthProblemServices {
    
    private Logger logger  = Logger.getLogger(HealthProblemServices.class.getName());

    @Autowired
    HealthProblemRepository repository;

    public HealthProblemServices(HealthProblemRepository repository){
        this.repository = repository;
    }

    public List<HealthProblemVO> findAll(){

        logger.info("Finding all users");

        var users = DozerMapper.parseListObjects(repository.findAll(), HealthProblemVO.class);
        return users;
    }

    public HealthProblemVO findById(Long id){
        logger.info("Finding one user!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, HealthProblemVO.class);
        return vo;
    }

    public HealthProblemVO create(HealthProblemVO problem){

        if (problem==null)throw new RequiredObjectIsNullException();

        logger.info("Creating one user!");

        var entity = DozerMapper.parseObject(problem, HealthProblem.class);
        var vo = DozerMapper.parseObject(repository.save(entity), HealthProblemVO.class);
        return vo;
    }

    public HealthProblemVO update(HealthProblemVO problem) {

        if(problem == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one user!");

        var entity = repository.findById(problem.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(problem.getName());
        entity.setTier(problem.getTier());
        entity.setUser_id(problem.getUser_id());

        var vo =  DozerMapper.parseObject(repository.save(entity), HealthProblemVO.class);
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one user!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
    
}
