package com.openclassroom.microservice.diabetes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.microservice.diabetes.model.CaseOfDiabetes;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DiabetesServiceTest
{

	@InjectMocks
	CaseOfDiabetesServiceImpl service;

	CaseOfDiabetes patient = new CaseOfDiabetes();
	List<String> listTest = new ArrayList<>();

	@Test
	public void riskTest()
	{

		listTest.add("le patient est un fumeur");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertEquals(1, service.risk(patient));

	}

	@Test
	public void noneCaseTestTrue()
	{
		listTest.add("everything is ok");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertTrue(service.noneCase(patient));

	}

	@Test
	public void noneCaseTestFalse()
	{
		listTest.add("le patient est un fumeur");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertFalse(service.noneCase(patient));

	}

	@Test
	public void borderlineCaseTestTrue()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient de petite taille");

		patient.setPatientBirthdate("1986-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertTrue(service.borderlineCase(patient));

	}
	
	@Test
	public void borderlineCaseTestFalse()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient de petite taille");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertFalse(service.borderlineCase(patient));

	}
	
	

	@Test
	public void inDangerCaseTestTrueWithMan()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertTrue(service.inDangerCase(patient));

	}
	
	@Test
	public void inDangerCaseTestTrueWithWoman()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("hémoglobine A1C");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("F");
		patient.setPatientNote(listTest);

		assertTrue(service.inDangerCase(patient));

	}
	
	@Test
	public void inDangerCaseTestTrueWithSixWords()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("hémoglobine A1C, vertige, rechute");

		patient.setPatientBirthdate("1980-01-01");
		patient.setPatientGender("F");
		patient.setPatientNote(listTest);

		assertTrue(service.inDangerCase(patient));

	}
	
	@Test
	public void inDangerCaseTestFalseWithSixWords()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("hémoglobine A1C, vertige");

		patient.setPatientBirthdate("1980-01-01");
		patient.setPatientGender("F");
		patient.setPatientNote(listTest);

		assertFalse(service.inDangerCase(patient));

	}
	
	@Test
	public void inDangerCaseTestFalseWithWoman()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
	

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("F");
		patient.setPatientNote(listTest);

		assertFalse(service.inDangerCase(patient));

	}

	
	
	
	
	@Test
	public void earlyOnSetCaseTestTrueWithMan()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("patient a un poids anormal");
	

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertTrue(service.earlyOnsetCase(patient));
	}
	
	@Test
	public void earlyOnSetCaseTestFalseWithMan()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertFalse(service.earlyOnsetCase(patient));
	}
	
	@Test
	public void earlyOnSetCaseTestTrueWithWoman()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("patient a un poids anormal");
		listTest.add("réaction anticorps");
	

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("F");
		patient.setPatientNote(listTest);

		assertTrue(service.earlyOnsetCase(patient));
	}
	
	@Test
	public void earlyOnSetCaseTestFalseWithWoman()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("patient a un poids anormal");

		patient.setPatientBirthdate("2000-01-01");
		patient.setPatientGender("F");
		patient.setPatientNote(listTest);

		assertFalse(service.earlyOnsetCase(patient));
	}
	
	@Test
	public void earlyOnSetCaseTestTrueWithMoreThan8Words()
	{
		listTest.add("le patient est un fumeur");
		listTest.add("patient a un poids anormal");
		listTest.add("patient a un poids anormal");
		listTest.add("patient a un poids anormal");
		listTest.add("patient a un poids anormal");
	

		patient.setPatientBirthdate("1980-01-01");
		patient.setPatientGender("M");
		patient.setPatientNote(listTest);

		assertTrue(service.earlyOnsetCase(patient));
	}
}
