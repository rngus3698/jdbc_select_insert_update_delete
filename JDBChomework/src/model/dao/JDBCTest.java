package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.MenuOrder;
import model.vo.Seat;

public class JDBCTest {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "JEONJU";
	private String pwd = "JEONJU";
	
	public void selectAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			String query = "SELECT * FROM SEAT";
			
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				System.out.println("테이블 번호  : " + rset.getInt("tableNum"));
				System.out.println("가격 : " + rset.getInt("price"));
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
	public void tableInsert(Seat seat)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO SEAT VALUES(?,?)";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, seat.getTableNum());
			pstmt.setInt(2, seat.getPrice());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println(seat.getTableNum() + "테이블 입장!!");
				conn.commit();
			}
			else
			{
				System.out.println("나가!!!!!!!!");
				conn.rollback();
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
	
	public void tableUpdate(int price, int tableNum)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE SEAT SET PRICE = ? WHERE TABLENUM =?";
		
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, price);
			pstmt.setInt(2, tableNum);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println("table price update 성공");
				conn.commit();
			}
			else
			{
				System.out.println("talbe price update 실패");
				conn.rollback();
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
	
	public void menuOrderInsert(MenuOrder menuOrder)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO MENUORDER VALUES(?,?,?,SYSDATE)";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, menuOrder.getTableNum());
			pstmt.setInt(2, menuOrder.getPrice());
			pstmt.setString(3, menuOrder.getMenu());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println(menuOrder.getTableNum() + "번 테이블에 "+menuOrder.getMenu() + "주문이 들어갔습니다.");
				conn.commit();
			}
			else
			{
				System.out.println("주문 실패");
				conn.rollback();
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
	
	public int menuPriceSelect(String menuName)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int returnPrice = 0;
		
		String query = "SELECT PRICE FROM MENU WHERE MENUNAME = ?";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, menuName);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				System.out.println("ㅎㅇ");
				returnPrice = rset.getInt("price");
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
		return returnPrice;
	}
	
	public int tablePriceSelect(int tableNum)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int tableTotalPrice = 0;
		
		String query = "SELECT PRICE FROM MENUORDER WHERE TABLENUM = ?";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tableNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				tableTotalPrice += rset.getInt("price");
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
		return tableTotalPrice;
	}
	
	public void seatTableDelete(int tableNum)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "DELETE SEAT WHERE TABLENUM = ?";
		
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, tableNum);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println(tableNum + "번 테이블 삭제");
				conn.commit();
			}
			else
			{
				System.out.println("실패");
				conn.rollback();
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
	
	public void menuOrderTableDelete(int tableNum)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "DELETE MENUORDER\r\n" + 
				"WHERE TABLENUM = ?";
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tableNum);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				System.out.println(tableNum + "번의 주문내역 삭제");
				conn.commit();
			}
			else
			{
				System.out.println("실패");
				conn.rollback();
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
	
	public int resultPrice(int tableNum)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int resultprice = 0;
		String query = "SELECT PRICE FROM MENUORDER WHERE TABLENUM = ?";
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, tableNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				resultprice += rset.getInt("price");
			}
		}
		catch (ClassNotFoundException e) 
		{
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
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultprice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
