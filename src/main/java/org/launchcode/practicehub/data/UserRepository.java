package org.launchcode.practicehub.data;

import org.launchcode.practicehub.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    User findBySkaterName(String skaterName);

}
