package com.BookMyShow.BMS.repositories;

import com.BookMyShow.BMS.models.Show;
import com.BookMyShow.BMS.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType,Long> {
    List<ShowSeatType> findByShow(Show show);

}
