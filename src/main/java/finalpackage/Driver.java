/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package finalpackage;

/**
 *
 * @author elper2
 * Time taken to complete: 12 hours
 * Used AI to generate Javadoc comments and help with test cases. Coding implementation of binary tree is my own work.
 */
public class Driver {

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 7, 9, 11, null, 15};
        BinaryTree<Integer> bt = new BinaryTree<>(arr);
        System.out.println(bt.toString());
        System.out.println(bt.isComplete());
        System.out.println(bt.contains(15));
        // Balanced trees
        Integer[] balanced1 = {1, 2, 3, 4, 5, 6, 7}; // Perfect tree, height 2
        Integer[] balanced2 = {1, 2, 3, 4, 5, 6, null}; // Left-leaning but balanced
        Integer[] balanced3 = {1, 2, 3, null, null, 6, 7}; // Right-leaning but balanced
        Integer[] balanced4 = {10}; // Single node
        Integer[] balanced5 = {5, 3, 8}; // Just root with two children

        // Unbalanced trees
        Integer[] unbalanced1 = {1, 2, 3, 4, 5, null, null, 6}; // Left subtree height differs by more than 1
        Integer[] unbalanced2 = {1, 2, null, 3, null, null, null, 4}; // Essentially a linked list on the left
        Integer[] unbalanced3 = {1, 2, 3, 4, null, null, null, 5}; // Deep left branch
        Integer[] unbalanced4 = {10, 5, 15, null, 7, null, null, null, null, 6, 8}; // Right child of 5 is deeper

        // Edge cases
        Integer[] empty = {}; // Empty tree (should be balanced)
        Integer[] justNull = {null}; // Just null (depends on your implementation)
        BinaryTree<Integer> tstbt = new BinaryTree<>(unbalanced4);
        BinaryTree<Integer> treeToCompare = new BinaryTree<>(unbalanced2);
        BinaryTree<Integer> equalTree = new BinaryTree<>(unbalanced4);
        
        System.out.println("Tree: " + tstbt.toString());
        System.out.println("Is balanced: " + tstbt.isBalanced());
        System.out.println("Height of tree " + tstbt.height());
        System.out.println("Are trees equal? " + tstbt.equals(equalTree));
        System.out.println("Are trees equal? " + tstbt.equals(treeToCompare));
        System.out.println();
        
        
        
        
        
        
       
        
        
        
    }
}
