package model.vo;

import java.io.Serializable;
import java.sql.Date;

/*
 * vo (value object) == entity == record == row
 * 
 * 1. 반드시 캡술화를 적용할 것 : 모든 필드는 private이다.
 * 2. 기본 생성자와 매개변수 있는 생성자 작성할 것
 * 3. 모든 필드에 대한 getter와 setter 작성할 것
 * 4. 직렬화 처리할 것
 */

public class Employee implements Serializable
{

	
	private String empId;
	
	private String empName;
	
	private String empNo;
	
	private String email;
	
	private String phone;
	
	private Date hireDate;
	
	private String jobCode;
	
	private int salary;
	
	private double bonusPct;
	
	private String marriage;
	
	private String mgrId;
	
	private String deptId;

	public Employee() {
		super();
	}

	
	


	public Employee(String empId, String empName, String empNo, Date hireDate, int salary, double bonusPct) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.hireDate = hireDate;
		this.salary = salary;
		this.bonusPct = bonusPct;
	}





	public Employee(String empId, String empName, String empNo, String email, String phone, Date hireDate,
			String jobCode, int salary, double bonusPct, String marriage, String mgrId, String deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobCode = jobCode;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.marriage = marriage;
		this.mgrId = mgrId;
		this.deptId = deptId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
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

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonusPct() {
		return bonusPct;
	}

	public void setBonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", hireDate=" + hireDate + ", jobCode=" + jobCode + ", salary=" + salary
				+ ", bonusPct=" + bonusPct + ", marriage=" + marriage + ", mgrId=" + mgrId + ", deptId=" + deptId + "]";
	}
	
	
	
	
	
}
