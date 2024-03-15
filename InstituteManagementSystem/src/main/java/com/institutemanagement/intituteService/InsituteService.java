package com.institutemanagement.intituteService;

import java.util.Map;
import java.util.Optional;

import com.institutemanagement.model.Institute;

public interface InsituteService {

	public Institute RegistorInstitute(Institute institute);
	
	public Optional<Institute> getInstituteById(Long id);
	
	public Institute updateInstitute(Long id, Institute updatedInstitute);
	
	public Institute updateInstituteFields(int id, Map<String, Object> fields);
	
	public long deleteInstitute(int id);
	

}
