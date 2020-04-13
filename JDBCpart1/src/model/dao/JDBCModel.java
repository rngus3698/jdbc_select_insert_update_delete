package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Employee;

public class JDBCModel
{
	public JDBCModel() 
	{
		
	}
	
	public void testJDBC()
	{
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rset = null;
//		//1. 해당 데이터베이스(DBMS)에 대한 라이브러리 등록작업(드라이버 등록)
//		try
//		{
//			Class.forName("oracle.jdbc.driver.OracleDriver"); //oracle 드라이버사용
//			//2 데이터베이스와 연결함
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC", "JDBC");
//			
//			//3. 쿼리문 가지고 DB에 가서 쿼리문 실행시키고 결과 가지고 오는 객체 생성함
//			String query = "SELECT * FROM EMPLOYEE";
//			
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//			
//			while(rset.next())
//			{
//				System.out.println(rset.getString("emp_id") + "/" + rset.getString("emp_name") + "/" + rset.getString("emp_no") + "/"
//								   + rset.getString("email") + "/" + rset.getString("phone") + "/" + rset.getDate("hire_date") + "/"
//								   + rset.getString("job_id") + "/" + rset.getInt("salary") + "/" + rset.getDouble("bonus_pct") + "/"
//								   + rset.getString("marriage") + "/" + rset.getString("mgr_id") + "/" + rset.getString("dept_id"));
//			}
//		}
//		
//		catch (ClassNotFoundException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			//4. DB와 관련된 객체는 반드시 close해야 함
//			
//			try
//			{
//				rset.close();
//				stmt.close();
//				conn.close();
//			}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
//		}
				
	}
	
	public void testJDBC2(String empId)
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","JDBC","JDBC");
			
			//Statement 방식
//			String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + empId;
//			
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
			
			//PreparedStatement 방식
			String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, empId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				System.out.println(rset.getString("emp_id") + "/" + rset.getString("emp_name") + "/" + rset.getString("emp_no") + "/"
								   + rset.getString("email") + "/" + rset.getString("phone") + "/" + rset.getDate("hire_date") + "/"
								   + rset.getString("job_id") + "/" + rset.getInt("salary") + "/" + rset.getDouble("bonus_pct") + "/"
								   + rset.getString("marriage") + "/" + rset.getString("mgr_id") + "/" + rset.getString("dept_id"));
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rset.close();
//				stmt.close();
				conn.close();
				pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
		
	public void testJDBC3()
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","JDBC","JDBC");
			
			//Statement 방식
//				String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + empId;
//				
//				stmt = conn.createStatement();
//				rset = stmt.executeQuery(query);
			
			//PreparedStatement 방식
			String query = "SELECT EMP_ID FROM EMPLOYEE";
			
			pstmt = conn.prepareStatement(query);
			
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				System.out.println(rset.getString("emp_id"));
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rset.close();
//				stmt.close();
				conn.close();
				pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
	}

	public void testInsert(Employee emp) 
	{
		Connection conn = null;
		Statement stmt = null;
		// ResultSet은 필요x(왜냐면 DML(INSERT) 작업을 해줄 꺼라서 반환형이 int이므로)
		// DQL : SELECT -> 반환형이 Result Set
		// DML : INSERT, UPDATE, DELETE -> 반환형이 int(몇 행을 DML작업을 했는지를 int로 반환)
		int result = 0;
		
		System.out.println(emp);
		
//		String query = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, SALARY, BONUS_PCT)"+
//				"VALUES('212','김','950711-1112111',SYSDATE, 100000000, 1)";
		String query = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, SALARY, BONUS_PCT)\r\n" + 
						"VALUES('"+emp.getEmpId()+"','"+emp.getEmpName()+"','"+emp.getEmpNo()+"','"+emp.getHireDate()+"', "+emp.getSalary()+", "+emp.getBonusPct()+")";
		
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","JDBC","JDBC");
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			
			if(result>0)
			{
				System.out.println(result + "개의 행이 추가되었습니다.");
				conn.commit();
			}
			else
			{
				System.out.println("insert 작업이 실패했습니다.");
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				conn.close();
				stmt.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void testInsert2(Employee emp1)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, SALARY, BONUS_PCT)\r\n" + 
				"VALUES(?,?,?,?,?,?)";
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","JDBC","JDBC");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp1.getEmpId());
			pstmt.setString(2, emp1.getEmpName());
			pstmt.setString(3, emp1.getEmpNo());
			pstmt.setDate(4, emp1.getHireDate());
			pstmt.setInt(5, emp1.getSalary());
			pstmt.setDouble(6, emp1.getBonusPct());
			
			result = pstmt.executeUpdate();
			
			if(result>0)
			{
				System.out.println(result + "개의 행이 추가되었습니다.");
				conn.commit();
			}
			else
			{
				System.out.println("insert 작업이 실패했습니다.");
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				conn.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
