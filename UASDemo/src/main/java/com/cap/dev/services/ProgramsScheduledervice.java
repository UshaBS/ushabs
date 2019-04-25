package com.cap.dev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.entities.ProgramsScheduled;

import com.cap.dev.repositries.ProgramsScheduledRepo;


@Service
public class ProgramsScheduledervice{
	
	@Autowired
	private ProgramsScheduledRepo programsscheduledrepo;
	
	public List<ProgramsScheduled> getAllPrograms() {
		return programsscheduledrepo.findAll();
	}

	
	public ProgramsScheduled addProgramsScheduled(ProgramsScheduled programscheduled) {
		
		return programsscheduledrepo.save(programscheduled);
	}


	public ProgramsScheduled updateProgramsScheduled(ProgramsScheduled programscheduled) {
	    return programsscheduledrepo.save(programscheduled);
	}


	public String deleteProgramsScheduled(int scheduledProgramId) {
		programsscheduledrepo.deleteById(scheduledProgramId);
		return "Program got deleted successfully";
	}


	/*
	 * public Programs_Scheduled getParticularProgram(String startDate, String
	 * endDate) { return
	 * programsscheduledrepo.getParticularProgram(startDate,endDate); }
	 */

	

}
