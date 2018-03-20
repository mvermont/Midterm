package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	static ArrayList<Staff> staff = new ArrayList<Staff>();
	@BeforeClass
	public static void setup() throws PersonException {
		
		staff.add(new Staff("Matt", "David", "Vermont", new Date(), "1234 Street Rd", "(703)-123-3456", "matthew.vermont@udel.edu", 
				"9am - 11am", 2, 55100.01, new Date(2016, 1, 1), eTitle.MR));
		staff.add(new Staff("Matt", "David", "Vermont", new Date(), "1234 Street Rd", "(703)-123-3456", "matthew.vermont@udel.edu", 
				"9am - 11am", 2, 54000.00, new Date(2016, 1, 1), eTitle.MR));
		staff.add(new Staff("Matt", "David", "Vermont", new Date(), "1234 Street Rd", "(703)-123-3456", "matthew.vermont@udel.edu", 
				"9am - 11am", 2, 56100.01, new Date(2016, 1, 1), eTitle.MR));
		staff.add(new Staff("Matt", "David", "Vermont", new Date(), "1234 Street Rd", "(703)-123-3456", "matthew.vermont@udel.edu", 
				"9am - 11am", 2, 54000.00, new Date(2016, 1, 1), eTitle.MR));
		staff.add(new Staff("Matt", "David", "Vermont", new Date(), "1234 Street Rd", "(703)-123-3456", "matthew.vermont@udel.edu", 
				"9am - 11am", 2, 57500.00, new Date(2016, 1, 1), eTitle.MR));
	}
	
	@Test
	public void test() {
		double totalSalary = 0;
		for(Staff s: staff) {
			totalSalary += s.getSalary();			
		}
		assertEquals(55340.00,totalSalary/staff.size(), 0.01);
	}	
	
	@Test
	public void test2()  {
		try {
			staff.add(new Staff("Matt", "David", "Vermont", new Date(1999, 23, 4), "1234 Street Rd", "(703)1233456", "matthew.vermont@udel.edu", 
					"9am - 11am", 2, 55100.01, new Date(2016, 1, 1), eTitle.MR));
		} catch (PersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getPerson().getPhone());
		}
		try {
			staff.add(new Staff("Matt", "David", "Vermont", new Date(2119, 30, 2), "1234 Street Rd", "(703)-123-3456", "matthew.vermont@udel.edu", 
					"9am - 11am", 2, 55100.01, new Date(2016, 1, 1), eTitle.MR));
		} catch (PersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getPerson().getDOB().toString());
		}
	}

}
