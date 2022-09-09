package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.mappers.UserToUserDTO;
import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserDTO userToUserDTO;


    public UserServiceImpl(UserRepository userRepository, UserToUserDTO userToUserDTO) {
        this.userRepository = userRepository;
        this.userToUserDTO = userToUserDTO;
    }

    @Override
    public UserDTO findUserByUsernameAndPassword(String username, String password) {

        User user = userRepository.findUserByUsernameAndPassword(username, password);

        if(user == null) {
            throw new NotFoundException("User Not Found. For Username value: " + username );
        }

        return userToUserDTO.convert(user);
    }
}
