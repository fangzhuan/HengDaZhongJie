package com.students.login;

import java.util.Scanner;

public class Login {
	public static void main(String[] args){
		System.out.println("欢迎使用积分管理系统！");
		System.out.println("1.显示所有会员及积分");
		System.out.println("2.添加消费记录");
		System.out.println("3.查询一个用户的消费记录");
		System.out.println("4.退出系统");
		System.out.print("请输入：");
		boolean flag=false;
		int n=1;
		do{
			try{
			Scanner in=new Scanner(System.in);
			n=in.nextInt();
			}catch(Exception e){
				n=0;
				System.out.print("非数字无效！");
			}
			if(n>0&&n<5){
				StudentsExpendiGuanLi seGuanLi=new StudentsExpendiGuanLi();
				flag=false;
				switch(n){
				case 1:seGuanLi.selectStudents();break;
				case 2:seGuanLi.addStuExpendi();break;
				case 3:seGuanLi.selectStuExpendi();break;
				case 4:System.exit(0);break;
				}
			}else{
				flag=true;
				System.out.print("输入错误，请重新输入：");
			}
		}while(flag);
	}
}
