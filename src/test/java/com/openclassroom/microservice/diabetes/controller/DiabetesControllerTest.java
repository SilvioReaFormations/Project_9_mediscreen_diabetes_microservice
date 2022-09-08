package com.openclassroom.microservice.diabetes.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.microservice.diabetes.model.CaseOfDiabetes;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DiabetesControllerTest
{

	@Autowired
	CaseOfDiabetesController controller;
	


	CaseOfDiabetes patient = new CaseOfDiabetes();
	List<String> listTest = new ArrayList<>();
	
	
	
	@Test
	public void getCaseTestNoneResult()
	{
		
		listTest.add("everything is ok");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);
		
		String result = controller.getCase(1, patient);
		
		assertTrue(result.equals("none"));
		
	}
	
	
	@Test
	public void getCaseTestBorderlineResult()
	{
		
		listTest.add("note test avec 2 mots clés déclencheurs : vertige anormal");

		patient.setPatientBirthdate("1945-06-24");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);
		
		String result = controller.getCase(2, patient);
		
		assertTrue(result.equals("borderline"));
		
	}
	
	
}
