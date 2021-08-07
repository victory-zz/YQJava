package com.xzz.login;

import com.xzz.until.LoginUntil;

import java.util.Scanner;

public class LoginDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean login=false;
		System.out.println("===========登录界面============");
		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("3.退出");
		System.out.println("请选择以上选项进行相关的操作：");

		int select = scanner.nextInt();

		switch (select){
			case 1: break;
			case 2:
				{
					LoginUntil.getLogin();
				}
			case 3: System.exit(0);
		}




	}


}
