package controller;

import java.util.Scanner;

import model.dao.EmployeeModel;
import model.vo.Student;

public class TestJDBC {

	public static void main(String[] args) 
	{
		EmployeeModel model = new EmployeeModel();
		Scanner sc = new Scanner(System.in);
		
		// 모든 학생 조회
		model.selectAll();
		
		//키보드로 아이디를 입력 받아 학생 한명 조회
		System.out.print("사번 : ");
		String memberId = sc.nextLine();
		model.selectOne(memberId);

		//학생 추가를 위해 입력받은 정보를 insert
		System.out.print("회원 아이디 : ");
		String id = sc.nextLine();
		System.out.print("회원 패스워드 : ");
		String pwd = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		Student std = new Student(id, pwd, name, gender, email, phone, address, age);
		
		model.insertEmployee(std);

		//update
		System.out.print("수정할 회원 아이디 : ");
	    String serchid = sc.nextLine();
		
		System.out.print("회원 아이디 : ");
	    String changeid = sc.nextLine();
	      
	    System.out.print("회원 패스워드 : ");
		String changepassword = sc.nextLine();
		
		System.out.print("회원명 : ");
		String changename = sc.nextLine();
		
		System.out.print("성별 : ");
		String changegender = sc.nextLine();
		  
		System.out.print("이메일 : ");
		String changeemail = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String changephone = sc.nextLine();
		  
		System.out.print("주소 : ");
		String changeaddress = sc.nextLine();
		  
		System.out.print("나이 : ");
		int changeage = sc.nextInt();
		  
		Student st = new Student(changeid, changepassword, changename, changegender, changeemail, changephone, changeaddress, changeage);

		model.updateStudent(serchid, st);
		
		//delete
		System.out.print("삭제할 아이디 : ");
		String userid = sc.nextLine();
		model.delete(userid);
	}

}
