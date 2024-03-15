package com.institutemanagement.instituteController;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institutemanagement.intituteService.InsituteService;
import com.institutemanagement.intituteService.InstituteServiceImpl;
import com.institutemanagement.model.Institute;

@RestController
@RequestMapping("/institute")
public class InstitueController {
	
	@Autowired
	private InsituteService institueService;
	
	//Institute Registration:
	@PostMapping("/Registration")
	public ResponseEntity<?> RegistorInstitute(@RequestBody Institute institute){
		Institute instituteReg=institueService.RegistorInstitute(institute);
		return new ResponseEntity<Institute>(instituteReg,HttpStatus.CREATED);
	}
	
	//Institute Information Retrieval:
	@GetMapping("/{id}")
	public Optional<Institute> getInstituteById(@PathVariable Long id){
		Optional<Institute> institute=institueService.getInstituteById(id);
		return institute;
		
	}
	
	//Modification entire institute resource:
	@PutMapping("/updateInstitute/{id}")
	public Institute updateInstituteDetails(@PathVariable Long id, @RequestBody Institute updatedInstitute) {
		Institute institute = institueService.updateInstitute(id, updatedInstitute);
		return institute;
		
	}
	
	//Institute Modification by patches:
	@PatchMapping("/{id}")
    public Institute updatedInstituteFields(@PathVariable int id,@RequestBody Map<String, Object> fields){
        return institueService.updateInstituteFields(id,fields);
    }
	
	//Delete Institute :
	@DeleteMapping("/{id}")
    public long deleteIstitute(@PathVariable int id) {
        return institueService.deleteInstitute(id);
    }
	
 
}
