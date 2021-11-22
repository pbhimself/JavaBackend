package assignment5;

import java.sql.*;
import java.util.*; 
public class Assignment5
{
    public static void main(String[] args)
    {    Scanner sc = new Scanner(System.in);
           int a,s,p;String e1,e2,e3;
      try{
         String Query = "Insert INTO employee (EmpId,Empname,Emp_desig,Emp_J_Date,Emp_Salary) VALUES(?,?,?,?,?)";
         String Query1 = "Select * from employee";
         String Query2 = "Delete FROM employee where EmpId = ? ";
         String Query3 = "UPDATE employee set Empname = ? ,Emp_desig = ?,Emp_J_date = ?,Emp_Salary = ? WHERE EmpId= ?";
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
         Statement st = con.createStatement();
         while(true){
             
             System.out.println("1.Insert");
             System.out.println("2.Update");
             System.out.println("3.Delete");
             System.out.println("4.Select");
             System.out.println("5.Exit");
             System.out.println("Select operation");
             int ch = sc.nextInt();
             switch(ch){
                 case 1:
                      PreparedStatement preparedStmt = con.prepareStatement(Query);
                      System.out.println("Enter EmpId");
                      a = sc.nextInt();
                      System.out.println("Enter Emp Find by Id");
                      sc.nextLine();
                      e1 = sc.nextLine();
                      System.out.println("Enter Emp designation");
                      e2 = sc.nextLine();
                      System.out.println("Enter Emp Joining Date");
                      e3 = sc.nextLine();
                      System.out.println("Enter salary");
                      s = sc.nextInt();
                      preparedStmt.setInt(1,a);
                      preparedStmt.setString(2,e1);
                      preparedStmt.setString(3,e2);
                      preparedStmt.setString(4,e3);
                      preparedStmt.setInt(5,s);
                      preparedStmt.execute();
                      System.out.println("Insert Sucessful");
                      break;
                 case 2:
                      System.out.println("Enter Emp Id for information updation");
                      p = sc.nextInt();
                      PreparedStatement preparedStmt1 = con.prepareStatement(Query3);
                      
                      System.out.println("Enete Emp Find by Id");
                      sc.nextLine();
                      e1 = sc.nextLine();
                      System.out.println("Enete Emp designation");
                      e2 = sc.nextLine();
                      System.out.println("Enete Emp Joining Date");
                      e3 = sc.nextLine();
                      System.out.println("Enete salary");
                      s = sc.nextInt();
                      preparedStmt1.setString(1,e1);
                      preparedStmt1.setString(2,e2);
                      preparedStmt1.setString(3,e3);
                      preparedStmt1.setInt(4,s);
                      preparedStmt1.setInt(5,p);
                      preparedStmt1.execute();
                      break;
                 case 3:
                      System.out.println("Enter the EmpId to delete");
                      p = sc.nextInt();
                      PreparedStatement preparedStmt2 = con.prepareStatement(Query2);
                      preparedStmt2.setInt(1,p);
                      preparedStmt2.execute();
                      break;
                 case 4:
                        ResultSet rs = st.executeQuery(Query1);
                         while (rs.next()) {
                         int empid = rs.getInt(1);
                         String empname = rs.getString(2);
                         String empdesig = rs.getString(3);
                         String empjdate = rs.getString(4);
                         int salary = rs.getInt(5);
                         System.out.println(empid+" "+Find by Id+" "+empdesig+" "+empjdate+" "+salary);
                         }
                         break;
                 case 5:
                     return;
             }
         }
      }
      catch(Exception e){
          System.out.println(e);
      }
        
    }
}
