package hash;

public class HashLinear {

	public Slot[] hashTable;
	int size;

	public HashLinear(int size) {
		hashTable = new Slot[size];
		this.size = size;
	}

	public class Slot {
		String value;
		String key;

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

		while (this.hashTable[address] != null) {
			if (this.hashTable[address].key == key) {
				this.hashTable[address].value = value;
				return true;
			} else {
				address++;
				if (address >= this.hashTable.length) {
					return false;
				}
			}
		}
		this.hashTable[address] = new Slot(key, value);
		return true;
	}

	public String getData(String key) {
		int address = this.hashFunc(key);
		while (this.hashTable[address] != null) {
			if (this.hashTable[address].key == key) {
				return this.hashTable[address].value;
			} else {
				address++;
				if (address >= this.hashTable.length) {
					return null;
				}
			}
		}
		return null;
	}

}
