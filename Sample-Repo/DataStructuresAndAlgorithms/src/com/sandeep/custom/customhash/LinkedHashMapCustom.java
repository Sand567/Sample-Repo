package com.sandeep.custom.customhash;

public class LinkedHashMapCustom<K, V> {
	
	private Entry<K, V>[] table;
	private int capacity = 4;
	private Entry<K, V> head;
	private Entry<K, V> last;
	
	@SuppressWarnings("unchecked")
	public LinkedHashMapCustom() {
		table = new Entry[capacity];
	}
	
	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		Entry<K, V> after;
		Entry<K, V> before;
		
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

		public Entry<K, V> getAfter() {
			return after;
		}

		public void setAfter(Entry<K, V> after) {
			this.after = after;
		}

		public Entry<K, V> getBefore() {
			return before;
		}

		public void setBefore(Entry<K, V> before) {
			this.before = before;
		}
		
	}
	
	public void put(K newKey, V data) {
		if (newKey == null) {
			return;
		}
		
		int hash = hash(newKey);
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);
		maintainOrderAfterInsert(newEntry);
	}

	private void maintainOrderAfterInsert(Entry<K, V> newEntry) {
		
		if (head == null) {
			head = newEntry;
			last = newEntry;
			return;
		}
		
		if (head.getKey().equals(newEntry.getKey())) {
			deleteFromHead();
			insertAtHead(newEntry);
			return;
		}
		
		if (last.getKey().equals(newEntry.getKey())) {
			deleteFromTail();
			insertAtTail(newEntry);
			return;
		}
		
		Entry<K, V> beforeDeleteEntry = deleteSpecificEntry(newEntry);
		if (beforeDeleteEntry == null) {
			insertAtTail(newEntry);
		} else {
			insertAfterEntry(beforeDeleteEntry, newEntry);
		}
		
	}

	private void insertAfterEntry(Entry<K, V> beforeDeleteEntry, Entry<K, V> newEntry) {
		
	}

	private Entry<K, V> deleteSpecificEntry(Entry<K, V> newEntry) {
		Entry<K, V> current = head;
		
		while (!current.getKey().equals(newEntry)) {
			// current is at the last node and there are no nodes after
			// hence we did not find the entry and we return null
			if (current.getAfter() == null) {
				return null;
			}
			
			current = current.getNext();
		}
		
		Entry<K, V> beforeDeleteEntry = current.getBefore();
		current.getBefore().setAfter(current.getAfter());
		current.getAfter().setBefore(current.getBefore());
		return beforeDeleteEntry;
	}

	private void insertAtTail(Entry<K, V> newEntry) {
		if (head == null) {
			head = newEntry;
			last = newEntry;
			return;
		}
		
		last.setAfter(newEntry);
		newEntry.setBefore(last);
		last = newEntry;
	}

	private void deleteFromTail() {
		if (head == last) {
			head = last = null;
			return;
		}
		
		last = last.getBefore();
		last.setAfter(null);
	}

	// inserts at the head
	private void insertAtHead(Entry<K, V> newEntry) {
		if (head == null) {
			head = newEntry;
			last = newEntry;
			return;
		}
		
		newEntry.setAfter(head);
		head.setBefore(newEntry);
		head = newEntry;
	}

	// deletes entry from the head
	private void deleteFromHead() {
		// if there is just a single entry node
		if (head == last) {
			head = last = null;
			return;
		}
		
		head = head.getAfter();
		head.setBefore(null);
	}

	private int hash(K newKey) {
		return Math.abs(newKey.hashCode()) % capacity;
	}
	
}
