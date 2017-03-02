/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tss
 */
public class App {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws SQLException {

    int[] numeri = {1, 2, 3};

    String url = "jdbc:mysql://localhost:3306/quest";

    Connection cn = DriverManager.getConnection(url, "root", "mysql");

    String sqlInsert
        = "insert into numeri (col1,col2,col3) values (?,?,?)";
    PreparedStatement pcmd = cn.prepareStatement(sqlInsert);
    
    for (int i = 0; i < numeri.length; i++) {
      pcmd.setInt(i+1, numeri[i]);
    }
    
    pcmd.execute();
    
    
    Statement cmd = cn.createStatement();
    ResultSet rs = cmd.executeQuery("select * from numeri");

    while (rs.next()) {
      System.out.println("Col1:" + rs.getInt("col1"));
    }

    rs.close();
    cn.close();

  }

}
