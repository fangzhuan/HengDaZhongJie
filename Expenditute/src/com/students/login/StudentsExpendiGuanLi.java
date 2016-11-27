package com.students.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.students.dao.StudentsExpendiDao;

public class StudentsExpendiGuanLi {
	StudentsExpendiDao seDao=new StudentsExpendiDao();
	Scanner in=new Scanner(System.in);
	public void selectStudents(){
		List<String> headList=seDao.getHeadList();
		List<List> bodyList=seDao.getBodyList();
		System.out.println("显示所有会员及积分如下");
		System.out.println("***********************************************");
		for(String s:headList){
			System.out.print("   "+s+"\t        ");
		}
		System.out.println();
		for(List list:bodyList){
			for(int i=0;i<list.size();i++){
				if(i==1){
					System.out.print("   ￥"+list.get(i)+"\t ");
				}else{
					System.out.print("   "+list.get(i)+"\t ");
				}
				
			}
			System.out.println();
		}
		System.out.println("***********************************************");
		
		System.out.println("1.返回上级菜单");
		System.out.println("2.退出系统");
		System.out.print("请输入：");
		int n=1;
		do{
			
			n=in.nextInt();
			if(n==1||n==2){
				switch(n){
				case 1:Login.main(null);break;
				case 2:System.exit(0);
				}
			}else{
				System.out.print("输入错误，请重新输入：");
			}
		}while(n!=1&&n!=2);
	}
	public void addStuExpendi(){
		boolean flag=false;
		System.out.println("添加消费记录");
		String name,date1,date2,expendi,type="普通会员";
		System.out.print("请输入姓名：");
		name=in.next();
		System.out.print("请输入日期(如：2013.3.17)：");
		do{
		date1=in.next();
		if(date1.matches("\\d{4}.\\d{1,2}.\\d{1,2}")){
			flag=false;
		}else{
			flag=true;
			System.out.print("输入错误，请重新输入：");
		}
		}while(flag);
		System.out.print("请输入时间(如：17:25:00)：");
		do{
			date2=in.next();
			if(date2.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")){
				flag=false;
			}else{
				flag=true;
				System.out.print("输入错误，请重新输入：");
			}
		}while(flag);
		System.out.print("请输入消费金额：");
		expendi=in.next();
		System.out.print("请输入消费类型(1.会员普通  2.会员VIP)：");
		do{
		int n=in.nextInt();
		if(n==1){
			flag=false;
			type="会员普通";
		}else if(n==2){
			flag=false;
			type="会员VIP";
		}else{
			flag=true;
			System.out.println("输入错误，请重新输入：");
		}
		}while(flag);
		date1=date1+" "+date2;
		if(seDao.addStudents(name, date1, expendi, type)>0){
			System.out.println("消费记录添加成功！");
		}
		
		System.out.println("1.返回上级菜单");
		System.out.println("2.退出系统");
		System.out.print("请输入：");
		int n=1;
		do{
			
			n=in.nextInt();
			if(n==1||n==2){
				switch(n){
				case 1:Login.main(null);break;
				case 2:System.exit(0);
				}
			}else{
				System.out.print("输入错误，请重新输入：");
			}
		}while(n!=1&&n!=2);
	}
	public void selectStuExpendi(){
		boolean flag=true;
		float sumJin=0,sumJiFen=0;
		System.out.print("请输入要查询的用户名：");
		do{
		String name=in.next();
		if(seDao.isStuName(name)){
			flag=false;
			List<String> headList=seDao.selectStuExpendiHead();
			List<List> bodyList=seDao.selectStuExpendiBody(name);
			System.out.println(name+"的消费记录如下：");
			System.out.println("***********************************************");
			for(int i=0;i<headList.size();i++){
				if(i==1){
					System.out.print(headList.get(i)+"\t\t\t     ");
				}else if(i==2){
					System.out.print(headList.get(i)+"\t\t");
				}else{
				System.out.print("  "+headList.get(i)+"\t      ");
				}
			}
			System.out.println();
			for(List list:bodyList){
				for(int i=0;i<list.size();i++){
					if(i==2){
						sumJin=sumJin+Float.parseFloat(list.get(i).toString());
						System.out.print(" ￥"+list.get(i)+"\t\t");
					}else if(i==0){
						System.out.print("  "+list.get(i)+"\t ");
					}else if(i==3){
						sumJiFen=sumJiFen+Float.parseFloat(list.get(i).toString());
						System.out.print(" "+list.get(i)+"\t ");
					}else{
						System.out.print(" "+list.get(i)+"\t ");
					}
					
				}
				System.out.println();
			}
			System.out.println("\n\t"+name+"的总消费金额为"+sumJin+",累计获得积分"+sumJiFen);
			System.out.println("***********************************************");
			
			
		}else{
			System.out.print("此用户不存在！请重新输入：");
		}
		}while(flag);
		
		System.out.println("1.返回上级菜单");
		System.out.println("2.退出系统");
		System.out.print("请输入：");
		int n=1;
		do{
			
			n=in.nextInt();
			if(n==1||n==2){
				switch(n){
				case 1:Login.main(null);break;
				case 2:System.exit(0);
				}
			}else{
				System.out.print("输入错误，请重新输入：");
			}
		}while(n!=1&&n!=2);
	}
}
