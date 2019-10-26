package com.sandeep.trees.binarysearchtrees;

public class TreeNode {
	
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public void insert(int value) {
		
		// we cannot insert duplicate nodes, so we just return
		if (value == data) {
			return;
		}
		
		if (value < data) {
			// this means there is no leftChild and this is 
			// the position to insert the new node
			if (leftChild == null) {
				leftChild = new TreeNode(value);
			} else {
				// go left and find the insertion point
				leftChild.insert(value);
			}
		} else {
			// this means there is no rightChild and this is 
			// the position to insert the new node
			if (rightChild == null) {
				rightChild = new TreeNode(value);
			} else {
				// go right and find the insertion point
				rightChild.insert(value);
			}
		}
	}
	
	public TreeNode get(int value) {
		if (value == data) {
			return this;
		}
		
		if (value < data) {
			if (leftChild != null) {
				return leftChild.get(value);
			}
		} else {
			if (rightChild != null) {
				return rightChild.get(value);
			}
		}
		
		// when it comes to this point 
		// that means there is no node with this value in the tree
		return null;
	}
	
	public int min() {
		if (leftChild == null) {
			return data;
		} else {
			return leftChild.min();
		}
	}
	
	public int max() {
		if (rightChild == null) {
			return data;
		} else {
			return rightChild.max();
		}
	}
	
	public void traverseInOrder() {
		// traverse left subtree and print nodes
		if (leftChild != null) {
			leftChild.traverseInOrder();
		}
		
		// print current root node for this subtree
		System.out.print(data + " ");
		
		// traverse right subtree and print nodes
		if (rightChild != null) {
			rightChild.traverseInOrder();
		}
	}
	
	public void traversePreOrder() {
		
		// print current root node for this subtree
		System.out.print(data + " ");
		
		// traverse left subtree and print nodes
		if (leftChild != null) {
			leftChild.traversePreOrder();
		}
		
		// traverse right subtree and print nodes
		if (rightChild != null) {
			rightChild.traversePreOrder();
		}
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
	
}
