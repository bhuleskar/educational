/*-
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Sep 4, 2013
 */
package tree.bst.tree;

public class Tree {

    Node root = null;
    int sum = 0;

    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.insert(tree.getRoot(), 15);
        tree.insert(tree.getRoot(), 12);
        tree.insert(tree.getRoot(), 18);
        tree.insert(tree.getRoot(), 10);
        tree.insert(tree.getRoot(), 13);
        tree.insert(tree.getRoot(), 14);
        tree.insert(tree.getRoot(), 17);
        tree.insert(tree.getRoot(), 19);
        tree.insert(tree.getRoot(), 23);
        tree.insert(tree.getRoot(), 9);
        tree.insert(tree.getRoot(), 11);

        tree.inOrderTraversal(tree.getRoot());
//        System.out.println("Number of Nodes: " + tree.size(tree.getRoot()));
       //System.out.println("Max Depth: " + tree.maxDepth(tree.getRoot()));
       System.out.println("Is Tree Balanced: " + tree.isTreeBalanced(tree.getRoot()));
    //   System.out.println("IS BST" + tree.isBST2(tree.getRoot(),Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println("Printing leaf nodes..");
//        tree.printLeafNode(tree.getRoot());

//        tree.doubleTree(tree.getRoot());
      //  tree.inOrderTraversal(tree.getRoot());
       // System.out.println("Sum: " + tree.sum(tree.getRoot()));
    }

    private Node getRoot() {
        return root;
    }

    private void insert(Node node, int data) {

        if (root == null) {
            Node newNode = new Node(data);
            root = newNode;
            return;
        }
        if (data < node.data) {
            if (node.leftPtr == null) {
                Node n = new Node(data);
                node.leftPtr = n;
            } else {
                insert(node.leftPtr, data);
            }
        } else {
            if (node.rightPtr == null) {
                Node n = new Node(data);
                node.rightPtr = n;
            } else {
                insert(node.rightPtr, data);
            }
        }

    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.leftPtr) + 1 + size(node.rightPtr);
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int lDepth = maxDepth(node.leftPtr);
        int rDepth = maxDepth(node.rightPtr);
        // use the larger + 1
        return (Math.max(lDepth, rDepth) + 1);
    }
    
    public boolean isTreeBalanced(Node node){
        if (node == null) {
            return true;
        }
        int lDepth = maxDepth(node.leftPtr);
        int rDepth = maxDepth(node.rightPtr);
        // use the larger + 1
        
        if(Math.abs(lDepth - rDepth) >1){
            return false;
        }
        return isTreeBalanced(node.leftPtr) && isTreeBalanced(node.rightPtr);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftPtr);
        System.out.println(node.data + "  " + '\t');
        inOrderTraversal(node.rightPtr);

    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + "  " + "\t");
        inOrderTraversal(node.leftPtr);
        inOrderTraversal(node.rightPtr);
    }

    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftPtr);
        inOrderTraversal(node.rightPtr);
        System.out.println(node.data + "  " + '\t');
    }

    public void printLeafNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.leftPtr == null && node.rightPtr == null) {
            System.out.println(node.data);
        } else {
            printLeafNode(node.leftPtr);
            printLeafNode(node.rightPtr);
        }
    }
    
    public void doubleTree(Node node){
        if (node == null) {
            return;
        }
        
        doubleTree(node.leftPtr);
        doubleTree(node.rightPtr);
        
        Node left = new Node(node.data);
        Node templeft = node.leftPtr;
        node.leftPtr = left;
        left.leftPtr = templeft;
        
    }
    
    /*
     * Amazon interview question
     */
    public int sumOneSibling(Node node){
        if (node == null) {
            return 0;
        }
        
        if(node.leftPtr!=null && node.rightPtr == null){
            sum+= node.leftPtr.data;
        }
        if(node.rightPtr!=null && node.leftPtr == null){
            sum+= node.rightPtr.data;
        }
        sumOneSibling(node.leftPtr);
        sumOneSibling(node.rightPtr);
        return sum; 
    }
    
    public Node findLca(Node node, int t1, int t2) {
        if(node == null) {
            return null;
        }
        if(node.data > t2 && node.data > t1) {
            // both targets are left
            return findLca(node.leftPtr, t1, t2);
        } else if (node.data < t2 && node.data < t1) {
            // both targets are right
            return findLca(node.rightPtr, t1, t2);
        } else {
            // either we are diverging or both targets are equal
            // in both cases so we've found the LCA
            // check for actual existence of targets here, if you like
            return node;
        }
    }
    
    private boolean isBST2(Node node, int min, int max) {
        if(node == null)
            return true;
        if(node.data <= min || node.data > max)
            return false;
        if(!isBST2(node.leftPtr, min, node.data) || !isBST2(node.rightPtr, node.data, max))
            return false;

        return true;
        
    }
}
    class Node {
        int data;
        Node leftPtr;
        Node rightPtr;

        public Node(int data) {
            this.data = data;
            leftPtr = null;
            rightPtr = null;
        }

        public Node getLeft() {
            return leftPtr;
        }

        public Node getRight() {
            return rightPtr;
        }
    }

