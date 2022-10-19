package br.com.olisaude.repositories;


import br.com.olisaude.data.vo.v1.HealthProblemVO;
import br.com.olisaude.model.HealthProblem;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HealthProblemRepository extends JpaRepository<HealthProblem, Long> {
    List<HealthProblem> findAllById(Long user_id);
}
