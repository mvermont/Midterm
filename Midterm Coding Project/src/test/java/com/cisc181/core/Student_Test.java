package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Semester> semesters = new ArrayList<Semester>();
	static ArrayList<Section> sections = new ArrayList<Section>();
	static ArrayList<Student> students = new ArrayList<Student>();
	
	
	@BeforeClass
	public static void setup() throws PersonException {
		courses.add(new Course(UUID.randomUUID(), "CISC181", 4, eMajor.COMPSI));
		courses.add(new Course(UUID.randomUUID(), "CHEM103", 4, eMajor.CHEM));
		courses.add(new Course(UUID.randomUUID(), "MISY100", 4, eMajor.BUSINESS));
		
		semesters.add(new Semester(UUID.randomUUID(), new Date(2017, 26, 8), new Date(2017, 20, 12)));
		semesters.add(new Semester(UUID.randomUUID(), new Date(2018, 6, 2), new Date(2018, 21, 5)));
		
		for(Semester s: semesters) {
			for(Course c: courses) {
				sections.add(new Section(c.getCourseID(),s.getSemesterID(), UUID.randomUUID(), (int)(Math.random()*400 + 100)));
			}
		}
		for(int n = 0; n < 10; n++) {
			students.add(new Student("Matthew", "David", "Vermont", new Date(1999, 23, 4), eMajor.COMPSI, "123 Street Rd", "(703)-123-2345", 
					"mvermont@udel.edu"));
		}
	}

	@Test
	public void test() {
		ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
		for(Student s: students) {
			enrollments.add(new Enrollment(sections.get((int) (Math.random()*sections.size())).getSectionID(), s.getStudentID()));
			enrollments.add(new Enrollment(sections.get((int) (Math.random()*sections.size())).getSectionID(), s.getStudentID()));
			enrollments.add(new Enrollment(sections.get((int) (Math.random()*sections.size())).getSectionID(), s.getStudentID()));
		}
		for(int enrollment1 = 0; enrollment1 < enrollments.size(); enrollment1++) {
			for(int enrollment2 = 0; enrollment2 < enrollments.size(); enrollment2++) {
				if(enrollments.get(enrollment1).getSectionID() == enrollments.get(enrollment2).getSectionID() &&
						enrollments.get(enrollment1).getStudentID() == enrollments.get(enrollment2).getStudentID()) {
					while(enrollments.get(enrollment1).getSectionID() == enrollments.get(enrollment2).getSectionID() &&
						enrollments.get(enrollment1).getStudentID() == enrollments.get(enrollment2).getStudentID()) {
						enrollments.set(enrollment2,new Enrollment(sections.get((int) (Math.random()*sections.size())).getSectionID(),
								enrollments.get(enrollment2).getStudentID()));
					}
				}
			}
		}
		System.out.println(enrollments.size());
		for(Enrollment e: enrollments) {
			System.out.println(e.getSectionID() + " " + e.getStudentID());
		}

		assertEquals(1, 1);
	}
}