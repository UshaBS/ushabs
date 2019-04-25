package com.cap.dev.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SequenceGenerator(name = "seq", sequenceName = "seq", initialValue = 100, allocationSize = 1)
public class Application {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int applicationId;

	@NotNull(message = "This field is manadatory")
	private String fullName;
	@NotNull(message = "This field is manadatory")
	private String dateOfBirth;
	@NotNull(message = "This field is manadatory")
	private String highestQualification;
	@NotNull(message = "This field is manadatory")
	private double marksObtained;
	@NotNull(message = "This field is manadatory")
	private String goals;
	@NotNull(message = "This field is manadatory")
	private String emailId;
	@NotNull(message = "This field is manadatory")
	private int scheduledProgramId;

	private String status = "applied";
	private String dateOfInterview = null;

	
	  @JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "scheduledProgramId",insertable = false,updatable =false)
	 private ProgramsScheduled programsScheduled;


	public int getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getHighestQualification() {
		return highestQualification;
	}


	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}


	public double getMarksObtained() {
		return marksObtained;
	}


	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}


	public String getGoals() {
		return goals;
	}


	public void setGoals(String goals) {
		this.goals = goals;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	


	public int getScheduledProgramId() {
		return scheduledProgramId;
	}


	public void setScheduledProgramId(int scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDateOfInterview() {
		return dateOfInterview;
	}


	public void setDateOfInterview(String dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}


	public ProgramsScheduled getProgramsScheduled() {
		return programsScheduled;
	}


	public void setProgramsScheduled(ProgramsScheduled programsScheduled) {
		this.programsScheduled = programsScheduled;
	}
	 

	

}
