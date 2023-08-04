package com.lemniscate.Car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lemniscate.Car.model.CurrentUserSession;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserSession, Integer> {
	public CurrentUserSession  findByUuid(String uuid);

	

}
