package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Services.ReservationService;
import com.masai.model.Reservation;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@PostMapping("/createRes")
	public ResponseEntity<Reservation> createRes(@RequestBody Reservation res){
		Reservation resr=reservationService.createReservation(res);
		return new ResponseEntity<Reservation>(resr, HttpStatus.CREATED);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Reservation> delete(@RequestParam long id){
		Reservation res= reservationService.deleteReservation(id);
		return new ResponseEntity<Reservation>(res, HttpStatus.ACCEPTED);
	}
}
