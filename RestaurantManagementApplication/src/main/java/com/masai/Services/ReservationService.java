package com.masai.Services;

import com.masai.model.Reservation;

public interface ReservationService {
	public Reservation createReservation(Reservation res);

	public Reservation deleteReservation(long id);
}
