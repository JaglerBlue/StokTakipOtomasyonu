/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Dal.Concrete;

import com.gazi.Dal.Abstarct.JDBCConnection;
import com.gazi.Entity.Product;
import com.gazi.Entity.ProductDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

final public class JDBCProductDal extends JDBCConnection {

    public JDBCProductDal() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public ArrayList<ProductDetail> getAllWithCategoryName() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select productName,quantityOfStocks,categoryName from products join categories on products.categoryId = categories.id");
            ArrayList<ProductDetail> productDetails = new ArrayList<>();
            while (resultSet.next()) {
                productDetails.add(new ProductDetail(resultSet.getString("productName"), resultSet.getInt("quantityOfStocks"),
                        resultSet.getString("categoryName")));
            }
            return productDetails;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }

    public ArrayList<ProductDetail> getAllByCategoryName(String categoryName) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select productName,quantityOfStocks,categoryName from products join categories on products.categoryid = categories.id where categoryName = \'" + categoryName + "\'");

            ArrayList<ProductDetail> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new ProductDetail(resultSet.getString("productName"), resultSet.getInt("quantityOfStocks"),
                        resultSet.getString("categoryName")));
            }

            return products;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
        return null;
    }

    public void update(Product oldProduct, Product newProduct) throws SQLException {

        String sql = "update products set productName=?,quantityOfStocks=? where productName=\'" + oldProduct.getProductName()+"\'";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, newProduct.getProductName());
        preparedStatement.setInt(2, newProduct.getQuantityOfStock());
        int result = preparedStatement.executeUpdate();
        connection.close();
    }

    public void add(ProductDetail product) throws SQLException {

        statement = connection.createStatement();
        resultSet = statement.executeQuery("select id from categories where categoryName = \'" + product.getCategoryName() + "\'");
        int categoryId = 0;
        if (resultSet.next()) {
            categoryId = resultSet.getInt("id");
        }

        String sql = "insert into products (productName,quantityOfStocks,categoryId) values(?,?,?)";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setInt(2, product.getQuantityOfStock());
        preparedStatement.setInt(3, categoryId);
        int result = preparedStatement.executeUpdate();

        statement.close();
        connection.close();
    }

    public void delete(String productName) throws SQLException {
        String sql = "delete from products where productName = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, productName);

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
