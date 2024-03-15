package com.institutemanagement.intituteService;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.institutemanagement.intituteRepo.InsituteRepository;
import com.institutemanagement.model.Institute;

@Service
public class InstituteServiceImpl implements InsituteService{
	
	@Autowired
	private InsituteRepository instituteRepository;

	
	public Institute RegistorInstitute(Institute institute) {
		
		Institute inst=instituteRepository.save(institute);
		
		return inst;
	}
	
	
	public Optional<Institute> getInstituteById(Long id) {
		
		return instituteRepository.findById(id);
	}


	public Institute updateInstitute(Long id, Institute updatedInstitute) {
		
		Institute existingInstitute=instituteRepository.findById(id).get();
		
		existingInstitute.setInstituteName(updatedInstitute.getInstituteName());	
		existingInstitute.setLocation(updatedInstitute.getLocation());
		existingInstitute.setContactInfo(updatedInstitute.getContactInfo());
		
		return instituteRepository.save(existingInstitute);
	}

	
	public Institute updateInstituteFields(int id, Map<String, Object> fields) {
		Optional<Institute> existingProduct = instituteRepository.findById((long) id);

        if (existingProduct.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Institute.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingProduct.get(), value);
            });
            return instituteRepository.save(existingProduct.get());
        }
      return null;
	}

	
	public long deleteInstitute(int id) {
		instituteRepository.deleteById((long) id);
        return instituteRepository.count();
		
	}

	

}
