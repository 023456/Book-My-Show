package com.BookMyShow.BMS.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String number;
    private SeatType seatType;
    private int rowval;
    private int colval;
}
