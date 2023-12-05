package com.BookMyShow.BMS.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private int amount;
    private Long bookingId;
    private ResponseStatus responseStatus;

    @Override
    public String toString() {
        return "BookMovieResponseDto{" +
                "amount=" + amount +
                ", bookingId=" + bookingId +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
