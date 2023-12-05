package com.BookMyShow.BMS.repositories;

import com.BookMyShow.BMS.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepo extends JpaRepository<Show,Long> {

    @Override
    Optional<Show> findById(Long aLong);

}
