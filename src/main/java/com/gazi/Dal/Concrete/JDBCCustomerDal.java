/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Dal.Concrete;

import com.gazi.Dal.Abstarct.JDBCConnection;
import com.gazi.Entity.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

final public class JDBCCustomerDal extends JDBCConnection {

    public JDBCCustomerDal() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public void add(Customer customer) throws SQLException {

        String sql = "insert into customers (firstName,lastName) values(?,?)";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        int result = preparedStatement.executeUpdate();
        connection.close();
    }
    
     public void update(Customer oldCustomer,Customer newCustomer) throws SQLException {

        String sql = "update customers set firstName=?,lastName=? where firstName=\'"+oldCustomer.getFirstName()+"\' AND lastName=\'"+oldCustomer.getLastName()+"\'";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, newCustomer.getFirstName());
        preparedStatement.setString(2, newCustomer.getLastName());
        int result = preparedStatement.executeUpdate();
        connection.close();
    }

    public void delete(String firstName, String lastName) throws SQLException {
        String sql = "delete from customers where firstName = ? AND lastName = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);

        int result = preparedStatement.executeUpdate();

        connection.close();
    }

    public ArrayList<Customer> getAll() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select firstName,lastName from customers");
            ArrayList<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("firstName"), resultSet.getString("lastName")));
            }
            return customers;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
        return null;
    }

    public ArrayList<Customer> getListByCustomerNameAndSurname(Customer customer) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select firstName,lastName from customers where firstName=\'" + customer.getFirstName() + "\' AND lastName = \'" + customer.getLastName() + "\'");
            ArrayList<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("firstName"), resultSet.getString("lastName")));
            }
            return customers;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
        return null;
    }
    
     public ArrayList<Customer> getListByCustomerName(Customer customer) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select firstName,lastName from customers where firstName=\'" + customer.getFirstName() + "\'");
            ArrayList<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("firstName"), resultSet.getString("lastName")));
            }
            return customers;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public String connectionStatus() throws SQLException {
        if (connection.isClosed() == false) {
            return "Not Connected\n";
        } else {
            return "Connected\n";
        }
    }
}
