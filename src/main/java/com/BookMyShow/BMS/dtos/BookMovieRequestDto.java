package com.BookMyShow.BMS.dtos;

import com.BookMyShow.BMS.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDto {
   private List<Long> showSeatIds;
   private Long userId;
   private Long showId;


}
