import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[]  args) throws IOException  {
		FileOutputStream fout=new FileOutputStream("f1.txt");
		BufferedOutputStream bout =new BufferedOutputStream(fout);
		String s="Sachin is my favourite player";
		byte b[]=s.getBytes();
		bout.write(b);
		
		bout.flush();
		bout.close();
		fout.close();
		 System.out.println("Success");
	}

}
