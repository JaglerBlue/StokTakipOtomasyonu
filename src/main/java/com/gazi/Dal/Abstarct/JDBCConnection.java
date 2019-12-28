package com.gazi.Dal.Abstarct;

import com.gazi.Dal.Concrete.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public abstract class JDBCConnection {

    public Connection connection;
    public DbHelper helper;
    public Statement statement;
    public ResultSet resultSet;
    public PreparedStatement preparedStatement;

    public abstract String connectionStatus() throws SQLException;
}
