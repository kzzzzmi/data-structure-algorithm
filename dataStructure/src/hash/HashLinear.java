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
		int address = hashFunc(key);
		if(hashTable[address] != null) {
			if(hashTable[address].key == key) {
				hashTable[address].value = value;
				return true;
			} else {
				int currAddress = address + 1;
				while(hashTable[currAddress] != null) {
					if(hashTable[currAddress].key == key) {
						hashTable[currAddress].value = value;
						return true;
					} else {
						if(currAddress >= hashTable.length) {
							return false;
						}
						currAddress++;
					}
				}
				hashTable[currAddress] = new Slot(key, value);
				return true;
			}
		} else {
			hashTable[address] = new Slot(key, value);
			return true;
		}
	}

	public String getData(String key) {
		int address = hashFunc(key);
		if(hashTable[address] != null) {
			if(hashTable[address].key == key) {
				return hashTable[address].value;
			} else {
				int currAddress = address + 1;
				while(hashTable[currAddress] != null) {
					if(hashTable[currAddress].key == key) {
						return hashTable[currAddress].value;
					} else {
						if(hashTable.length <= currAddress) {
							return null;
						}
						currAddress++;
					}
				}
			}
		}
		return null;
	}

}
