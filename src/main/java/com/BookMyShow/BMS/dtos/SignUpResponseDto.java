package com.BookMyShow.BMS.dtos;

import com.BookMyShow.BMS.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpResponseDto {
    private ResponseStatus responseStatus;
    private Long user_id;
}
