package com.demo.hatch_demo.service;

import com.demo.hatch_demo.model.HatchPerson;
import com.demo.hatch_demo.model.HatchPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HatchPersonService {
	private final HatchPersonRepository hatchPersonRepository;

	@Transactional(readOnly = true)
	public List<HatchPerson> findAll() {
		return hatchPersonRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<HatchPerson> findByAgeLessThan(int age) {
		return Optional.ofNullable(hatchPersonRepository.findByAgeLessThan(age))
				.orElse(Collections.emptyList());
	}

	@Transactional
	public HatchPerson create(HatchPerson hatchPerson) {
		return hatchPersonRepository.create(hatchPerson);
	}

}
