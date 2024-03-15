package com.institutemanagement.intituteRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.institutemanagement.model.Institute;


@Repository
public interface InsituteRepository extends JpaRepository<Institute, Long> {
	

}
