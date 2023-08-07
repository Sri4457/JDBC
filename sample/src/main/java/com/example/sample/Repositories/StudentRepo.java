package com.example.sample.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.sample.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{

	@Query(value="select id from student where stdid=:stdid ",nativeQuery=true)
	long findByStdid(@Param("stdid") String stdid); 
	
}
