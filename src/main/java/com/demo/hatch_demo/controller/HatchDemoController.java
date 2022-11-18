package com.demo.hatch_demo.controller;


import com.demo.hatch_demo.model.HatchPerson;
import com.demo.hatch_demo.service.HatchPersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class HatchDemoController {
	private final HatchPersonService hatchPersonService;

	@GetMapping("/person")
	public List<HatchPerson> hatchPersonAll(@RequestParam(name = "ageLessThan") Integer age) {
		if (Objects.nonNull(age))
			return hatchPersonService.findByAgeLessThan(age);
		return hatchPersonService.findAll();
	}

	@PostMapping("/person")
	public HatchPerson create(@RequestBody HatchPerson hatchPerson) {
		return hatchPersonService.create(hatchPerson);
	}

}
