package practice.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run2_DeSerTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("./f.txt"); //To read data from file, create an object of FileInputStream
		ObjectInputStream ois = new ObjectInputStream(fis); // To get the binary data available in this file back to java object
		NFSGame user1Obj = (NFSGame) ois.readObject();//To de-serialize that is to return the object of the game
		//make sure you are trying to receive the object using the same class, as you are trying to retrieve this data back
		//ObjectInputStream is a superclass, so you have to do down-casting to NFSGame
		
		//To display the game info in the console
		System.out.println(user1Obj.name);
		System.out.println(user1Obj.level);
		System.out.println(user1Obj.score);
		System.out.println(user1Obj.life);
		//From the binary file we will be getting the current status of the object
	}
}
