package com.cap.dev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.dev.Exception.UniversityAdmissionException;
import com.cap.dev.entities.Application;
import com.cap.dev.entities.ProgramsOffered;
import com.cap.dev.entities.ProgramsScheduled;
import com.cap.dev.services.ApplicantService;
import com.cap.dev.services.ProgramsOfferedService;
import com.cap.dev.services.ProgramsScheduledervice;

@RestController
public class AppController {
@Autowired
	private ApplicantService applicantServ;
	
	@Autowired
	private ProgramsScheduledervice programsScheduledServ;
	
	@Autowired
	private ProgramsOfferedService programsOfferedServ;


	/************************************Applicant services*********************************************/
	

@RequestMapping(value="/scheduledprograms")	
public List<ProgramsScheduled> getAllPrograms() throws UniversityAdmissionException{
	try{
		return programsScheduledServ.getAllPrograms();
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/applyapplication",method=RequestMethod.POST)
public Application applyApplication(@RequestBody Application application) throws UniversityAdmissionException {
	try {
	return applicantServ.applyApplication(application);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(500,e.getMessage());
	}
}


@RequestMapping(value="/getapplicationstatus/{applicationId}")
public String getApplicationStatus(@PathVariable int applicationId) throws UniversityAdmissionException {
	try{
		return applicantServ.getApplicationStatus(applicationId);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
	
}


/***************************MAC Services***************************************/


@RequestMapping(value="/getapplication/{scheduledProgramId}")
public Application getApplications(@PathVariable int scheduledProgramId) throws UniversityAdmissionException {
	try{
		return applicantServ.getApplications(scheduledProgramId);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/applicationstatus/{applicationId}",method=RequestMethod.PUT)
public Application acceptOrReject(@RequestBody Application application,@PathVariable int applicationId) throws UniversityAdmissionException {
	try{
		return applicantServ.acceptOrReject(application,applicationId);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}









/********************************Administration Services********************************************************/


/*****************************************ProgramsScheduled*****************************************/


@RequestMapping(value="/programsScheduled",method=RequestMethod.POST)
public ProgramsScheduled addProgramsScheduled(@RequestBody ProgramsScheduled programscheduled) throws UniversityAdmissionException {
	try{
		return programsScheduledServ.addProgramsScheduled(programscheduled);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(400,e.getMessage());
	}
}


@RequestMapping(value="/programsScheduled",method=RequestMethod.PUT)
public ProgramsScheduled updateProgramsScheduled(@RequestBody ProgramsScheduled programscheduled) throws UniversityAdmissionException {
	try{
		return programsScheduledServ.updateProgramsScheduled(programscheduled);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/programsScheduled/{scheduledProgramId}",method=RequestMethod.DELETE)
public String deleteProgramsScheduled(@PathVariable int scheduledProgramId) throws UniversityAdmissionException {
	try{
		return programsScheduledServ.deleteProgramsScheduled(scheduledProgramId);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}

}


/*****************************************ProgramsOffered******************************************/


@RequestMapping(value="/programsOfferedpost",method=RequestMethod.POST)
public ProgramsOffered addProgramsOffered(@RequestBody ProgramsOffered programsOffered) throws UniversityAdmissionException {
	try{
		return programsOfferedServ.addProgramsOffered(programsOffered);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}



@RequestMapping(value="/programsOffered",method=RequestMethod.PUT)
public ProgramsOffered updateProgramsOffered(@RequestBody ProgramsOffered programsOffered,@PathVariable String programName) throws UniversityAdmissionException {
	try{
		return programsOfferedServ.updateProgramsOffered(programsOffered,programName);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}

@RequestMapping(value="/programsOffered/{programName}",method=RequestMethod.DELETE)
public String deleteProgramsOffered(@PathVariable String programName) throws UniversityAdmissionException {
	try{
		return programsOfferedServ.deleteProgramsOffered(programName);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}


@RequestMapping(value="/programsOffered")	
public List<ProgramsOffered> getPrograms() throws UniversityAdmissionException{
	try{
		return programsOfferedServ.getPrograms();
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}
/***************************Applicant ******************************/


@RequestMapping(value="/applicationGet/{status}",method=RequestMethod.GET)
public List<Application> getAllApplicants(@PathVariable String status) throws UniversityAdmissionException {
	try{
		return applicantServ.getApplicants(status);
	}
	catch(Exception e) {
		throw new UniversityAdmissionException(204,e.getMessage());
	}
}


	/*
	 * @RequestMapping(value="/ProgramsScheduledProgram/{start_date}/{end_date}")
	 * public Programs_Scheduled getParticularProgram(@PathVariable String
	 * start_date,@PathVariable String end_date) throws UniversityAdmissionException
	 * { start_date=start_date.replace('-', '/'); end_date=end_date.replace('-',
	 * '/'); try{ return
	 * programsScheduledServ.getParticularProgram(start_date,end_date); }
	 * catch(Exception e) { throw new
	 * UniversityAdmissionException(204,e.getMessage()); } }
	 */


}
