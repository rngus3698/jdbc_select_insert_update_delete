package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Student;

public class EmployeeModel 
{

	public void selectAll() 
	{
		Connection conn = null;
//		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try 
		{
			//DBMS의 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection 객체 만들기 (길)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			
			String query = "SELECT * FROM MEMBER";
			
			//Statement 객체 생성
			stmt = conn.createStatement();
			
			//DB를 다녀오기
			rset = stmt.executeQuery(query);
			
			while(rset.next())
			{
				System.out.println(rset.getString("member_id") + " / " + rset.getString("member_pwd"));
			}
			
			//밑에 finally 추가 close()
			
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			
			try 
			{
				conn.close();
				stmt.close();
				rset.close();
//				pstmt.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectOne(String memberId) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			
			String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				System.out.println(rset.getString("member_pwd") + rset.getString("member_name"));
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
			try {
				conn.close();
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void insertEmployee(Student std) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, std.getMemberId());
			pstmt.setString(2, std.getMemberPwd());
			pstmt.setString(3, std.getMemberName());
			pstmt.setString(4, std.getGender());
			pstmt.setString(5, std.getEmail());
			pstmt.setString(6, std.getPhone());
			pstmt.setString(7, std.getAddress());
			pstmt.setInt(8, std.getAge());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println(result + "개 행 추가");
				conn.commit();
			}
			else
			{
				System.out.println("insert 실패");
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
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
				e.printStackTrace();
			}
		}
		
	}

	public void updateStudent(String change, Student st) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER\r\n" + 
				"SET MEMBER_ID = ?, MEMBER_PWD = ?, MEMBER_NAME = ?\r\n" + 
				"    ,GENDER = ?, EMAIL = ?, PHONE = ?\r\n" + 
				"    ,ADDRESS = ?, AGE = ?, ENROLL_DATE = SYSDATE\r\n" + 
				"WHERE MEMBER_ID = ?";
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, st.getMemberId());
			pstmt.setString(2, st.getMemberPwd());
			pstmt.setString(3, st.getMemberName());
			pstmt.setString(4, st.getGender());
			pstmt.setString(5, st.getEmail());
			pstmt.setString(6, st.getPhone());
			pstmt.setString(7, st.getAddress());
			pstmt.setInt(8, st.getAge());
			pstmt.setString(9, change);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println("update 성공");
			}
			else
			{
				System.out.println("update 실패");
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
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

	public void delete(String userid) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "DELETE MEMBER WHERE MEMBER_ID = ?";
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println("delete 성공");
			}
			else
			{
				System.out.println("delete 실패");
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
