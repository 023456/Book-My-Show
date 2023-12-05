package com.BookMyShow.BMS.repositories;

import com.BookMyShow.BMS.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    @Override
    Optional<Booking> findById(Long aLong);

    @Override
    Booking save(Booking booking);

}
