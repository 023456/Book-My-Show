package com.BookMyShow.BMS;

import com.BookMyShow.BMS.controllers.BookingController;
import com.BookMyShow.BMS.dtos.BookMovieRequestDto;
import com.BookMyShow.BMS.dtos.BookMovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class BmsApplication implements CommandLineRunner {
	@Autowired
	private BookingController bookingController;


	public static void main(String[] args) {


		SpringApplication.run(BmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BookMovieRequestDto bookMovieRequestDto = new BookMovieRequestDto();

		bookMovieRequestDto.setUserId(1L);
		bookMovieRequestDto.setShowId(1L);
		bookMovieRequestDto.setShowSeatIds(Arrays.asList(2L));
       BookMovieResponseDto bookMovieResponseDto = bookingController.bookMovie(bookMovieRequestDto);
	   System.out.println(bookMovieResponseDto);

	}
}
