package com.masai.Services.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.masai.Repository.ReservationRepository;
import com.masai.Repository.TablesRepository;
import com.masai.Services.ReservationService;
import com.masai.model.Reservation;
import com.masai.model.Tables;
import com.masai.model.User;


@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository resRepo;
	@Autowired
	private TablesRepository tableRepo;

	@Override
	public Reservation createReservation(Reservation res) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		res.setReservationTime(LocalDateTime.now());
		res.setUser(user);
		Tables table = tableRepo.findById(res.getTable().getId())
				.orElseThrow(() -> new RuntimeException("No table found"));
		res.setTable(table);

		return resRepo.save(res);
	}

	@Override
	public Reservation deleteReservation(long id) {
		Reservation res= resRepo.findById(id).orElseThrow(()-> new RuntimeException("No reservation fond"));
		resRepo.delete(res);
		return res;
	}

}
