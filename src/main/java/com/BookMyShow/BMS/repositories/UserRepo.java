package com.BookMyShow.BMS.repositories;

import com.BookMyShow.BMS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long aLong);
    Optional<User> findByuserEmail(String email);


    User save(User user);
}
