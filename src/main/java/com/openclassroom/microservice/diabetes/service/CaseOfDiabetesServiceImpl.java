package com.openclassroom.microservice.diabetes.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.openclassroom.microservice.diabetes.model.CaseOfDiabetes;

@Service
public class CaseOfDiabetesServiceImpl implements CaseOfDiabetesService
{
	
	List<String> diabetesTrigger = new ArrayList<>();
	
	public void listInit()
	{
		
		diabetesTrigger.addAll(Arrays.asList(
				"hémoglobine A1C", 
				"microalbumine", 
				"taille",
				"poids",
				"fumeur",
				"anormal",
				"cholestérol",
				"vertige",
				"rechute",
				"réaction",
				"anticorps"));
	}
	
	
	public int risk(CaseOfDiabetes patient)
	{
		diabetesTrigger.clear();
		
		listInit();
		
		int trigger = 0;
		
		for (String split : patient.getPatientNote())
		{
			for (String string : diabetesTrigger)
			{
				
				if(split.contains(string))
				{
					trigger++;
				}
				
			}
		}
		return trigger;
		
	}
	

	@Override
	public boolean noneCase(CaseOfDiabetes patient)
	{
		
		int trigger = risk(patient);
		
		if (trigger == 0)
		{
			return true;
		}
		
		
		return false;
		
	}



	@Override
	public boolean borderlineCase(CaseOfDiabetes patient)
	{
		
		try
		{
			
			int trigger = risk(patient);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
			Date birthdate = sdf.parse(patient.getPatientBirthdate());
			Date now = new Date();

			long age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

			if (trigger == 2 && trigger < 6 && age > 30)		{
				return true;
			}
			
		} 
		
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}



	@Override
	public boolean inDangerCase(CaseOfDiabetes patient)
	{
		
		try
		{
			
			int trigger = risk(patient);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
			Date birthdate = sdf.parse(patient.getPatientBirthdate());
			Date now = new Date();

			long age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

			
			
			if (trigger == 3 && age <= 30 && patient.getPatientGender().equals("M"))		{
				return true;
			}
			
			else if (trigger == 4 && age <= 30 && patient.getPatientGender().equals("F"))		{
				return true;
			}
			
			else if (trigger >= 6 && trigger < 8 && age > 30)		{
				return true;
			}
			
			
		} 
		
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}



	@Override
	public boolean earlyOnsetCase(CaseOfDiabetes patient)
{
		
		try
		{
			
			int trigger = risk(patient);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
			Date birthdate = sdf.parse(patient.getPatientBirthdate());
			Date now = new Date();

			long age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

			
			
			if (trigger == 5 && age <= 30 && patient.getPatientGender().equals("M"))		{
				return true;
			}
			
			else if (trigger == 7 && age <= 30 && patient.getPatientGender().equals("F"))		{
				return true;
			}
			
			else if (trigger >= 8 && age > 30)		{
				return true;
			}
			
			
		} 
		
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	

}
