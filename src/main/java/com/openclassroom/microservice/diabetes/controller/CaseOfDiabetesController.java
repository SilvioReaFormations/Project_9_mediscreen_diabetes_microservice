package com.openclassroom.microservice.diabetes.controller;


import com.openclassroom.microservice.diabetes.model.CaseOfDiabetes;
import com.openclassroom.microservice.diabetes.service.CaseOfDiabetesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseOfDiabetesController
{
	@Autowired
	CaseOfDiabetesService service;
	
	
	@PostMapping("/patient/read/{id}/case/getCase")
	public String getCase(@PathVariable("id") Integer id, @RequestBody CaseOfDiabetes caseOfDiabetes)
	{
		String result = "le cas du patient ne correspond à aucun des 4 cas";
		
		if (service.noneCase(caseOfDiabetes))
		{
			result = "none";
		}
		
		else if (service.borderlineCase(caseOfDiabetes))
		{
			result = "borderline";
		}
		
		else if (service.inDangerCase(caseOfDiabetes))
		{
			result = "in danger";
		}
		
		else if (service.earlyOnsetCase(caseOfDiabetes))
		{
			result = "early on set";
		}
		
	
		return result;
	}

}
