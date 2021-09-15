package hash;

public class MainTest1 {

	public static void main(String[] args) {

		HashLinear mainObject = new HashLinear(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("David", "01044445555");
		mainObject.saveData("Dave", "01055556666");
		System.out.println(mainObject.getData("DaveLee"));
		
	}

}

