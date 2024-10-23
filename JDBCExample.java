package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {
    public Connection getConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3307/anu";
        String username="root";
        String password="root";
        return DriverManager.getConnection(url,username,password);
    }

    public Connection intializeConnection() throws ClassNotFoundException, SQLException {
      //  String dbDriver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://Localhost:3307/company";
        String username="root";
        String password="root";
      //  Class.forName(dbDriver);

       return DriverManager.getConnection(url,username,password);
    }

    public void createDatabase() throws SQLException {
        String query="create database anu";
        try(Connection con=getConnection())
        {
            Statement st= con.createStatement();
            st.execute(query);
            System.out.println("Database Created ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable() throws SQLException {
        try(Connection con=getConnection())
        {
           Statement st= con.createStatement();
           st.executeUpdate("create table employee(emp_id varchar(2) primary key,emp_name varchar(30))");
           System.out.println("Table Created Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void retrieveTable() throws SQLException {
        List<Employee> emp=new ArrayList<Employee>();
        try(Connection con=getConnection())
        {
           Statement st= con.createStatement();
          ResultSet rs = st.executeQuery("select * from employee");
            while (rs.next())
            {
               String id=rs.getString("emp_id");
               String name=rs.getString("emp_name");
               Employee e=new Employee(id,name);
               emp.add(e);
               System.out.println("id :"+id+" name :"+name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void updateTable() throws SQLException {
        try(Connection con=getConnection())
        {
            PreparedStatement st= con.prepareStatement("insert into employee (emp_id,emp_name) values (?,?)");
            st.setString(1,"3");
            st.setString(2,"kanna");
            st.executeUpdate();
            System.out.println("Inserted Succeefully");
        }
    }

    public void deleteTable() throws SQLException {
        try(Connection con=getConnection())
        {
            Statement st=con.createStatement();
            st.execute("drop table employee");
            System.out.println("Deleted Successfully");
        }
    }
    public  void addImage() throws SQLException {

       String url= " http://localhost:8081/ASSESMENT_PORTAL/ASSESMENT-html/index.html ";
        try(Connection con=getConnection())
        {
            PreparedStatement statement= con.prepareStatement("INSERT INTO resources (name, url) VALUES (?, ?)");
            statement.setString(1, "Example Resource"); // Set name of the resource
            statement.setString(2, url);        // Set URL

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new resource was inserted successfully!");
            }
        }
    }
}
