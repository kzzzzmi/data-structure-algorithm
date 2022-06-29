package hash;

public class Hash<T> {
	
	public Slot<T>[] hashTable;
	int size;
	
	@SuppressWarnings("unchecked")
	public Hash(int size) {
		hashTable = new Slot[size];
		this.size = size;
	}
	
	@SuppressWarnings("hiding")
	public class Slot<T> {
		T value;
		String key;
		Slot<T> next;
		public Slot(String key, T value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public int hashFunc(String key) {
		 int index = 0;
	        for(int i = 0; i < key.length(); i++) {
	            index += key.charAt(i);
	        }
	        return index % size;
	}
	
	public boolean saveData(String key, T value) {
		int address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			Slot<T> findSlot = this.hashTable[address];
			Slot<T> prevSlot = findSlot;
			while(findSlot != null) {
				if(findSlot.key == key) {
					findSlot.value = value;
					return true;
				} else {
					prevSlot = findSlot;
					findSlot = findSlot.next;
				}
			}
			prevSlot.next = new Slot<T>(key, value);
		} else {
			this.hashTable[address] = new Slot<T>(key, value);		
		}	
		return true;
	}
	
	public T getData(String key) {
		int address = hashFunc(key);
		Slot<T> slot = this.hashTable[address];
		if(slot != null) {
			while(slot != null) {
				if(slot.key == key) {
					return slot.value;
				} else {
					slot = slot.next;
				}
			}
		}		
		return null;
	}
}
