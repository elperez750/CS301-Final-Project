/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package finalpackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elper2
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of toString method, of class BinaryTree.
     */

   @Test
public void testToString() {
    System.out.println("toString");
    
    // Test 1: Normal balanced tree
    Integer[] testTree = {1, 2, 3, 4, 5, 6, 7, 8};
    BinaryTree<Integer> instance = new BinaryTree<>(testTree);
    String expResult = "[1, 2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, null, null, null, null]";
    assertEquals(expResult, instance.toString());
        
    // Test 2: Single node tree
    Integer[] singleNode = {1};
    BinaryTree<Integer> single = new BinaryTree<>(singleNode);
    assertEquals("[1, null, null]", single.toString());
    
    // Test 3: Tree with nulls (incomplete tree)
    Integer[] withNulls = {1, 2, null, 4};
    BinaryTree<Integer> sparseTree = new BinaryTree<>(withNulls);
    assertEquals("[1, 2, null, 4, null, null, null]", sparseTree.toString());
}

    /**
     * Test of contains method, of class BinaryTree.
     */
    @Test
public void testContains() {
    System.out.println("contains");
    
    // Test 1: Value exists in tree
    Integer[] arr = {1, 2, 3, 4, 5};
    BinaryTree<Integer> instance = new BinaryTree<>(arr);
    assertTrue(instance.contains(5));
    
    // Test 2: Value does not exist in tree
    assertFalse(instance.contains(10));
    
    // Test 3: Root value
    assertTrue(instance.contains(1));
    
    // Test 4: Leaf value
    assertTrue(instance.contains(4));
    
    // Test 5: Value in middle of tree
    assertTrue(instance.contains(2));
    
    // Test 6: Single node tree - value exists
    Integer[] singleNode = {7};
    BinaryTree<Integer> single = new BinaryTree<>(singleNode);
    assertTrue(single.contains(7));
    
    // Test 7: Single node tree - value doesn't exist
    assertFalse(single.contains(99));
    
    // Test 8: Empty tree
    Integer[] empty = {};
    BinaryTree<Integer> emptyTree = new BinaryTree<>(empty);
    assertFalse(emptyTree.contains(1));
    
    // Test 9: Tree with nulls - search for existing value
    Integer[] withNulls = {1, 2, null, 4};
    BinaryTree<Integer> sparseTree = new BinaryTree<>(withNulls);
    assertTrue(sparseTree.contains(4));
    
    // Test 10: Tree with nulls - search for non-existing value
    assertFalse(sparseTree.contains(3));
    
    // Test 11: Search for null (if your implementation allows it)
    assertFalse(sparseTree.contains(null));
    
    
    
    // Test 11: Test with string binary tree
    String[] strArr = {"Hello", "World", "This", "Nice"};
    BinaryTree<String> stringTree = new BinaryTree<>(strArr);
    assertTrue(stringTree.contains("Hello"));
    
}

    /**
     * Test of isBalanced method, of class BinaryTree.
     */
   @Test
public void testIsBalanced() {
    System.out.println("isBalanced");
    
    // Test 1: Perfectly balanced tree
    Integer[] balanced = {1, 2, 3, 4, 5, 6, 7};
    BinaryTree<Integer> instance = new BinaryTree<>(balanced);
    assertTrue(instance.isBalanced());
    
    // Test 2: Single node tree (balanced)
    Integer[] singleNode = {1};
    BinaryTree<Integer> single = new BinaryTree<>(singleNode);
    assertTrue(single.isBalanced());
    
    // Test 3: Empty tree (balanced)
    Integer[] empty = {};
    BinaryTree<Integer> emptyTree = new BinaryTree<>(empty);
    assertTrue(emptyTree.isBalanced());
    
    // Test 4: Unbalanced tree (left-heavy)
    Integer[] leftHeavy = {1, 2, null, 4, 5};
    BinaryTree<Integer> unbalanced = new BinaryTree<>(leftHeavy);
    assertFalse(unbalanced.isBalanced());
    
    // Test 5: Tree with height difference of 1 (still balanced)
    Integer[] slightDiff = {1, 2, 3, 4, 5, 6};
    BinaryTree<Integer> balanced2 = new BinaryTree<>(slightDiff);
    assertTrue(balanced2.isBalanced());
    
    // Test 6: Two nodes (balanced)
    Integer[] twoNodes = {1, 2};
    BinaryTree<Integer> twoNode = new BinaryTree<>(twoNodes);
    assertTrue(twoNode.isBalanced());
    
    // Test 7: Three nodes (balanced)
    Integer[] threeNodes = {1, 2, 3};
    BinaryTree<Integer> threeNode = new BinaryTree<>(threeNodes);
    assertTrue(threeNode.isBalanced());
}



    @Test
public void testHeight() {
    System.out.println("height");
    
    // Test 1: Single node tree (height = 0)
    Integer[] singleNode = {1};
    BinaryTree<Integer> single = new BinaryTree<>(singleNode);
    assertEquals(0, single.height());
    
    // Test 2: Empty tree 
    Integer[] empty = {};
    BinaryTree<Integer> emptyTree = new BinaryTree<>(empty);
    assertEquals(-1, emptyTree.height()); 
    
    // Test 3: Two levels (height = 1)
    Integer[] twoLevels = {1, 2, 3};
    BinaryTree<Integer> twoLevel = new BinaryTree<>(twoLevels);
    assertEquals(1, twoLevel.height());
    
    // Test 4: Three levels (height = 2)
    Integer[] threeLevels = {1, 2, 3, 4, 5, 6, 7};
    BinaryTree<Integer> threeLevel = new BinaryTree<>(threeLevels);
    assertEquals(2, threeLevel.height());
    
    // Test 5: Four levels (height = 3)
    Integer[] fourLevels = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    BinaryTree<Integer> fourLevel = new BinaryTree<>(fourLevels);
    assertEquals(3, fourLevel.height());
    
    // Test 6: Unbalanced tree (left deeper)
    Integer[] leftDeep = {1, 2, null, 4, null, null, null, 8};
    BinaryTree<Integer> leftHeavy = new BinaryTree<>(leftDeep);
    assertEquals(3, leftHeavy.height());
    
    // Test 7: Two nodes (height = 1)
    Integer[] twoNodes = {1, 2};
    BinaryTree<Integer> twoNode = new BinaryTree<>(twoNodes);
    assertEquals(1, twoNode.height());
}

  
   @Test
public void testIsComplete() {
    System.out.println("isComplete");
    
    // Test 1: Perfect tree (is complete)
    Integer[] perfect = {1, 2, 3, 4, 5, 6, 7};
    BinaryTree<Integer> perfectTree = new BinaryTree<>(perfect);
    assertTrue(perfectTree.isComplete());
    
    // Test 2: Complete tree (all levels full except last, filled left to right)
    Integer[] complete = {1, 2, 3, 4, 5, 6};
    BinaryTree<Integer> completeTree = new BinaryTree<>(complete);
    assertTrue(completeTree.isComplete());
    
    // Test 3: Incomplete tree (has gap in last level)
    Integer[] incomplete = {1, 2, 3, 4, null, 6};
    BinaryTree<Integer> incompleteTree = new BinaryTree<>(incomplete);
    assertFalse(incompleteTree.isComplete());
    
    // Test 4: Single node (is complete)
    Integer[] singleNode = {1};
    BinaryTree<Integer> single = new BinaryTree<>(singleNode);
    assertTrue(single.isComplete());
    
    // Test 5: Empty tree (is complete)
    Integer[] empty = {};
    BinaryTree<Integer> emptyTree = new BinaryTree<>(empty);
    assertTrue(emptyTree.isComplete());
    
    // Test 6: Two nodes (is complete)
    Integer[] twoNodes = {1, 2};
    BinaryTree<Integer> twoNode = new BinaryTree<>(twoNodes);
    assertTrue(twoNode.isComplete());
    
    // Test 7: Incomplete - right child without left
    Integer[] rightOnly = {1, null, 3};
    BinaryTree<Integer> rightOnlyTree = new BinaryTree<>(rightOnly);
    assertFalse(rightOnlyTree.isComplete());
}

@Test
public void testEquals() {
    System.out.println("Equals");
    
    // Test 1: Identical trees (your original test)
    Integer[] arr1 = {1, 2, 3, 4, 5};
    Integer[] arr2 = {1, 2, 3, 4, 5};
    BinaryTree<Integer> treeOne = new BinaryTree<>(arr1);
    BinaryTree<Integer> treeTwo = new BinaryTree<>(arr2);
    assertTrue(treeOne.equals(treeTwo));
    
    // Test 2: Different values
    Integer[] arr3 = {1, 2, 3, 4, 6}; // 6 instead of 5
    BinaryTree<Integer> treeDifferent = new BinaryTree<>(arr3);
    assertFalse(treeOne.equals(treeDifferent));
    
    // Test 3: Different structure
    Integer[] arr4 = {1, 2, 3};
    BinaryTree<Integer> treeShorter = new BinaryTree<>(arr4);
    assertFalse(treeOne.equals(treeShorter));
    
    // Test 4: Both empty trees
    Integer[] empty1 = {};
    Integer[] empty2 = {};
    BinaryTree<Integer> emptyOne = new BinaryTree<>(empty1);
    BinaryTree<Integer> emptyTwo = new BinaryTree<>(empty2);
    assertTrue(emptyOne.equals(emptyTwo));
    
    // Test 5: One empty, one not
    assertFalse(emptyOne.equals(treeOne));
    
    // Test 6: Same tree compared to itself
    assertTrue(treeOne.equals(treeOne));
    
    // Test 7: Trees with nulls in same positions
    Integer[] withNulls1 = {1, 2, null, 4};
    Integer[] withNulls2 = {1, 2, null, 4};
    BinaryTree<Integer> nullTree1 = new BinaryTree<>(withNulls1);
    BinaryTree<Integer> nullTree2 = new BinaryTree<>(withNulls2);
    assertTrue(nullTree1.equals(nullTree2));
    
    
    // Test 7: Trees with strings
    String[] strArr1 = {"Hello", "There", "Peasant", "Knight"};
    String[] strArr2 = {"Hello", "There", "Peasant", "Knight"};
    
    
    BinaryTree<String> strTreeOne = new BinaryTree<>(strArr1);
    BinaryTree<String> strTreeTwo = new BinaryTree<>(strArr2);
    
    assertTrue(strTreeTwo.equals(strTreeOne));
    
    
}
    
}
