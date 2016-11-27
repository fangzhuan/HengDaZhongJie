package com.students.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsExpendiDao {
	String sql="select * from selectStudents";
	public List<String> getHeadList(){
		List<String> headList=new ArrayList<String>();
		Connection conn=DbConn.getConn();
		Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				headList.add(rs.getMetaData().getColumnName(i));
			}
			DbConn.closeAll(conn, stat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return headList;
	}
	public List<List> getBodyList(){
		List<List> bodyList=new ArrayList<List>();
		Connection conn=DbConn.getConn();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				List rowList=new ArrayList();
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					rowList.add(rs.getString(i));
				}
				bodyList.add(rowList);
			}
			DbConn.closeAll(conn, stat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bodyList;
	}
	public int addStudents(String name,String date,String expendi,String type){
		int n=0;
		String sql="insert into students values('"+name+"',"+expendi+",'"+date+"','"+type+"')";
		Connection  conn=DbConn.getConn();
		
		try {
			Statement stat = conn.createStatement();
			n=stat.executeUpdate(sql);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	public boolean isStuName(String name){
		boolean flag=false;
		Connection conn=DbConn.getConn();
		String sql="select username from students";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				if(rs.getString(1).equals(name)){
					flag=true;
				}
			}
			DbConn.closeAll(conn, stat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public List<String> selectStuExpendiHead(){
		List<String> headList=new ArrayList<String>();
		String sql="select type 状态,CONVERT(varchar,date, 120 ) 日期,Expenditure 消费金额,cast((case when type='会员普通' then Expenditure*0.05 when type='会员VIP'then Expenditure*0.2 end) as decimal(18,2)) 获得积分 from students";
		Connection conn=DbConn.getConn();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			if(rs!=null){
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					headList.add(rs.getMetaData().getColumnName(i));
				}
			}
			DbConn.closeAll(conn, stat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return headList;
	}
	public List<List> selectStuExpendiBody(String name){
		List<List> bodyList=new ArrayList<List>();
		String sql="select type 状态,CONVERT(varchar,date, 120 ) 日期,Expenditure 消费金额,cast((case when type='会员普通' then Expenditure*0.05 when type='会员VIP'then Expenditure*0.2 end) as decimal(18,2)) 获得积分 from students where username='"+name+"'";
		Connection conn=DbConn.getConn();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				List rowList=new ArrayList();
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					rowList.add(rs.getString(i));
				}
				bodyList.add(rowList);
			}
			DbConn.closeAll(conn, stat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bodyList;
	}
}
