/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Dal.Concrete;

import com.gazi.Dal.Abstarct.JDBCConnection;
import com.mysql.cj.util.StringUtils;

import java.sql.SQLException;


final public class JDBCPesonelDal extends JDBCConnection {


    public JDBCPesonelDal() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public boolean isPersonelExist(String personelName, String password) throws SQLException {
        if (StringUtils.isEmptyOrWhitespaceOnly(personelName) || StringUtils.isEmptyOrWhitespaceOnly(password)) {
            return false;
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select personelName,password from personels");
            while (resultSet.next()) {
                if (personelName.equals(resultSet.getString("personelName")) && password.equals(resultSet.getString("password"))) {
                    return true;
                }
            }
            return false;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return false;
    }

    @Override
    public String connectionStatus() throws SQLException {
        if(connection.isClosed() == false)
            return "Not Connected\n";

        else
            return "Connected\n";
    }
}
