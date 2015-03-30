/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.sql.*;
/**
 *
 * @author Administrator
 * this class is databse associate layout, for operate the database, other class can handle this class to operate the database
 */
public class DAL {
    Connection conn;
    Statement state;
    ResultSet rs;
    public  DAL() throws ClassNotFoundException, SQLException{
        this.conn=getConnection();
    }
    //get the Connection
    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        //If you put the database other places, you need to specify the path of the mdb (access database)
        Connection con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir").replace("bin", "webapps")+"\\Chat.mdb");
        return con;
    }
    //execute the result with result (used in select)
    public ResultSet QueryExecute(String sql) throws SQLException{
        state=conn.createStatement();
        state.execute(sql);
        rs=state.getResultSet();
        return rs;
    }
    //execute the result without result(used in update,delete,insert)
    public void nonQueryExecute(String sql) throws SQLException{
        state=conn.createStatement();
        state.execute(sql);
    }
    //close all the object associate with database operation
    public void Dispose() throws SQLException{
        rs.close();
        state.close();
        conn.close();
    }
    
}
