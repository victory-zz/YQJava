package com.xzz.login;

import com.xzz.until.LoginUntil;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginDemo {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		int select=0;
		System.out.println("===========登录界面============");
		do {
			System.out.println("1.注册");
			System.out.println("2.登录");
			System.out.println("3.修改密码");
			System.out.println("4.退出");
			System.out.println("===========================");
			System.out.print("请选择以上选项进行相关的操作：");

			select = scanner.nextInt();

			switch (select){
				case 1:
					if (LoginUntil.registerUser()>0){
						System.out.println("注册成功");
					}else {
						System.out.println("注册失败");
					}
					break;
				case 2:
				{
					LoginUntil.getLogin();
					break;
				}
				case 3:
					if (LoginUntil.updateUserPassword()>0){
						System.out.println("修改密码成功！");
					}else {
						System.out.println("密码修改失败！");
					}
					break;
				case 4: System.exit(0);
				default:
					System.out.println("未开发此功能，请重新选择如下对应的选项！");
			}
		}while (true);
	}


}
