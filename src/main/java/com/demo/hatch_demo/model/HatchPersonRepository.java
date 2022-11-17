package com.demo.hatch_demo.model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// * hard coding data as map for demo purposes. This would normally be an interface.
// * Methods below are not implemented when using actual repo
@Component
public class HatchPersonRepository {

	public static final Map<Long, HatchPerson> database = new HashMap<>();

	static {
		database.put(1L, new HatchPerson(1L, "Lily", 1));
		database.put(2L, new HatchPerson(2L, "Oreo", 12));
		database.put(3L, new HatchPerson(3L, "Katie", 30));
		database.put(4L, new HatchPerson(4L, "Sienna", 2));
		database.put(5L, new HatchPerson(5L, "Leo", 1));
	}

	HatchPersonRepository() {
	}

	public List<HatchPerson> findByAgeLessThan(int age) {
		return database.values().stream().filter(h -> h.getAge() < age).collect(Collectors.toList());
	}

	public List<HatchPerson> findAll() {
		return new ArrayList<>(database.values());
	}

	public HatchPerson create(HatchPerson hatchPerson) {
		database.put(hatchPerson.getId(), hatchPerson);
		return hatchPerson;
	}


}
