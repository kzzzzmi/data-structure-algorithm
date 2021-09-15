package hash;

public class Hash {
	
	public Slot[] hashTable;
	int size;
	
	public Hash(int size) {
		hashTable = new Slot[size];
		this.size = size;
	}
	
	public class Slot {
		String value;
		String key;
		Slot next;
		public Slot(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public int hashFunc(String key) {
		 int index = 0;
	        for(int i = 0; i < key.length(); i++) {
	            index += key.charAt(i);
	        }
	        return (int)(index % size);
	}
	
	public boolean saveData(String key, String value) {
		int address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			Slot findSlot = this.hashTable[address];
			Slot prevSlot = null;
			while(findSlot != null) {
				if(findSlot.key == key) {
					findSlot.value = value;
					return true;
				} else {
					prevSlot = findSlot;
					findSlot = findSlot.next;
				}
			}
			prevSlot.next = new Slot(key, value);
		} else {
			this.hashTable[address] = new Slot(key, value);		
		}	
		return true;
	}
	
	public String getData(String key) {
		int address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			Slot findSlot = this.hashTable[address];
			while(findSlot != null) {
				if(findSlot.key == key) {
					return findSlot.value;
				} 
				findSlot = findSlot.next;
			}
		}
		return null;
	}
	
}
