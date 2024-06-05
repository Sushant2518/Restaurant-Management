package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	Optional<Menu> findByName(String name);
}
