import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class SerializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e= new Employee();
		e.name="Gazal Tewatia";
		e.address="235/8 ,faridabad";
		e.SSN=11122333;
		e.number=101;
		try {
			FileOutputStream fileout=new FileOutputStream("employee.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileout);
			out.writeObject(e);
			out.close();
			fileout.close();
			System.out.println("Serialized data is saved in/tmp/employee.ser");
		}catch(IOException i) {
			i.printStackTrace();
		}
	}

}
