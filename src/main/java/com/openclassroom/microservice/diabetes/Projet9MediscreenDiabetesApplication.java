package com.openclassroom.microservice.diabetes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassroom.microservice.diabetes.model.CaseOfDiabetes;
import com.openclassroom.microservice.diabetes.service.CaseOfDiabetesServiceImpl;

@SpringBootApplication
public class Projet9MediscreenDiabetesApplication implements CommandLineRunner  {

	
	@Autowired
	CaseOfDiabetesServiceImpl cases;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Projet9MediscreenDiabetesApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception
	{
		
		
		
		
		
		
//		CaseOfDiabetes c = new CaseOfDiabetes();
//		
//		List<String> list = new ArrayList<>();
//		list.add("Microalbumine");
//		list.add("Poids");
//		
//		c.setPatientBirthdate("01-01-1980");
//		
//		
//		String result = cases.borderlineCase(c);
//		
//		System.out.println(result);
		
		
	}

}
