package com.BookMyShow.BMS.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class Booking extends BaseModel {
 @Enumerated(EnumType.ORDINAL)
 private BookingStatus bookingStatus;

@ManyToMany
 private List<ShowSeat> showSeat;

 private int price;
 @ManyToOne
 private User user;

 private Date booked_At;
 @ManyToOne
 private Show show;

 @OneToMany
 private List<Payment> payments;

}
