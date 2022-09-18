package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.mappers.UserDtoToUser;
import com.myspringecommerceapp.mappers.UserToUserDTO;
import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserDTO userToUserDTO;
    private final UserDtoToUser userDtoToUser;


    public UserServiceImpl(UserRepository userRepository, UserToUserDTO userToUserDTO, UserDtoToUser userDtoToUser) {
        this.userRepository = userRepository;
        this.userToUserDTO = userToUserDTO;
        this.userDtoToUser = userDtoToUser;
    }

    @Override
    public UserDTO findUserByUsernameAndPassword(String username, String password) {

        User user = userRepository.findUserByUsernameAndPassword(username, password);

        if(user == null) {
            throw new NotFoundException("Username or/and password is not correct! ");
        }

        return userToUserDTO.convert(user);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);

        if(user == null) {
            throw new NotFoundException("User Not Found. For Username value: " + username );
        }

        return userToUserDTO.convert(user);
    }

    @Override
    public UserDTO readUserByUsername(String username) {
        User user = userRepository.readUserByUsername(username);
        return userToUserDTO.convert(user);
    }

    @Override
    public UserDTO readUserByEmail(String email) {
        User user = userRepository.readUserByEmail(email);
        return userToUserDTO.convert(user);
    }

    @Override
    public UserDTO saveUserDTO(UserDTO userDTO) {

        User detachedUser = userDtoToUser.convert(userDTO);

        User savedUser = userRepository.save(detachedUser);
        log.debug("------------------------Saved UserId: "+ savedUser.getId());
        System.out.println("------------------------Saved UserId: "+ savedUser.getId());

        return userToUserDTO.convert(savedUser);
    }
}
