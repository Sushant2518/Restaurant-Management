package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
