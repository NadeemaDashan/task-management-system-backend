package edu.personal.task.repository;

import edu.personal.task.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
