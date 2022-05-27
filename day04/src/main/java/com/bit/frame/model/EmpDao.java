package com.bit.frame.model;

import java.sql.*;
import java.util.*;

import com.bit.frame.model.entity.EmpVo;

public class EmpDao {
   
   public List<EmpVo> selectAll() throws SQLException{
      List<EmpVo> list = new ArrayList<>();
      String sql="select * from emp";
      ///
      String driver="com.mysql.cj.jdbc.Driver";
      String url="jdbc:mysql://localhost:3306/scott";
      String user="user01";
      String password="1234";
      
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs = null;
      ///
      try {
         conn=DriverManager.getConnection(url,user,password);
         pstmt=conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
         while(rs.next()) {
            EmpVo bean=new EmpVo();
            bean.setEmpno(rs.getInt("empno"));
            bean.setEname(rs.getString("ename"));
            bean.setSal(rs.getInt("sal"));
            bean.setJob(rs.getString("job"));
            list.add(bean);
         }
      } finally {
         if(rs!=null) rs.close();
         if(pstmt!=null) pstmt.close();
         if(conn!=null) conn.close();
      }
      
      return list;
   }

   public void insertOne(int empno, String ename, int sal, String job) throws SQLException {
      String sql="insert into emp (empno,ename,sal,job) values(?,?,?,?)";
      //
      String driver="com.mysql.cj.jdbc.Driver";
      String url="jdbc:mysql://localhost:3306/scott";
      String user="user01";
      String password="1234";
      
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      Connection conn=null;
      PreparedStatement pstmt=null;
      //
      try {
         conn=DriverManager.getConnection(url, user, password);
         pstmt=conn.prepareStatement(sql);
         pstmt.setInt(1,empno);
         pstmt.setString(2,ename);
         pstmt.setInt(3,sal);
         pstmt.setString(4,job);
         pstmt.executeUpdate();
      } finally {
      
         if(pstmt!=null) pstmt.close();
         if(conn!=null) conn.close();
      }
      
   }
}