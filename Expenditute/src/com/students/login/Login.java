package com.students.login;

import java.util.Scanner;

public class Login {
	public static void main(String[] args){
		System.out.println("��ӭʹ�û��ֹ���ϵͳ��");
		System.out.println("1.��ʾ���л�Ա������");
		System.out.println("2.������Ѽ�¼");
		System.out.println("3.��ѯһ���û������Ѽ�¼");
		System.out.println("4.�˳�ϵͳ");
		System.out.print("�����룺");
		boolean flag=false;
		int n=1;
		do{
			try{
			Scanner in=new Scanner(System.in);
			n=in.nextInt();
			}catch(Exception e){
				n=0;
				System.out.print("��������Ч��");
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
				System.out.print("����������������룺");
			}
		}while(flag);
	}
}
