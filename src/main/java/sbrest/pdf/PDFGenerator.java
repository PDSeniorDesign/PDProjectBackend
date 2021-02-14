package sbrest.pdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PDFGenerator {
	public static void main(String[] argv) {
		Connection c = null;
		try {
            String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs4962stu04?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs4962stu04";
			String password = "hsO0ZV37d0Ok";

			// Make a connection to the database
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from service_requests");

			// Get all rows from the result set
			while (rs.next()) {

				int gmail = rs.getInt("gmail_access");
				
				
				System.out.println(gmail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
}
}