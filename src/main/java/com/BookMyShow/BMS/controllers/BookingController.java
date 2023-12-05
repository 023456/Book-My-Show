package com.BookMyShow.BMS.controllers;

import com.BookMyShow.BMS.dtos.BookMovieRequestDto;
import com.BookMyShow.BMS.dtos.BookMovieResponseDto;
import com.BookMyShow.BMS.dtos.ResponseStatus;
import com.BookMyShow.BMS.models.Booking;
import com.BookMyShow.BMS.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();
        Booking booking;
        try{
            booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowSeatIds(),bookMovieRequestDto.getShowId());

            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            bookMovieResponseDto.setAmount(booking.getPrice());

        }
        catch(Exception ex){
            bookMovieResponseDto.setResponseStatus(ResponseStatus.FAILED);

        }

        return bookMovieResponseDto;


    }
}
