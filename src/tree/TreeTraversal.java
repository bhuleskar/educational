/*-
 * This computer program is the confidential information and proprietary trade
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Sep 21, 2013
 */
package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TreeTraversal {
    int max=0;

    public static void main(String[] args){
        TreeTraversal tree = new TreeTraversal();
        Node root = tree.createNodes();
        //tree.performDFSStack(root);
        tree.bfs(root);
        //System.out.println( tree.maxSum(root));
        Set<String> invalidList = new HashSet<String>();

    }
    
    public void performDFSRecursive(Node node) {
        if (node == null) {
            return;
        }
        if (!node.isVisited) {
            System.out.println(node.getData());
            node.setVisited(true);
        }
        List<Node> lst = node.getChildren();
        for (int i = 0; i < lst.size(); i++) {
            performDFSRecursive(lst.get(i));
        }
    }
    
    public void performDFSStack(Node root) {
        Stack<Node> s = new Stack();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            if (!node.isVisited()) {
                System.out.println("Visited: " + node.getData());
                node.setVisited(true);
            }
            List<Node> children = node.getChildren();
            for (int i = children.size() - 1; i >= 0; i--) {
                s.push(children.get(i));
            }
        }
    }
    
    
    public void bfs(Node root){
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
           Node n = queue.remove();
           if (!n.isVisited()) {
           System.out.println("Visited" + n.getData());
           n.setVisited(true);
           }
           List<Node> children = n.getChildren();
           for (int i = 0; i< children.size(); i++) {
               queue.add(children.get(i));
           }
        }
    }
    
    public Node createNodes(){
        Node root = new Node(1);
        
        Node two= new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight= new Node(8);
        Node nine= new Node(9);
        Node ten= new Node(10);
        Node eleven= new Node(11);
        Node twelve= new Node(12);
        
        root.addChild(two);
        root.addChild(seven);
        root.addChild(eight);
        
       // seven.addChild(nine);
        two.addChild(three);
        two.addChild(six);
        
        three.addChild(four);
        three.addChild(five);
        
        eight.addChild(nine);
        eight.addChild(twelve);
        
        nine.addChild(ten);
        nine.addChild(eleven);
        
        return root;
    }
    
    public int maxSum(Node node){
        if(node ==null){
            return 0;
        }

        List<Node> lst = node.getChildren();
        if(lst.size() ==0){
            return node.getData();
        }
        int max=0;
        for (int i = 0; i < lst.size(); i++) {
            int currmax= node.getData() + maxSum(lst.get(i));
            if (currmax >max ){
                max = currmax;
            }
        }
        return max;
    }

}

class Node{
    private int data;
    List<Node> children = new ArrayList<Node>();
    boolean isVisited;
    
    public Node (int data){
        this.data= data;
    }
    
    public int getData(){
        return data;
    }
    
    public List<Node> getChildren(){
        return children;
    }
    
    public void addChild(Node node){
        children.add(node);
    }
    
    public void setVisited(boolean isVisited){
        this.isVisited = isVisited;
    }
    
    public boolean isVisited(){
        return isVisited;
    }
}