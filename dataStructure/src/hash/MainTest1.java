package hash;

public class MainTest1 {

	public static void main(String[] args) {

		Hash<String> myHash = new Hash<>(20);
		myHash.saveData("DaveLee1", "010123456789");
		myHash.saveData("DaveLee1", "555");
		myHash.saveData("funcoding", "9876543210");
		System.out.println(myHash.getData("DaveLee1"));
	}

}

