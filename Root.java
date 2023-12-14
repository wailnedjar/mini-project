package student_managment;

import java.io.*;
import java.util.ArrayList;


public final class Root extends Person implements Serializable{


	/**
	  
	 **/
	private static final long serialVersionUID = 1L;

	Root(String name, String email, String department_type) {
		super(name, email, department_type);
		
	}
	
	static void serializble (ArrayList<Root> r) throws IOException {
		
		 try {
			FileOutputStream fileout = new FileOutputStream("root.ser",true) ;
			ObjectOutputStream out = new ObjectOutputStream(fileout) ;
			out.writeObject(r);
			out.close () ;
			fileout.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Root> deserializble() throws IOException, ClassNotFoundException {

		FileInputStream input = new FileInputStream("C:\\Users\\asus\\Documents\\project1-files\\root.ser") ;
		ObjectInputStream in = new ObjectInputStream(input) ;
		ArrayList<Root> root = null ;
	try {  
					root = (ArrayList<Root>) in.readObject() ;	
	}catch (ClassNotFoundException | IOException  | ClassCastException e) {
		System.out.println("error");
	}
	return root;

	}

	
	
	
	
}
