package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
