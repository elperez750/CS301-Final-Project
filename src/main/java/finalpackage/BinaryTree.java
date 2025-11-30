/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpackage;
import java.util.*;

/**
 *
 * @author elper2
 */
public class BinaryTree<T> {
  
        T value;
        BinaryTree<T> left;
        BinaryTree<T> right;
        
        
    // create empty constructor for creating the tree.    
    private BinaryTree() {}

        
    public BinaryTree(T[] values) {
        
        // Perform check to see if parent is null and has children.
        // If that is the case then the array is invalid and we do not create Binary tree.
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null && values[(i - 1) / 2] == null) {
                throw new IllegalArgumentException("Invalid array: child exists but parent is null");
            }
            
        }
        
        BinaryTree<T> root = BinaryTreeBuilder(values, 0);
        this.value = root.value;
        this.left = root.left;
        this.right = root.right;

        
    }
    
    
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
    

    
    // Level order traversal
    @Override
    public String toString() {
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(this);
        result.append("[");
        
        while (!queue.isEmpty()) {
            BinaryTree<T> currentNode = queue.remove();
            if (currentNode == null) {
                result.append("null, ");
            } else {
                result.append(currentNode.value).append(", ");
                queue.add(currentNode.left);   // Add even if null (for proper level-order)
                queue.add(currentNode.right); 
            }
        }
                
        result.append("]");
        
            
       
            return result.toString();
        }
    
    
    public boolean contains(T value) {
        return containsHelper(this, value);
        
    }
    
    
    private boolean containsHelper(BinaryTree<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        
        }
      
        boolean left = containsHelper(node.left, value);
        boolean right = containsHelper(node.right, value);
            
       
      
        
        return left || right;
    }
    
    
    public boolean isComplete() {
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);
        boolean seenNull = false;
        while(!queue.isEmpty()) {
            BinaryTree<T> currentNode = queue.remove();
            if (seenNull) {
                if (currentNode != null) {
                    return false;
                }
            }
            
            if (currentNode == null) {
                seenNull = true;
            }
            else {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
            
        }
        return true;
    }
        
        
    }
   
    

