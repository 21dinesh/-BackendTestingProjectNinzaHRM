package practice.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable {
	
	// This interface is going to tell you that this class is Serializable
	// Serializable is a marker interface, that is, any interface which contains
	// empty methods is a marker interface.
	// So its just an indication saying that particular class implementing it is
	// serializable
	// So in order to achieve Serialization you have to implement Serializable
	// interface

	String name;
	int level;
	long score;
	int life;

	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class Run1_SerTest {
	
	public static void main(String[] args) throws IOException {
		
		NFSGame user1Obj = new NFSGame("Rohit", 15, 60000, 1);
		FileOutputStream fos = new FileOutputStream("./f.txt");// to write it back to text file
		
		ObjectOutputStream oos = new ObjectOutputStream(fos); //Convert the java object to binary
		oos.writeObject(user1Obj);
		
		//After this execution entire java object should be converted to binary format
		System.out.println("End");
	}
}
