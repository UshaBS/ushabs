package com.cap.dev.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cap.dev.entities.ProgramsScheduled;

@Repository
public interface ProgramsScheduledRepo extends JpaRepository<ProgramsScheduled,Integer>{

	

	/*
	 * @Query("SELECT e FROM  Programs_Scheduled e WHERE e.start_date=:start_date and e.end_date=:end_date"
	 * ) Programs_Scheduled getParticularProgram(@Param(value="start_date") String
	 * start_date,
	 * 
	 * @Param(value="end_date") String end_date);
	 * 
	 */

	
	
}
