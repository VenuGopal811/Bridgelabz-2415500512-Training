# Trees

Tree is a non-linear data structure which consists of nodes and edges.

A single node (in a binary tree) has three datas: 
1. Value
2. Left
3. Right

If there are *n* nodes, there will be *(n-1)* edges.

Edges are the connection between 2 nodes.

There is one and only one path between two vertices/nodes.

## Terminology

* **Parent Node** - Every node which has a child node is considered a parent node.
* **Child Node** - Nodes which have one parent node or are descendant from another node are called child nodes.
* **Sibling Nodes** - Nodes which have the same parent node are called sibling nodes.
* **Degree of a Node** - Number of children for a node is called degree of a node.
* **Degree of a tree** - Highest degree of a node in a tree is the degree of the tree itself.
* **Leaf node** - Nodes with zero children.
* **Internal Nodes** - Nodes with at least one child are called internal nodes. Also can be called Parent node.
* **Level** - Generations in a tree are called levels. (Start from 0 at root node).
* **Height of a node** - Number of edges between given node and leaf node. (if more than one, go with the highest number).
* **Height of a tree** - Height of root node.
* **Depth of a node** - Number of edges between root node and given node.
* **Depth of a tree** - Highest number of depth of a leaf.
* **Sub tree** - A sub-part of a tree is called a subtree.

## Types of Trees

1. **General tree** - Has no structure (a single node can have more than two children).
2. **Binary tree** - Each node can have at most 2 branches.
3. **Binary Search Tree (BST)** - Root node should be greater than left node but less than right node.
4. **AVL Tree** - Self-balancing binary search tree.

## Traversal

* **BFS** (Breadth-First Search)
* **DFS** (Depth-First Search):
    1. **Preorder (root, left, right)**: `25, 10, 5, 15, 13, 20, 35, 30, 40`
    2. **Inorder (left, root, right)**: `5, 10, 13, 15, 20, 25, 30, 35, 40`
    3. **Postorder (left, right, root)**: `5, 13, 20, 15, 10, 30, 40, 35, 25`