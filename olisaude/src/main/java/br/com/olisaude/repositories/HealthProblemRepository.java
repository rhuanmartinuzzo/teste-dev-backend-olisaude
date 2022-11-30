package br.com.olisaude.repositories;


import br.com.olisaude.model.HealthProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HealthProblemRepository extends JpaRepository<HealthProblem, Long> {
    List<HealthProblem> findAllById(Long user_id);
}
