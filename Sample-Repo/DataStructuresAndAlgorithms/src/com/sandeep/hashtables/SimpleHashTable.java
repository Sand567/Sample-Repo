package com.sandeep.hashtables;

public class SimpleHashTable {

	private StoredEmployee[] hashTable;
	
	public SimpleHashTable() {
		hashTable = new StoredEmployee[10];
	}
	
	// we consume a string and convert to an integer
	private int hashKey(String key) {
		int hashedKey = key.length() % hashTable.length;
		System.out.println("hashedKey: " + hashedKey);
		return hashedKey;
	}

	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		
		if (occupied(hashedKey)) {
			
			// this is the index to increment
			// this happens when we keep incrementing and reach the end of the array
			// and loop back to 0 and start over finally reach stopIndex 
			// which is where we stop incrementing
			int stopIndex = hashedKey;
			
			// this sets the 1st probe position
			if (hashedKey == hashTable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}
			
			// this will set the next probe position in each iteration
			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashTable.length;
			}
			
		}
		
		// this means that there is already an employee
		// at hashedKey's position
		if (occupied(hashedKey)) {
			System.out.println("Sorry, there is already an employee at the position: " + hashedKey);
		} else {
			hashTable[hashedKey] = new StoredEmployee(key, employee);
		}
	}
	
	private boolean occupied(int index) {
		return hashTable[index] != null;
	}
	
	public Employee get(String key) {
		int hashedKey = findKey(key);
		
		if (hashedKey == -1) {
			return null;
		}

		return hashTable[hashedKey].employee;
	}
	
	public Employee remove(String key) {
		int hashedKey = findKey(key);
		
		if (hashedKey == -1) {
			return null;
		}
		
		Employee employee = hashTable[hashedKey].employee;
		hashTable[hashedKey] = null;
		return employee;
	}
	
	private int findKey(String key) {
		int hashedKey = hashKey(key);
		
		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		
		int stopIndex = hashedKey;
		if (hashedKey == hashTable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}
		
		while (hashedKey != stopIndex 
				&& hashTable[hashedKey] != null
				&& !hashTable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashTable.length;
		}
		
		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
	}
	
	public void printHashTable() {
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] == null) {
				System.out.println("empty");
			} else {
				System.out.println("Position: " + i + ": " + hashTable[i].employee);
			}
		}
	}
	
}
