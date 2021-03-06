package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {
		SectionID = UUID.randomUUID();
		StudentID = UUID.randomUUID();
		EnrollmentID = UUID.randomUUID();
	}

	public Enrollment(UUID sectionID, UUID studentID) {
		SectionID = sectionID;
		StudentID = studentID;
		EnrollmentID = UUID.randomUUID();
	}
	
	public void SetGrade(double grade) {
		Grade = grade;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public double getGrade() {
		return Grade;
	}
	
	
	
	
}
