package com.BookMyShow.BMS.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date starttime;
    private Date endTime;

    private List<Feature> features;

//    @ManyToOne
//    private Screen screen;

}
