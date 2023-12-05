package com.BookMyShow.BMS.services;

import com.BookMyShow.BMS.Exception.UserNotFoundException;
import com.BookMyShow.BMS.models.User;
import com.BookMyShow.BMS.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User signUp(String email, String password) throws UserNotFoundException {
        Optional<User>  userOptional = userRepo.findByuserEmail(email);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User is not found");
        }


        User user = new User();
        user.setUserEmail(email);
        user.setPassword(password);
        User savedUser = userRepo.save(user);
        return savedUser;


    }
}
