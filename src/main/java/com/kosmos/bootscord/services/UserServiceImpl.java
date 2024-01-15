package com.kosmos.bootscord.services;

import com.kosmos.bootscord.entities.BootscordUser;
import com.kosmos.bootscord.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;
    @Override
    public BootscordUser registerUser(BootscordUser user) {
        // Make sure user with same user or email doesn't exist
        String email = user.getEmail();;
        String userName = user.getUserName();

        boolean emailExists = repository.findByEmail(email) != null;
        boolean userNameExist = repository.findByUserName(userName) != null;

        if (!emailExists && !userNameExist)
            return repository.save(user);
        else {
            return null;
        }
    }
}
