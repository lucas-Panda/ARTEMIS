package com.artemis.Service;


import com.artemis.Entity.UserEntity;
import com.artemis.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity initUser(String username, String displayName){
        if (userRepository.existsByUsername(username)){
            throw new RuntimeException("Usuário ja existe");
        }

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setDisplayName(displayName);

        return userRepository.save(user);
    }
}
