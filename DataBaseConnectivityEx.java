package org.example;

import java.sql.SQLException;

public class DataBaseConnectivityEx {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCExample jd=new JDBCExample();
       System.out.println("Connection Successful "+jd.getConnection());

       System.out.println("connection ok" +jd.intializeConnection());

     //  jd.createDatabase();
      // jd.createTable();
      //  jd.retrieveTable();
      //  jd.updateTable();
      //  jd.deleteTable();
        jd.addImage();
    }
}
