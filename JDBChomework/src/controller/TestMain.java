package controller;

import java.util.Scanner;

import model.dao.JDBCTest;
import model.vo.MenuOrder;
import model.vo.Seat;

public class TestMain {

	static Scanner sc = new Scanner(System.in);
	static JDBCTest test = new JDBCTest();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMain tm = new TestMain();
		
		while(true)
		{
			System.out.println("1. tableSelcet");
			System.out.println("2. order");
			System.out.println("3. calc");
			System.out.println("4. 종료");
			System.out.print("번호를 선택해주세요 : ");
			int anwer = sc.nextInt();
			
			switch(anwer)
			{
			case 1:
				tm.tableInsert();
				break;
			case 2:
				tm.order();
				break;
			case 3:
				tm.calc();
				break;
			case 4:
				return;
			}
			
		}
	}
	
	public void calc() 
	{
		System.out.print("테이블 번호 : ");
		int tableNum = sc.nextInt();
		//seat테이블 삭제
		test.seatTableDelete(tableNum);
		//menuOrder테이블에 tableNum에 해당하는 행 삭제
		test.menuOrderTableDelete(tableNum);
	}

	public void order() 
	{
		
		System.out.print("테이블 번호 : ");
		int tableNum = sc.nextInt();
		sc.nextLine();
		System.out.print("주문하실 메뉴 : ");
		String menu = sc.nextLine();
		//menuPriceSelect
		int menuprice = test.menuPriceSelect(menu);
		//menuOrderInsert
		MenuOrder menuOrder = new MenuOrder(tableNum, menuprice, menu);
		test.menuOrderInsert(menuOrder);
		
		//seat테이블에 가격 update하기
		int tableprice = test.tablePriceSelect(tableNum);
		test.tableUpdate(tableprice, tableNum);
		
		
	}

	public  void tableInsert()
	{
		System.out.print("몇 번테이블 입니까?");
		int tableNum = sc.nextInt();
		Seat table = new Seat(tableNum,0);
		test.tableInsert(table);
	}

}
