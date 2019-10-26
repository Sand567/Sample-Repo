package com.sandeep.trees.binarysearchtrees;

public class Tree {
	
	private TreeNode root;
	
	public void insert(int value) {
		if (root == null) { 
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}
	
	public TreeNode get(int value) {
		if (root != null) {
			return root.get(value);
		}
		
		return null;
	}
	
	public void delete(int value) {
		root = delete(root, value);
	}
	
	private TreeNode delete(TreeNode subTreeRoot, int value) {
		
		if (subTreeRoot == null) {
			return subTreeRoot;
		}
		
		if (value < subTreeRoot.getData()) {
			TreeNode dNode = delete(subTreeRoot.getLeftChild(), value);
			subTreeRoot.setLeftChild(dNode);
		} else if (value > subTreeRoot.getData()) {
			TreeNode dNode = delete(subTreeRoot.getRightChild(), value);
			subTreeRoot.setRightChild(dNode);
		} else {
			
			// this also means that value == subTreeRoot.getData()
			// cases 1 and 2: where node to be deleted has 0 or 1 child(ren)
			if (subTreeRoot.getLeftChild() == null) {
				
				// subTreeRoot is a leaf then both left and right child would be null
				// if it is not a leaf then the replacement node would be right Child
				return subTreeRoot.getRightChild();
			} else if (subTreeRoot.getRightChild() == null) {
				
				// subTreeRoot is a leaf then both left and right child would be null
				// if it is not a leaf then the replacement node would be left Child
				return subTreeRoot.getLeftChild();
			}
			
			// case 3: where node to be deleted has 2 children
			
			// Replace the value in the subTreeRoot node with the smallest value
			// from the right subtree
			subTreeRoot.setData(subTreeRoot.getRightChild().min());
			
			// delete the node that has the smallest value in the right subtree
			TreeNode nodeWithMinimumValue = delete(subTreeRoot.getRightChild(), subTreeRoot.getData());
			subTreeRoot.setRightChild(nodeWithMinimumValue);
			
		}
		
		// if it comes here, it means that this is not
		// the node to be deleted. Hence we just return it
		return subTreeRoot;
		
	}

	public int min() {
		if (root == null) {
			return Integer.MIN_VALUE;
		} else {
			return root.min();
		}
	}
	
	public int max() {
		if (root == null) {
			return Integer.MAX_VALUE;
		} else {
			return root.max();
		}
	}
	
	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}
	
	public void traversePreOrder() {
		if (root != null) {
			root.traversePreOrder();
		}
	}
	
}
