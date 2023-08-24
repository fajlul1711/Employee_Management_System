package com.jsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jsp.cofiguration.Configuration;
import com.jsp.dto.EmployeeDto;
import com.jsp.exception.EmployeeException;

public class EmployeeDao {

	public void create(EmployeeDto dto) throws SQLException, Exception {
		PreparedStatement ps = Configuration.configure().prepareStatement("insert into emp values(?,?,?,?)");
		ps.setInt(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getDesig());
		ps.setDouble(4, dto.getSalary());
		boolean flag = ps.execute();
		if (flag == false) {
			System.out.println(dto.getId() + " Employee Details Added Sucessfully!!!!........");
		} else {
			System.out.println(dto.getId() + " Employee Details Not Added");
		}

	}

	public void readId(EmployeeDto dto) throws SQLException, Exception {
		PreparedStatement ps = Configuration.configure().prepareStatement("select * from emp where id=?");
		ps.setInt(1, dto.getId());
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			System.out.println("Employee Id is : " + result.getInt(1));
			System.out.println("Employee Name is : " + result.getString(2));
			System.out.println("Employee Designation is : " + result.getString(3));
			System.out.println("Employee Salary is : " + result.getDouble(4));
		} else {
			throw new EmployeeException("Employee Id not Present!!!..");
		}
	}

	public void readAll() throws Exception {
		PreparedStatement ps = Configuration.configure().prepareStatement("select * from emp");
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			System.out.println("Employee Id is : " + result.getInt(1));
			System.out.println("Employee Name is : " + result.getString(2));
			System.out.println("Employee Designation is : " + result.getString(3));
			System.out.println("Employee Salary is : " + result.getDouble(4));
			System.out.println("--------------------------------------");
		}

	}

	public void update(EmployeeDto dto) throws Exception {
		PreparedStatement ps = Configuration.configure().prepareStatement("select * from emp where id=?");
		ps.setInt(1, dto.getId());
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Employee Name: ");
			dto.setName(sc.next());
			System.out.println("Enter the Employee Designation: ");
			dto.setDesig(sc.next());
			System.out.println("Enter the Employee Salary: ");
			dto.setSalary(sc.nextDouble());
			PreparedStatement ps1 = Configuration.configure()
					.prepareStatement("update emp set name=?, desig=?, sal=? where id=?");
			ps1.setString(1, dto.getName());
			ps1.setString(2, dto.getDesig());
			ps1.setDouble(3, dto.getSalary());
			ps1.setInt(4, dto.getId());
			int x = ps1.executeUpdate();
			if (x == 1) {
				System.out.println(dto.getId() + " Employee Details Update Successfully!!!!....");
			} else {
				throw new EmployeeException(dto.getId() + " Employee Id Not Found!!!...");
			}

		}

	}

	public void delete(EmployeeDto dto) throws Exception {
		PreparedStatement ps = Configuration.configure().prepareStatement("select * from emp where id=?");
		ps.setInt(1, dto.getId());
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			PreparedStatement ps1 = Configuration.configure().prepareStatement(" delete from emp where id=?");
			ps1.setInt(1, dto.getId());
			int x = ps1.executeUpdate();
			if (x == 1) {
				System.out.println(dto.getId() + " Employee Details Deleted Sucessfully....");
			} else {
				throw new EmployeeException(dto.getId() + " Employee Id Not Found!!!...");
			}
		}

	}

}
