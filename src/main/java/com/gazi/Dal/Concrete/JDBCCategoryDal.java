/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Dal.Concrete;

import com.gazi.Dal.Abstarct.JDBCConnection;
import com.gazi.Entity.Category;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

final public class JDBCCategoryDal extends JDBCConnection {

    public JDBCCategoryDal() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public ArrayList<Category> getAll() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select categoryName from categories");
            ArrayList<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                categories.add(new Category(resultSet.getString("categoryName")));
            }
            return categories;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }

    public void update(Category oldCategory, Category newCategory) throws SQLException {
        String sql = "update categories set categoryName=? where categoryName=\'" + oldCategory.getCategoryName() + "\'";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, newCategory.getCategoryName());
        int result = preparedStatement.executeUpdate();
        connection.close();
    }

    public void add(Category category) throws SQLException {
        String sql = "insert into categories (categoryName) values(?)";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, category.getCategoryName());
        int result = preparedStatement.executeUpdate();
        connection.close();
    }

    public void delete(String categoryName) throws SQLException {
        String sql = "delete from categories where categoryName = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, categoryName);

        int result = preparedStatement.executeUpdate();

        connection.close();
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
