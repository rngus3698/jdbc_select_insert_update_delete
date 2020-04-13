package model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8452365375523620085L;

	private String memberId;	//회원 아이디
	private String memberPwd;	//회원 패스워드
	private String memberName;	//회원명
	private String gender;		//성별
	private String email;		//이메일
	private String phone;		//전화번호
	private String address;		//주소
	private int age;			//나이
	private Date enrollDate;	//가입날짜
	
	//생성자
	public Student() {
		super();
	}

	public Student(String memberId, String memberPwd, String memberName, String gender, String email, String phone,
			String address, int age, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.enrollDate = enrollDate;
	}
	
	

	public Student(String memberId, String memberPwd, String memberName, String gender, String email, String phone,
			String address, int age) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.age = age;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", gender="
				+ gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", age=" + age
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
	
}
