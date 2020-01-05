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
	
	/**
	 * This is always return the element at
	 * position 0
	 * @return
	 */
	public int peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}
		
		return heap[0];
	}
	
	// this is the index of the item to be deleted
	public int delete(int index) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}
		
		int parentIndex = getParentIndex(index);
		int deletedValue = heap[index];
		
		// The last right most leaf 
		// would always be the replacement value
		// right most leaf is always at size - 1 position
		heap[index] = heap[size - 1];
		
		// this means that the deleted value is the root
		// then we look below OR
		// if the element to be deleted is less than its parent
		// then too we have to look below
		if (index == 0 || heap[index] < heap[parentIndex]) {
			fixHeapBelow(index, size - 1);
		} else {
			fixHeapAbove(index);
		}
		
		size--;
		
		return deletedValue;
	}
	
	/**
	 * This method fixes the heap above if child is 
	 * child is greater than its parent
	 * @param index: index at which we inserted the element
	 */
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
		// then we add newValue to its correct index
		heap[index] = newValue;
	}
	
	/**
	 * This method will check indices from starting from the 
	 * index that is deleted till the leaf which is till
	 * the end of the heap
	 * @param index: Index deleted
	 * @param lastHeapIndex: Leaf or size - 1
	 */
	private void fixHeapBelow(int index, int lastHeapIndex) {
		int childToSwap;
		
		// We loop until we go from the index
		// to be deleted till the leaf
		while (index <= lastHeapIndex) {
			
			int leftChild = getChildIndex(index, true);
			int rightChild = getChildIndex(index, false);
			
			// this means that the index which is deleted
			// has a left child
			if (leftChild <= lastHeapIndex) {
				
				// this means that index which is deleted
				// does not have a right child
				if (rightChild > lastHeapIndex) {
					childToSwap = leftChild;
				} else {
					// this means that the index which was
					// deleted has both left and right child
					// we have to find the maximum out of the
					// childs and make that its parent
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
				}
				
				// we check if the element at index is less than childToSwap
				// if yes we swap it
				if (heap[index] < heap[childToSwap]) {
					int temp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = temp;
				} else {
					
					// else we know that element at index is
					// greater than childToSwap
					break;
				}
				
				// finally we assign childToSwap to index
				// as we have to repeat the procedure again
				index = childToSwap;
				
			} else {
				break;
			}
		}
	}
	
	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + " ");
		}
		
		System.out.println();
	}
	
	private boolean isFull() {
		return size == heap.length;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	// parentIndex of a child: (index - 1) / 2
	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	// left child of the parent: 2 * parentIndex + 1
	// right child of the parent: 2 * parentIndex + 2
	private int getChildIndex(int parentIndex, boolean left) {
		return 2 * parentIndex + (left ? 1 : 2);
	}

}
