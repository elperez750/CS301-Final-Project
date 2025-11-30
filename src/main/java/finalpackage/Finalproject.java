/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package finalpackage;

/**
 *
 * @author elper2
 */
public class Finalproject {

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 7, 9, 11, null, 15};
        BinaryTree<Integer> bt = new BinaryTree<>(arr);
        System.out.println(bt.toString());
        System.out.println(bt.isComplete());
        System.out.println(bt.contains(15));
        
        
        
    }
}
