package mb;

import java.sql.*;

public class Check {
    public static boolean checkUserID(Account acc) throws Exception{
        boolean flag = false;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/pittInfo";
            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement ps = conn.prepareStatement("Select * from APP.UNTITLED where userID=? and password=?");
            ps.setString(1, acc.getUserID());
            ps.setString(2, acc.getPassword());
            ResultSet rs = ps.executeQuery();
            flag = rs.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
