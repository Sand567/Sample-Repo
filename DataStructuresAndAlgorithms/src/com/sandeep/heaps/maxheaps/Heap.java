package com.sandeep.heaps.maxheaps;

public class Heap {
	
	private int[] heap;
	private int size;
	
	public Heap(int capactiy) {
		heap = new int[capactiy];
	}
	
	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Heap is full");
		}
		
		heap[size] = value;
		
		// it does not meet the property of heap
		// we then need to heapify the heap which we do that here
		fixHeapAbove(size);
		size++;
	}
	
	private void fixHeapAbove(int index) {
		
		// this is the value which we inserted
		int newValue = heap[index];
		
		// if the index == 0 then it is the root 
		// we check if newValue > newValue's parent
		while (index > 0 && newValue > heap[getParentIndex(index)]) {
			
			// we assign the parent's value to the child's position
			heap[index] = heap[getParentIndex(index)];
			
			// we then update the index to its parent's index
			// we do this because the exact position of newValue
			// may not have been found yet. So we keep fetching its parent
			// to check if its lesser or greater
			index = getParentIndex(index);
			
		}
		
		// once we drop out of the loop, it should
		// either be index == 0 or newValue is less than its parent
		// then we add newValue to its right index
		heap[index] = newValue;
	}
	
	public boolean isFull() {
		return size == heap.length;
	}
	
	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

}
