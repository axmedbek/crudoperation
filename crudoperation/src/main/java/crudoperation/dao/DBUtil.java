package crudoperation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by axmedbek on 7/10/17.
 */
public class DBUtil {

    private static final String DB_DRIVER="com.mysql.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/music";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="root";

    private static Connection con;

    public static Connection getConnection() throws ClassNotFoundException,SQLException
    {
        Class.forName(DB_DRIVER);
        con= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        return con;
    }
}
