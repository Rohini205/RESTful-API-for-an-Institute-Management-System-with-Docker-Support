package com.institutemanagement.intituteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.institutemanagement.intituteRepo.InsituteRepository;
import com.institutemanagement.model.Institute;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc 
@SpringBootTest
@ContextConfiguration
public class InstituteServiceImplTest {
	
	@InjectMocks
	InstituteServiceImpl instituteServiceImpl;
	
	@Mock
	InsituteRepository repo;
	
	@Test
	public void RegistorInstitute() {
		
		Institute institute=new Institute();
		
		institute.setId(1L);
		institute.setInstituteName("GIB");
		institute.setLocation("Nipani");
		institute.setContactInfo("097683654");
		
		
		when(repo.save(institute)).thenReturn(institute);
		
		//To check request object and response object are same or not
		assertEquals(institute, instituteServiceImpl.RegistorInstitute(institute));
		
		//Institute institute2=instituteServiceImpl.AddInstitute(institute);
		
		//assertEquals("Nipani", "Nipani");
		
	}
	
	
}
