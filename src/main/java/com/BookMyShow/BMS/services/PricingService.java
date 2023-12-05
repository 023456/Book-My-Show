package com.BookMyShow.BMS.services;


import com.BookMyShow.BMS.models.Show;
import com.BookMyShow.BMS.models.ShowSeat;
import com.BookMyShow.BMS.models.ShowSeatType;
import com.BookMyShow.BMS.repositories.ShowSeatTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private ShowSeatTypeRepo showSeatTypeRepo;

    public int calculatePrice(List<ShowSeat> showSeats , Show show){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepo.findByShow(show);
        int amount=0;
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount = amount + showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }

}
