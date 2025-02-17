package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class class_School_service {
	static String url="jdbc:postgresql://localhost:5433/school";
	static String password="1234";
	static String username="postgres";
	static Connection con;
	Scanner s = new Scanner(System.in);
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int save() {
		System.out.println("Enter student Details");
		System.out.println("Enter id");
		int id=s.nextInt();
		System.out.println("Enter a name");
		String name=s.next();
		System.out.println("Enter a age");
		int age=s.nextInt();
		System.out.println("Enter a gender");
		String gender=s.next();
		int n=0;
		String sql="INSERT into student1 VALUES(?,?,?,?)";
		try {
			PreparedStatement pt=con.prepareStatement(sql);
			pt.setInt(1, id);
			pt.setString(2, name);
			pt.setInt(3, age);
			pt.setString(4, gender);
			n=pt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public int delete() {
		int n=0;
		System.out.println("Enter id");
		int id=s.nextInt();
		String sql="DELETE from student1 Where id =?";
		PreparedStatement pt;
		try {
			pt = con.prepareStatement(sql);
			pt.setInt(1, id);
			n=pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	public void fetch() {
		try {
			Statement st=con.createStatement();
			String str="select * from  student1";
			ResultSet rs=st.executeQuery(str);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String gender=rs.getString(4);
				System.out.println("id = "+id);
				System.out.println("name = "+name);
				System.out.println("age = "+age);
				System.out.println("gender = "+gender);
				System.out.println("------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int update() {
		int n=0;
		System.out.println("you can update name,age and gender only");
		System.out.println("press 1 age"+"\n"+"press 2 name"+"\n"+"press 3 gender");
		int val=s.nextInt();
		
		
		if(val==1) {
			System.out.println("Enter student id");
			int id=s.nextInt();
			System.out.println("Enter age");
			int age=s.nextInt();
			String sql="UPDATE student1 set age=? where id=?";
			try {
				PreparedStatement pt = con.prepareStatement(sql);
				pt.setInt(1, age);
				pt.setInt(2, id);
				n=pt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(val==2) {
			System.out.println("Enter student id");
			int id=s.nextInt();
			System.out.println("Enter name");
			String name=s.next();
			String sql="UPDATE student1 set name=? where id=?";
			try {
				PreparedStatement pt = con.prepareStatement(sql);
				pt.setString(1, name);
				pt.setInt(2, id);
				n=pt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(val==3) {
			System.out.println("Enter student id");
			int id=s.nextInt();
			System.out.println("Enter gender");
			String gender=s.next();
			String sql="UPDATE student1 set name=? where id=?";
			PreparedStatement pt;
			try {
				pt = con.prepareStatement(sql);
				pt.setString(1, gender);
				pt.setInt(2, id);
				n=pt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return n;
	}

}
