package controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import model.dao.JDBCModel;
import model.vo.Employee;

public class TestMain {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		JDBCModel model = new JDBCModel();
		model.testJDBC(); //연결할려는 connection객체 
		
//		model.testJDBC3();
//		System.out.print("위에 아이디를 선택하여 아이디 입력 : ");
//		String empId = sc.nextLine();
//		model.testJDBC2(empId);
		
		
		//객체 생성 후 삽입
//		주 목적 : Calendar -> sql.Date형으로
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());	//1. Calendar -> util.Date
		
		//2. util.Date -> sql.Date형으로
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);
		System.out.print("empId 입력 : ");
		String empId = sc.nextLine();
		System.out.print("empName 입력 : ");
		String empName = sc.nextLine();
		System.out.print("empNo 입력 : ");
		String empNo = sc.nextLine();
		//hireDate같은 경우는 위에 있는 sqlDate값을 활용할 예정
		System.out.print("salary 입력(int) : ");
		int salary = sc.nextInt();
		System.out.print("bonusPct 입력(double) : ");
		double bonusPct = sc.nextDouble();
		
		Employee emp = new Employee(empId, empName, empNo, sqlDate, salary, bonusPct);
		
		Employee emp1 = new Employee(empId, empName, empNo, sqlDate, salary, bonusPct);
		
		model.testInsert(emp);
		model.testInsert2(emp1);
		
	}

}
