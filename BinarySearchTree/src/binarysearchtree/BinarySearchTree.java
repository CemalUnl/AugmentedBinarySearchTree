/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Vector;

/**
 *
 * @author cemal
 */
public class BinarySearchTree {

    
    public Node root;

  public void insert(int value){
    Node node = new Node<>(value);

    if ( root == null ) {
      root = node;
      return;
    }

    insertRec(root, node);

  }

  private void insertRec(Node latestRoot, Node node){

    if ( latestRoot.value > node.value){

      if ( latestRoot.left == null ){
        latestRoot.left = node;
        return;
      }
      else{
        insertRec(latestRoot.left, node);
      }
    }
    else{
      if (latestRoot.right == null){
        latestRoot.right = node;
        return;
      }
      else{
        insertRec(latestRoot.right, node);
      }
    }
  }
  
  public int findMinimum(){
  if ( root == null ){
    return 0;
  }
  Node currNode = root;
  while(currNode.left != null){
    currNode = currNode.left;
  }
  return currNode.value;
}
  
  public int allSum(Node node){
      if(node == null){
      return 0;
      }
      else{
  int val=node.value;
  node.value=allSum(node.left)+allSum(node.right);
  return node.value + val;  
  }
  }
  
  
  
  
  public int sumSmaller(int id){
		Node current = root;
                int sum = 0;
		while(current!=null){
                        if(current.value>id){
                                
				current = current.left;
                                
			}
                        
                        else{
                                sum +=current.value; 
				current = current.right;
                                
			}
                        
		}
		return sum;
                
}
  
  public int findMaximum(){
  if ( root == null){
    return 0;
  }
  

  Node currNode = root;
  while(currNode.right != null){
    currNode = currNode.right;
  }
  return currNode.value;
}
  public void printInorder(){
  printInOrderRec(root);
  System.out.println("");
  
}  
  private void printInOrderRec(Node currRoot){
  if ( currRoot == null ){
    return;
  }
  printInOrderRec(currRoot.left);
  System.out.print(currRoot.value+", ");
  printInOrderRec(currRoot.right);
}

  
  //-------------------------------------
  
  int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    Node inserted(Node node, int key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));
 
        if (key < node.value)
            node.left = inserted(node.left, key);
        else if (key > node.value)
            node.right = inserted(node.right, key);
        else // Duplicate keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.value)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key > node.right.value)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
   
  
}
