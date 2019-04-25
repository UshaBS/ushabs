package com.cap.dev.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProgramsOffered {
	
@Id	
@Column
@NotNull(message = "Program name is mandatory")
private String programName;

@NotNull(message = "Description is mandatory")
private String description;

@NotNull(message = "Applicant eligibility is mandatory")
private String applicantEligibility;

@NotNull(message = "Duration is mandatory")
public int duration;

@NotNull(message = "Degree certificate is mandatory")
public String degreeCertificateOffered;

	
 @JsonIgnore
 @OneToMany(mappedBy ="programsOffered")
 private List<ProgramsScheduled> programScheduled;




public String getProgramName() {
	return programName;
}


public void setProgramName(String programName) {
	this.programName = programName;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getApplicantEligibility() {
	return applicantEligibility;
}


public void setApplicantEligibility(String applicantEligibility) {
	this.applicantEligibility = applicantEligibility;
}


public int getDuration() {
	return duration;
}


public void setDuration(int duration) {
	this.duration = duration;
}


public String getDegreeCertificateOffered() {
	return degreeCertificateOffered;
}


public void setDegreeCertificateOffered(String degreeCertificateOffered) {
	this.degreeCertificateOffered = degreeCertificateOffered;
}





}
