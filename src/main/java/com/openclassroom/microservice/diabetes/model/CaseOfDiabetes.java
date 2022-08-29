package com.openclassroom.microservice.diabetes.model;

import java.util.List;

public class CaseOfDiabetes
{
	private List<String> patientNote;
	private String patientBirthdate;
	private String patientGender;
	
	public CaseOfDiabetes()
	{
		super();
	}

	public CaseOfDiabetes(List<String> patientNote, String patientBirthdate, String patientGender)
	{
		super();
		this.patientNote = patientNote;
		this.patientBirthdate = patientBirthdate;
		this.patientGender = patientGender;
	}
	
	

	public List<String> getPatientNote()
	{
		return patientNote;
	}

	public void setPatientNote(List<String> patientNote)
	{
		this.patientNote = patientNote;
	}

	public String getPatientBirthdate()
	{
		return patientBirthdate;
	}

	public void setPatientBirthdate(String patientBirthdate)
	{
		this.patientBirthdate = patientBirthdate;
	}

	public String getPatientGender()
	{
		return patientGender;
	}

	public void setPatientGender(String patientGender)
	{
		this.patientGender = patientGender;
	}
	
	
	
	


	
	
}
