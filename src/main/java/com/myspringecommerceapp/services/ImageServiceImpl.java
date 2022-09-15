package com.myspringecommerceapp.services;

import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final UserRepository userRepository;

    public ImageServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void saveImageFile(String username, MultipartFile file) {

        try {
            User user = userRepository.findUserByUsername(username);

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            user.setImage(byteObjects);

            userRepository.save(user);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }

    }
}
