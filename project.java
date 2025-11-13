package com.jdbc.smallproject;
import java.sql.*;
import java.util.*;
import java.sql.Date;
public class project {
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String username = "root";
	private static String password = "1234567890";
	private static Connection con;
	public static void createtable() throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS student ("
	              + " id INT AUTO_INCREMENT PRIMARY KEY,"
	              + " enrollment_id BIGINT UNIQUE, "
	              + " name VARCHAR(100) NOT NULL,"
	              + " age INT,"
	              + " email VARCHAR(100),"
	              + " enrolled_date DATE, "
	              + " course VARCHAR(20)"
	              + ");";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("Table Created!!!");
		System.out.println();
	}
	public static void insert(Scanner sc) throws SQLException {
		String query = "insert into student(enrollment_id,name,age,email,enrolled_date,course) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		System.out.print("Enter Enrollment ID: ");
		long enrollment_Id = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		System.out.print("Enter Enrolled Date (YYYY-MM-DD): ");
		String date = sc.nextLine();
		System.out.print("Enter Course: ");
		String course = sc.nextLine();
		stmt.setLong(1, enrollment_Id);
		stmt.setString(2, name);
		stmt.setInt(3, age);
		stmt.setString(4, email);
		stmt.setDate(5, Date.valueOf(date));
		stmt.setString(6, course);
		stmt.executeUpdate();
		stmt.close();
		System.out.println("Record inserted successfully!!!");
		System.out.println();
	}
	public static void insertMultiple(Scanner sc) throws SQLException {
		System.out.println();
		System.out.print("Enter number of students to insert: ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter details for student " + i);
			insert(sc);
		}
		System.out.println();
	}
	public static void update(Scanner sc) throws SQLException {
		System.out.println();
		String query = "update student SET name=?, age=?, email=?, course=? WHERE enrollment_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		System.out.print("Enter Enrollment ID to update: ");
		long enrollId = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter New Name: ");
		String name = sc.nextLine();
		System.out.print("Enter New Age: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter New Email: ");
		String email = sc.nextLine();
		System.out.print("Enter New Course: ");
		String course = sc.nextLine();
		stmt.setString(1, name);
		stmt.setInt(2, age);
		stmt.setString(3, email);
		stmt.setString(4, course);
		stmt.setLong(5, enrollId);
		int rows = stmt.executeUpdate();
		if (rows > 0)
			System.out.println("Record updated successfully");
		else
			System.out.println("Enrollment ID not found");
		stmt.close();
		System.out.println();
	}
	public static void updateMultiple(Scanner sc) throws SQLException{
		System.out.println();
		System.out.println("Enter number of students for updating details:");
		int update_number_students=sc.nextInt();
		for(int i=0;i<update_number_students;i++) {
			update(sc);
		}
		System.out.println();
	}
	public static void delete(Scanner sc) throws SQLException {
		String query = "delete from student where enrollment_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		System.out.println();
		System.out.print("Enter Enrollment ID to delete: ");
		long enrollId = sc.nextLong();
		sc.nextLine();
		stmt.setLong(1, enrollId);
		int rows = stmt.executeUpdate();
		if (rows > 0)
			System.out.println("Record deleted successfully");
		else
			System.out.println("Enrollment ID not found");
		System.out.println();
		stmt.close();
	}
	public static void deleteMultiple(Scanner sc) throws SQLException{
		System.out.println();
		System.out.println("Enter number of Students whose details you want to delete:");
		int delete_number_students = sc.nextInt();
		for(int i=0;i<delete_number_students;i++) {
			delete(sc);
		}
	}
	public static void show() throws SQLException {
	    String query = "SELECT * FROM student";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);

	    System.out.println();
	    System.out.println("------------------------------------------------------------- STUDENT TABLE -------------------------------------------------------------");
	    System.out.printf("%-5s | %-15s | %-20s | %-5s | %-25s | %-15s | %-15s%n",
	            "ID", "Enrollment_ID", "Name", "Age", "Email", "Date", "Course");
	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

	    while (rs.next()) {
	        System.out.printf("%-5d | %-15d | %-20s | %-5d | %-25s | %-15s | %-15s%n",
	                rs.getInt("id"),
	                rs.getLong("enrollment_id"),
	                rs.getString("name"),
	                rs.getInt("age"),
	                rs.getString("email"),
	                rs.getDate("enrolled_date"),
	                rs.getString("course"));
	    }

	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Created Successfully!!!");
			createtable();
			Scanner sc = new Scanner(System.in);
			int user_choice;
			while(true){
				System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
				System.out.println();
				System.out.println("----------Welcome to Student Database Menu-----------");
				System.out.println();
				System.out.println("1-> Insert Student Details");
				System.out.println("2-> Insert Multiple Student Details");
				System.out.println("3-> Update Student Details");
				System.out.println("4-> Update Multiple Student Details:");
				System.out.println("5-> Delete Student Records");
				System.out.println("6-> Delete Multiple Student Records");
				System.out.println("7-> Show student details");
				System.out.println("8-> Exit from Menu");
				System.out.println();
				System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
				System.out.print("Enter your choice (from 1 to 8): ");
				user_choice = sc.nextInt();
				sc.nextLine();
				if(user_choice==1) {
					insert(sc);
				}else if(user_choice==2){
					insertMultiple(sc);
				}else if(user_choice==3) {
					update(sc);
				}else if(user_choice ==4 ) {
					updateMultiple(sc);
				}else if(user_choice==5) {
					delete(sc);
				}else if(user_choice==6) {
					deleteMultiple(sc);
				}else if(user_choice==7) {
					show();
				}else if(user_choice ==8) {
					System.out.println("Thanks for Coming!!!");
					break;
				}else {
					System.out.println("Please enter Valid Value according to the Menu!!!");
				}
			}
			sc.close();
			con.close();
			System.out.println("Connection Closed!!!");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}