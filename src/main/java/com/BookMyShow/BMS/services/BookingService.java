package com.BookMyShow.BMS.services;

import com.BookMyShow.BMS.Exception.BlockedSeatException;
import com.BookMyShow.BMS.Exception.ShownotFoundException;
import com.BookMyShow.BMS.Exception.UserNotFoundException;
import com.BookMyShow.BMS.models.*;
import com.BookMyShow.BMS.repositories.BookingRepo;
import com.BookMyShow.BMS.repositories.ShowRepo;
import com.BookMyShow.BMS.repositories.ShowSeatRepo;
import com.BookMyShow.BMS.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class BookingService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private ShowSeatRepo showSeatRepo;

    @Autowired
    private PricingService pricingService;

    @Autowired
    private BookingRepo bookingRepo;


    @Transactional(isolation= Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> seatIds, Long showId) throws UserNotFoundException, ShownotFoundException, BlockedSeatException {
        /*
        step 1 - get the user from the user id if not exist then throw some error
        2 - get the show from the show id
        3 - get the showseats from the seat id
        4 - check if the seats are available
        5- if yes, make a status as blocked oor booking in progress
        6- save updated showseats in db and end the lock
        7-
         */
        Optional<User>  userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User bookedby = userOptional.get();

        Optional<Show> showOptional = showRepo.findById(showId);
        if(showOptional.isEmpty()){
            throw  new ShownotFoundException("Show is not found");
        }
        Show bookedShow = showOptional.get();

        List<ShowSeat> showSeats = showSeatRepo.findAllById(seatIds);
        for(ShowSeat showSeat : showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getBlockedAt().toInstant(),
                                    new Date().toInstant()).toMinutes() > 15))) {

                throw new BlockedSeatException("Some Error occurred while booking the seats");

            }
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            savedShowSeats.add(showSeatRepo.save(showSeat));
        }
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBooked_At(new Date());
        booking.setShow(bookedShow);
        booking.setUser(bookedby);
        booking.setShowSeat(savedShowSeats);
        booking.setPrice(pricingService.calculatePrice(savedShowSeats,bookedShow));

        Booking savedBooking = bookingRepo.save(booking);
        return savedBooking;
    }

}
