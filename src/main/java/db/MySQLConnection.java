package db;

import javax.ejb.Stateless;
import java.sql.*;

public class MySQLConnection {

    private Connection connection;

    public MySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean createDataBase(){
        boolean success = false;
        connect();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS profesoresJC(id INT PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(100),facultad VARCHAR(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS cursosJC(id INT PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(100),programa VARCHAR(100), profesorID INT, FOREIGN KEY (profesorID) REFERENCES  profesoresJC(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantesJC(id INT PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(100),codigo VARCHAR(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantes_cursosJC(id INT PRIMARY KEY AUTO_INCREMENT,estudianteID INT,profesorID INT, FOREIGN KEY (estudianteID) REFERENCES estudiantesJC(id), FOREIGN  KEY (profesorID) REFERENCES profesoresJC(id))");

            success = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            success = false;
        }finally {
            disconnect();
        }
        return success;
    }

    public void executeSQL(String sql){
        connect();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            disconnect();
        }
    }

    public ResultSet query(String sql){
        ResultSet output = null;
        try {
            connect();
            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

}
