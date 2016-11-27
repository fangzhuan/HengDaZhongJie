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
		System.out.println("��ʾ���л�Ա����������");
		System.out.println("***********************************************");
		for(String s:headList){
			System.out.print("   "+s+"\t        ");
		}
		System.out.println();
		for(List list:bodyList){
			for(int i=0;i<list.size();i++){
				if(i==1){
					System.out.print("   ��"+list.get(i)+"\t ");
				}else{
					System.out.print("   "+list.get(i)+"\t ");
				}
				
			}
			System.out.println();
		}
		System.out.println("***********************************************");
		
		System.out.println("1.�����ϼ��˵�");
		System.out.println("2.�˳�ϵͳ");
		System.out.print("�����룺");
		int n=1;
		do{
			
			n=in.nextInt();
			if(n==1||n==2){
				switch(n){
				case 1:Login.main(null);break;
				case 2:System.exit(0);
				}
			}else{
				System.out.print("����������������룺");
			}
		}while(n!=1&&n!=2);
	}
	public void addStuExpendi(){
		boolean flag=false;
		System.out.println("������Ѽ�¼");
		String name,date1,date2,expendi,type="��ͨ��Ա";
		System.out.print("������������");
		name=in.next();
		System.out.print("����������(�磺2013.3.17)��");
		do{
		date1=in.next();
		if(date1.matches("\\d{4}.\\d{1,2}.\\d{1,2}")){
			flag=false;
		}else{
			flag=true;
			System.out.print("����������������룺");
		}
		}while(flag);
		System.out.print("������ʱ��(�磺17:25:00)��");
		do{
			date2=in.next();
			if(date2.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")){
				flag=false;
			}else{
				flag=true;
				System.out.print("����������������룺");
			}
		}while(flag);
		System.out.print("���������ѽ�");
		expendi=in.next();
		System.out.print("��������������(1.��Ա��ͨ  2.��ԱVIP)��");
		do{
		int n=in.nextInt();
		if(n==1){
			flag=false;
			type="��Ա��ͨ";
		}else if(n==2){
			flag=false;
			type="��ԱVIP";
		}else{
			flag=true;
			System.out.println("����������������룺");
		}
		}while(flag);
		date1=date1+" "+date2;
		if(seDao.addStudents(name, date1, expendi, type)>0){
			System.out.println("���Ѽ�¼��ӳɹ���");
		}
		
		System.out.println("1.�����ϼ��˵�");
		System.out.println("2.�˳�ϵͳ");
		System.out.print("�����룺");
		int n=1;
		do{
			
			n=in.nextInt();
			if(n==1||n==2){
				switch(n){
				case 1:Login.main(null);break;
				case 2:System.exit(0);
				}
			}else{
				System.out.print("����������������룺");
			}
		}while(n!=1&&n!=2);
	}
	public void selectStuExpendi(){
		boolean flag=true;
		float sumJin=0,sumJiFen=0;
		System.out.print("������Ҫ��ѯ���û�����");
		do{
		String name=in.next();
		if(seDao.isStuName(name)){
			flag=false;
			List<String> headList=seDao.selectStuExpendiHead();
			List<List> bodyList=seDao.selectStuExpendiBody(name);
			System.out.println(name+"�����Ѽ�¼���£�");
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
						System.out.print(" ��"+list.get(i)+"\t\t");
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
			System.out.println("\n\t"+name+"�������ѽ��Ϊ"+sumJin+",�ۼƻ�û���"+sumJiFen);
			System.out.println("***********************************************");
			
			
		}else{
			System.out.print("���û������ڣ����������룺");
		}
		}while(flag);
		
		System.out.println("1.�����ϼ��˵�");
		System.out.println("2.�˳�ϵͳ");
		System.out.print("�����룺");
		int n=1;
		do{
			
			n=in.nextInt();
			if(n==1||n==2){
				switch(n){
				case 1:Login.main(null);break;
				case 2:System.exit(0);
				}
			}else{
				System.out.print("����������������룺");
			}
		}while(n!=1&&n!=2);
	}
}
