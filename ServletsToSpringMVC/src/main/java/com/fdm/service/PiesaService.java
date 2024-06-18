package com.fdm.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.model.Piesa;
import com.fdm.repository.PiesaRepository;

@Service
public class PiesaService {

	private final PiesaRepository piesaRepository;

	@Autowired
	public PiesaService(PiesaRepository piesaRepository) {
		this.piesaRepository = piesaRepository;
	}

	
	public Set<Piesa> getAllPieces() {
		return piesaRepository.getAllPiese();
	}

	public void deletePiesaById(int id) {
		piesaRepository.deletePiesa(id);
	}

	public Piesa getPiesaById(int id) {
		return piesaRepository.getPiesa(id);
	}

	public void updatePiesa(Piesa piesa) {
		piesaRepository.updatePiesa(piesa);	
	}


	public void addPiesa(Piesa piesa) {
		piesaRepository.addPiesa(piesa);
	}

}
