package com.fdm.service;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.model.Piesa;
import com.fdm.repository.PiesaRepo;

@Service
public class PiesaService {
	
	private PiesaRepo piesaRepo;


	@Autowired
	public PiesaService(PiesaRepo piesaRepo) {
		this.piesaRepo = piesaRepo;
	}

	public Set<Piesa> getAllPieces() {
//		return piesaRepo.getAllPiese();
		return piesaRepo.findAll().stream().collect(Collectors.toSet());
	}

	public void deletePiesaById(int id) {
//		piesaRepo.deletePiesa(id);
		piesaRepo.deleteById(id);
	}

	public Piesa getPiesaById(int id) {
//		return piesaRepository.getPiesa(id);
		return piesaRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Piesa cu id-ul " + id + " nu a fost găsită"));
	}

	public void updatePiesa(Piesa piesa) {
//		piesaRepository.updatePiesa(piesa);	
		piesaRepo.save(piesa);
	}

	public void addPiesa(Piesa piesa) {
//		piesaRepository.addPiesa(piesa);
		piesaRepo.save(piesa);
	}

}
