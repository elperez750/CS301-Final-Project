/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpackage;
import java.util.*;

/**
 * A generic recursive binary tree implementation.
 * This class represents a binary tree where each node contains a value and references to left and right subtrees.
 * 
 * @author elper2
 * @param <T> the type of elements stored in this tree
 */
public class BinaryTree<T> {
  
        T value;
        BinaryTree<T> left;
        BinaryTree<T> right;
        
        
    // create empty constructor for creating the tree.    
    private BinaryTree() {}

    /**
     * Constructs a binary tree from a level-order array representation.
     * Creates a complete binary tree where array elements represent nodes in level-order.
     * A null value in the array represents a non-existent node.
     * 
     * @param values the array of values in level-order traversal
     * @throws IllegalArgumentException if the array is invalid (child exists but parent is null)
     */    
    public BinaryTree(T[] values) {
        // If no array is passed or it is empty or the first value is null, we
        // simply create a null tree
          if (values == null || values.length == 0 || values[0] == null) {
            this.value = null;
            this.left = null;
            this.right = null;
            return;
        }
    
        
        // Perform check to see if parent is null and has children.
        // If that is the case then the array is invalid and we do not create Binary tree.
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null && values[(i - 1) / 2] == null) {
                throw new IllegalArgumentException("Invalid array: child exists but parent is null");
            }
            
        }
        
        
        // Call our recursive helper to build the tree
        BinaryTree<T> root = BinaryTreeBuilder(values, 0);
       
        // Once root is returned, we asign this.value, this.left, and this.right
        // to the root's values
        this.value = root.value;
        this.left = root.left;
        this.right = root.right;

            
       
       
        
    }
    
    /**
     * Recursive helper method to build the binary tree from an array.
     * Constructs the tree using level-order indexing where left child is at 2*i+1 and right child is at 2*i+2.
     * 
     * @param values the array of values
     * @param index the current index in the array
     * @return the constructed BinaryTree node, or null if index is out of bounds or value is null
     */
    private BinaryTree<T> BinaryTreeBuilder(T[] values, int index) {
        
     
        // We check if index is out of bounds or if the value is null
        if (index >= values.length || values[index] == null) {
            return null;
        }
        
        
        // Create new node 
        BinaryTree<T> node = new BinaryTree<>();
        node.value = values[index];
        
        // Recursively check the left subtree
        node.left = BinaryTreeBuilder(values, (2*index) + 1);
        
        // Recursively check the right subtree
        node.right = BinaryTreeBuilder(values, (2*index) + 2);
        
        
        // Return the value of the node
        return node;
        
        
    }
    

    /**
     * Returns a string representation of the binary tree in level-order traversal.
     * The format is [value1, value2, value3, ..., null, null, ...] where null represents absent nodes.
     * 
     * @return a string representation of this tree
     */
    // Level order traversal
    @Override
    public String toString() {
        // We create a queue to process level order
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        // This will store our final result as a formatted string
        StringBuilder result = new StringBuilder();
        // Add the root element to enter while loop
        queue.add(this);
        result.append("[");
        
        // While the queue is not empty we will process the node and append children
        while (!queue.isEmpty()) {
            // Node to process
            BinaryTree<T> currentNode = queue.remove();
            // If the node is null we just add null to result
            // This is first because we don't want to get left or right of a null node
            if (currentNode == null) {
                if (queue.isEmpty()) {
                    result.append("null");
                }
                else{
                    result.append("null, ");
                    
                }
            } else {
                // Append value to the stringBuilder object
                result.append(currentNode.value).append(", ");
                // Add left and right child to process
                queue.add(currentNode.left);  
                queue.add(currentNode.right); 
            }
        }
                
        // once we have processed all nodes, add ending bracket
        result.append("]");
        
            
        // Convert object to string and return
         return result.toString();
        }
    
    
    /**
     * Checks if the tree contains the specified value.
     * Performs a recursive search through the entire tree.
     * 
     * @param value the value to search for
     * @return true if the value is found in the tree, false otherwise
     */
    // This will help us determine if a value is in the tree.
    public boolean contains(T value) {
        // We use a helper since contains only takes in the generic value, not the actual tree object
        return containsHelper(this, value);
        
    }
    
    /**
     * Recursive helper method to search for a value in the tree.
     * 
     * @param node the current node being examined
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
       // Helper for contains
      private boolean containsHelper(BinaryTree<T> node, T value) {
        // If node is equal to false then we return false for the subtree
        if (node == null) {
            return false;
        }
        
        // If the node we process is the value we return true.
        // We will return true after both branches are processed
        if (node.value == value) {
            return true;
        
        }
      
        // Call helper on the left subtree
        boolean left = containsHelper(node.left, value);
        // Call helper on the right subtree
        boolean right = containsHelper(node.right, value);
            
       
      
        // If either one returned true, there is no need to check anymore and we return true.
        return left || right;
    }
    
    
    /**
     * Determines if the tree is balanced.
     * A binary tree is balanced when, for every node, the height difference 
     * between its left and right subtrees is at most 1.
     * 
     * @return true if the tree is balanced, false otherwise
     */
    // This will determine if all right and left subtrees heights differ by 1 or less
    public boolean isBalanced(){
        // I used a helper to not have the driver class pass in the root.
        return isBalancedHelper(this) != -1;
        
    }
    
    /**
     * Recursive helper method to check if the tree is balanced.
     * Returns the height if balanced, or -1 if unbalanced.
     * 
     * @param node the current node being examined
     * @return the height of the subtree if balanced, -1 if unbalanced
     */
    public int isBalancedHelper(BinaryTree<T> node) {
        // if the node is null, we simply return 0 and start calculating differences
        if (node == null) {
            return 0;
        }
        
        
        // This will get the height of the left subtree
        int leftHeight = isBalancedHelper(node.left);
        // This will get the height of the right subtree
        int rightHeight = isBalancedHelper(node.right);
        
        // When both subtrees return, we compare the absolute difference
        // If the difference is greater than 1, we know that the tree will not be balanced.
        if(Math.abs(leftHeight - rightHeight) > 1)  {
            return -1;
        }
        
        // This simply propogates -1 if we already encountered an unbalanced subtree
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        
        
        // If the subtrees are not unbalanced, then we will calculate the height for the current root node
        return 1 + Math.max(leftHeight, rightHeight);
        
       
        
    }
    
    
    /**
     * Calculates the height of the tree.
     * The height is defined as the number of edges on the longest path from root to leaf.
     * An empty tree has height -1.
     * 
     * @return the height of the tree
     */
    // This will be similar to our isBalanced method in the sense that we compute height the same way
    public int height() {
        if (this.value == null) {
            return -1;
        }
        
        
        // Used helper again in order to not have driver class pass in the root node.
        return heightHelper(this);
        
    }
    
    /**
     * Recursive helper method to calculate the height of the tree.
     * 
     * @param node the current node being examined
     * @return the height of the subtree rooted at this node
     */
    public int heightHelper(BinaryTree<T> node) {
        // If we reach the bottom of a subtree, then we begin to calculate the height of that subtree
        if (node == null) {
            // We use -1 to count the nodes below a given root
            // If we wanted to get height based on edges, we would start with 0 instead
            return -1;
        }
        
        // Recursively calculate height of left subtree
        int leftHeight = heightHelper(node.left);
        
        // Recursively calculate height of right subtree
        int rightHeight = heightHelper(node.right);
        
        // Calculate height by getting the max of both heights and adding one
        return 1 + Math.max(rightHeight, leftHeight);
    }
    
    
    /**
     * Determines if the tree is complete.
     * A binary tree is complete if all levels are completely filled except possibly the last,
     * and the last level has all nodes as far left as possible.
     * 
     * @return true if the tree is complete, false otherwise
     */
  
    // This method will check if every level except possibly the last one is full
    // If the last level is not full, then all nodes with values must be left of the null nodes
    public boolean isComplete() {
        
        // I used a queue since we need level order traversal for this method
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        // Add the root of the tree to queue
        queue.add(this);
        // This will serve as a flag for when we see a null value
        // If we see a null value, then that means the remaining nodes must be null in order to be complete
        boolean seenNull = false;
        while(!queue.isEmpty()) {
            // current node to process
            BinaryTree<T> currentNode = queue.remove();
            
            // If we have seen a null value, that means the current node must be null
            if (seenNull) {
                // If the current node is not null, then it means that we have non null values to the right of our null value.
                if (currentNode != null) {
                    return false;
                }
            }
            
            // If the seenNull was not checked but the current node is null, we set our flag to true for the next iteration
            if (currentNode == null) {
                seenNull = true;
            }
            
            // Otherwise we will process the left and right subtree of the current node
            else {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
            
        }
        
        // If we exit our while, that means we were able to process all nodes and the tree was complete
        return true;
    }
    
    /**
     * Compares this tree with another object for equality.
     * Two trees are equal if they have the same structure and the same values at corresponding positions.
     * 
     * @param obj the object to compare with
     * @return true if the trees are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Check if comparing to itself
        if (this == obj) return true;

        // Check if obj is null or wrong type
        if (obj == null || !(obj instanceof BinaryTree)) {
            return false;
        }

        BinaryTree<T> treeToCompare = (BinaryTree<T>) obj;
        return equalsHelper(this, treeToCompare);
    }

    /**
     * Recursive helper method to compare two trees for equality.
     * 
     * @param treeOne the first tree to compare
     * @param treeTwo the second tree to compare
     * @return true if the trees are equal in structure and values, false otherwise
     */
    public boolean equalsHelper(BinaryTree<T> treeOne, BinaryTree<T> treeTwo) {
        // The logic here is that if they are both null, we reached the bottom of the subtree for both.
        // That means that either the trees are null or we did not return false from our other case
        // Either way, the subtrees are equal and we return true.
        if (treeOne == null && treeTwo == null) {
            return true;
        }
        
        // If only one is null or their values are not the same we return false
        // We check nulls first in order to not get error calling tree.value
        if ((treeOne == null || treeTwo == null) || treeOne.value != treeTwo.value) {
            return false;
        }
        
        
        // If none of the cases return then we recurse the left subtrees and compare them both
        boolean areLeftEqual = equalsHelper(treeOne.left, treeTwo.left);
        
        // Recurse right side of trees and compare
        boolean areRightEqual = equalsHelper(treeOne.right, treeTwo.right);
        
        
        // If they both return true, then we know that left subtrees for tree one and two are equal as well as the right
        return areLeftEqual && areRightEqual;
    }
        
        
    }