package com.cap.dev.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "scheduledProgramID")
public class ProgramsScheduled {
	@Id
	@SequenceGenerator(name="myseq",sequenceName ="program_seq", initialValue= 1000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myseq")
	private int scheduledProgramId;
	
	@NotNull(message = "ProgramName is Mandatory")
	private String  programName;
	
	@NotNull(message = "location is Mandatory")
	private String location;
	
	@NotNull(message = "Startdate is Mandatory")
	private String startDate;
	
	@NotNull(message = "Enddate is Mandatory")
	private String endDate;
	
	@NotNull(message = "Sessions per week is Mandatory")
	private int sessionsPerWeek;
	
	
	 @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JoinColumn(name="programName",insertable = false,updatable = false)
	 private ProgramsOffered programsOffered;
	
	 
	  public ProgramsOffered getProgramsOffered() {
		return programsOffered;
	}

	public void setProgramsOffered(ProgramsOffered programsOffered) {
		this.programsOffered = programsOffered;
	}

	@JsonIgnore
	  @OneToMany(mappedBy = "programsScheduled")
	  private List<Application> application;

	

	public int getScheduledProgramId() {
		return scheduledProgramId;
	}

	public void setScheduledProgramId(int scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}

	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}

	

	
	
	
	

}
