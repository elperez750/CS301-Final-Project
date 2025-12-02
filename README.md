# CS 301 Data Structures Final Project
## Recursive Binary Tree Implementation

### Project Overview
This project implements a generic recursive binary tree class in Java without using a traditional Node class. The tree supports various recursive operations and demonstrates advanced concepts in generic programming, recursion, and unit testing.

### Project Structure
```
finalproject/
├── src/
│   └── finalpackage/
│       ├── Driver.java
│       ├── BinaryTree.java
│       └── BinaryTreeTest.java
└── pom.xml
```

### Features

#### BinaryTree<T> Class
A generic recursive binary tree implementation with the following capabilities:

- **Constructor**: `BinaryTree(T[] values)`
  - Builds tree from level-order array representation
  - Handles `null` values as non-existent nodes
  - Validates arrays and rejects invalid structures (children without parents)

- **Core Methods**:
  - `boolean equals(Object obj)` - Compares trees by structure and values
  - `String toString()` - Returns level-order traversal representation
  - `int height()` - Computes tree height (empty tree = -1)
  - `boolean contains(T value)` - Searches for value recursively
  - `boolean isComplete()` - Checks if tree is complete
  - `boolean isBalanced()` - Verifies tree balance (height difference ≤ 1)

### Design Principles

- **Recursive Structure**: The class defines itself in terms of smaller versions of itself
- **Generic Programming**: Supports any data type through Java generics
- **No Node Class**: Tree structure built directly into the BinaryTree class
- **Level-Order Construction**: Trees built from array representation

### Array Representation

Trees are constructed from arrays where:
- Index `i` has left child at `2*i + 1`
- Index `i` has right child at `2*i + 2`
- `null` values represent missing nodes

**Example**:
```java
Integer[] arr = {1, 2, 3, null, 4, 5, 6};
// Creates:
//       1
//      / \
//     2   3
//      \ / \
//      4 5  6
```

### Testing

Comprehensive JUnit 5 tests included for:
- All public methods
- Both `Integer` and `String` data types
- Edge cases (invalid arrays, null values, empty trees)

### Requirements

- Java 8 or higher
- Maven
- JUnit 5
- NetBeans IDE (recommended)

### Building and Running
```bash
# Build the project
mvn clean compile

# Run tests
mvn test

# Run the driver
mvn exec:java -Dexec.mainClass="finalpackage.Driver"
```

### Grading Breakdown

| Component | Weight |
|-----------|--------|
| Project Structure | 5% |
| BinaryTree Implementation | 80% |
| JUnit Testing | 10% |
| Code Quality & Documentation | 5% |

### Implementation Notes

- **Complete Tree**: All levels filled except possibly the last, with nodes as far left as possible
- **Balanced Tree**: Height difference between left and right subtrees ≤ 1 at every node
- **Empty Tree Height**: Defined as -1
- **Invalid Arrays**: Rejected when child exists but parent is null

### Author
Sway - CS 301 Data Structures, Central Washington University

### License
Educational project for CS 301 coursework
