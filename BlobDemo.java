import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BlobDemo {
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc","root","gazal18");	
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	public void writeBlob(int candidateID,String filename)
	{
		String updateSQL="UPDATE candidates SET resume=? where id=?";
		try {
			pstmt=con.prepareStatement(updateSQL);
			
			File file=new File(filename);
			FileInputStream input=new FileInputStream(file);
			
			pstmt.setBinaryStream(1,input);
			pstmt.setInt(2, candidateID);
			
			System.out.println("Reading file"+file.getAbsolutePath());
			System.out.println("Store file in database");
			pstmt.executeUpdate();
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlobDemo bd1=new BlobDemo();
		bd1.createConnection();
		bd1.writeBlob(122,"D:\\gazal\\AdvancedJava\\src\\johndoe_resume.pdf");
		
	}

}
