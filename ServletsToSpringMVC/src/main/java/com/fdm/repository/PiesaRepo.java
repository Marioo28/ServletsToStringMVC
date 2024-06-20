package com.fdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdm.model.Piesa;

@Repository
public interface PiesaRepo extends JpaRepository<Piesa, Integer> {

}
