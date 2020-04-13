package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Student;

public class JDBCmodel {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "STUDENT";
	String pwd = "STUDENT";
	
	public void selectId(String userId)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				System.out.println("id : " + rset.getString("member_id") + "\npwd : " + rset.getString("member_pwd"));
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
				rset.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void insert(Student std) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			
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
				System.out.println("insert 성공");
			}
			else
			{
				System.out.println("insert 실패");
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
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void updateId(Student std, String changeId) 
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
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, std.getMemberId());
			pstmt.setString(2, std.getMemberPwd());
			pstmt.setString(3, std.getMemberName());
			pstmt.setString(4, std.getGender());
			pstmt.setString(5, std.getEmail());
			pstmt.setString(6, std.getPhone());
			pstmt.setString(7, std.getAddress());
			pstmt.setInt(8, std.getAge());
			pstmt.setString(9, changeId);
			
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
		} catch (SQLException e) {
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

	public void deleteId(String id2) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "DELETE MEMBER WHERE MEMBER_ID = ?";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id2);
			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
