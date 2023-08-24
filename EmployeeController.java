package com.jsp.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.EmployeeDto;
import com.jsp.exception.EmployeeException;

public class EmployeeController {

	public static void main(String[] args) throws SQLException, Exception {
		System.out.println("**Enter the Employee Details**");
		Scanner sc = new Scanner(System.in);
		EmployeeDto dto = new EmployeeDto();
		EmployeeDao dao = new EmployeeDao();
		System.out.println("****Select the Opration****");
		System.out.println("1.Add the Details");
		System.out.println("2.Get by Id emp Details");
		System.out.println("3.Get all emp Details");
		System.out.println("4.Update the Details");
		System.out.println("5.Delete the Details");
		int choice = sc.nextInt();
		switch(choice) {
		case  1:
			int adding=0;
			while(adding==0) {
			System.out.println("Enter the Employee Id: ");
			dto.setId(sc.nextInt());
			System.out.println("Enter the Employee Name: ");
			dto.setName(sc.next());
			System.out.println("Enter the Employee Designation: "); 
			dto.setDesig(sc.next());
			System.out.println("Enter the Employee Salary: ");
			dto.setSalary(sc.nextDouble());
//			EmployeeDao dao = new EmployeeDao();
			dao.create(dto);
			System.out.println("Want to Add More Employee press 0 for exit press 1 ...");
			adding = sc.nextInt();
			if(adding == 1) {
				System.out.println("***Thank You...***");
			}
			}
			break;
		case  2:
			System.out.println("Enterthe Employee Id: ");
			dto.setId(sc.nextInt());
			try {
				dao.readId(dto);
			}catch(EmployeeException e) {
				System.out.println(e.getmsg());
			}
			break;
		case  3:
			dao.readAll();
			break;
		case  4:
			System.out.println("Enterthe Employee Id: ");
			dto.setId(sc.nextInt());
			try {
				dao.update(dto);
			}catch(EmployeeException e) {
				System.out.println(e.getmsg());
			}
			break;
		case  5:
			System.out.println("Enterthe Employee Id: ");
			dto.setId(sc.nextInt());
			try {
				dao.delete(dto);
			}catch(EmployeeException e) {
				System.out.println(e.getmsg());
			}
			break;	
		}
	}
}
