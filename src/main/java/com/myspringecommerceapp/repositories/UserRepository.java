package com.myspringecommerceapp.repositories;

import com.myspringecommerceapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);

}
