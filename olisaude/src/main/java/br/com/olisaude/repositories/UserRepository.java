package br.com.olisaude.repositories;

import br.com.olisaude.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE u.user_name =: user_name")
    User findByUsername(@Param("user_name") String user_name);

}
