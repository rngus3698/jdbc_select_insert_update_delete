package controller;

import java.util.Scanner;

import model.dao.JDBCmodel;
import model.vo.Student;

public class TestMain {
	
	static Scanner sc = new Scanner(System.in);

	JDBCmodel model = new JDBCmodel();
	
	public static void main(String[] args)
	{
		TestMain tMain = new TestMain(); 
		
		
		while(true)
		{
			System.out.println("1. select");
			System.out.println("2. insert");
			System.out.println("3. update");
			System.out.println("4. delete");
			System.out.println("5. 종료");
			System.out.print("번호를 선택해주세여 : ");
			int useranwer = sc.nextInt();
			
			switch(useranwer)
			{
			case 1:
				tMain.select();
				break;
			case 2:
				tMain.insert();
				break;
			case 3:
				tMain.update();
				break;
			case 4:
				tMain.dalete();
				break;
			case 5:
				System.out.println("종료");
				break;
			}
		}
	}
	
	public void select()
	{
		sc.nextLine();
		System.out.print("조회할 아이디 : ");
		String id = sc.nextLine();
		
		model.selectId(id);
	}
	
	public void insert()
	{
		sc.nextLine();
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("pwd : ");
		String pwd = sc.nextLine();
		System.out.print("name : ");
		String name = sc.nextLine();
		System.out.print("gender : ");
		String gender = sc.nextLine();
		System.out.print("email : ");
		String email = sc.nextLine();
		System.out.print("phone : ");
		String phone = sc.nextLine();
		System.out.print("address : ");
		String address = sc.nextLine();
		System.out.print("age : ");
		int age = sc.nextInt();
		
		Student std = new Student(id, pwd, name, gender, email, phone, address, age);
		
		model.insert(std);
	}
	
	public void update()
	{
		sc.nextLine();
		System.out.print("변경할 아이디를 입력하세요 : ");
		String changeId = sc.nextLine();
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("pwd : ");
		String pwd = sc.nextLine();
		System.out.print("name : ");
		String name = sc.nextLine();
		System.out.print("gender : ");
		String gender = sc.nextLine();
		System.out.print("email : ");
		String email = sc.nextLine();
		System.out.print("phone : ");
		String phone = sc.nextLine();
		System.out.print("address : ");
		String address = sc.nextLine();
		System.out.print("age : ");
		int age = sc.nextInt();
		
		Student updateStd = new Student(id, pwd, name, gender, email, phone, address, age);
		
		model.updateId(updateStd, changeId);
	}
	
	public void dalete()
	{
		sc.nextLine();
		System.out.print("삭제할 아이디를 입력하세요 : ");
		String id = sc.nextLine();
		model.deleteId(id);
	}

}
