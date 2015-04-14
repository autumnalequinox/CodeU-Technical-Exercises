package Set2;

import java.util.*;

public class BinaryTree {
	
	BinaryTreeNode root;
	public BinaryTree(){
		root = new BinaryTreeNode();
	}
	
	public BinaryTreeNode getRoot(){
		return root;
	}

	public static List<String> flatten(BinaryTree tree){
		if(tree != null){
		List<String> treeList = new ArrayList<String>();
		addToList(tree.getRoot(),treeList);
		return treeList;
		}
		else 
			return null;
	}
	
	//uses preorder traversal to go through tree
	private static void addToList(BinaryTreeNode root, List<String> list){
		if(root == null)
			return;
		else
		{
			list.add(root.getPayload());
			
			addToList(root.getLeft(), list);
			
			addToList(root.getRight(), list);
		}
	}
	
	//creates a tree of specified depth, that fills each level with the index of its level
	public static void fillTree(BinaryTreeNode root, int index, int depth){
		if(index == depth){
			root.setPayload(new String(""+index));
			return;
		}

		root.setPayload(new String(""+index));
		root.setLeft(new BinaryTreeNode());
		root.setRight(new BinaryTreeNode());
		
		fillTree(root.getLeft(),index+1,depth);
		fillTree(root.getRight(),index+1,depth);
	}
	
	public static class BinaryTreeNode{
		String payload;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		public BinaryTreeNode(){
			payload = "";
			left = null;
			right = null;
		}
		
		public BinaryTreeNode(String payload, BinaryTreeNode left, BinaryTreeNode right){
			this.payload =payload;
			this.left = left;
			this.right = right;
		}
		
		public void setLeft(BinaryTreeNode left){
			this.left = left;
		}
		
		public void setRight(BinaryTreeNode right){
			this.right = right;
		}
		
		public void setPayload(String payload){
			this.payload = payload;
		}
		
		public BinaryTreeNode getLeft(){
			return left;
		}
		
		public BinaryTreeNode getRight(){
			return right;
		}
		
		public String getPayload(){
			return payload;
		}
	}
	
	public static void main(String [] args){
		BinaryTree tree = null;
		
		List<String> nullList = flatten(tree);
		if(nullList == null)
			System.out.println("Null tree success");
		else
			System.out.println("Null tree failure");
		
		tree = new BinaryTree();
		tree.fillTree(tree.getRoot(), 1, 1);
		
		System.out.println("Tree depth 1:\nExpect: 1");
		List<String> list = flatten(tree);
		String out = "Actual: ";
		for(String element: list)
			out += element + "\t";
		System.out.println(out + "\n");
		
		tree = new BinaryTree();
		tree.fillTree(tree.getRoot(), 1, 2);
		
		System.out.println("Tree depth 2:\nExpect: 1\t2\t2");
		list = flatten(tree);
		out = "Actual: ";
		for(String element: list)
			out += element + "\t";
		System.out.println(out + "\n");
		
		tree = new BinaryTree();
		tree.fillTree(tree.getRoot(), 1, 3);
		
		System.out.println("Tree depth 3:\nExpect: 1\t2\t3\t3\t2\t3\t3");
		list = flatten(tree);
		out = "Actual: ";
		for(String element: list)
			out += element + "\t";
		System.out.println(out + "\n");
		
		tree = new BinaryTree();
		tree.fillTree(tree.getRoot(), 1, 4);
		
		System.out.println("Tree depth 4:\nExpect: 1\t2\t3\t4\t4\t3\t4\t4\t2\t3\t4\t4\t3\t4\t4");
		list = flatten(tree);
		out = "Actual: ";
		for(String element: list)
			out += element + "\t";
		System.out.println(out+"\n");
	}

}
