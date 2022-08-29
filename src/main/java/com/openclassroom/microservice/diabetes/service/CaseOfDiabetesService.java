package com.openclassroom.microservice.diabetes.service;

import com.openclassroom.microservice.diabetes.model.CaseOfDiabetes;

public interface CaseOfDiabetesService
{
	public boolean noneCase(CaseOfDiabetes caseOfDiabetes);
	public boolean borderlineCase(CaseOfDiabetes caseOfDiabetes);	
	public boolean inDangerCase(CaseOfDiabetes caseOfDiabetes);
	public boolean earlyOnsetCase(CaseOfDiabetes caseOfDiabetes);

}
