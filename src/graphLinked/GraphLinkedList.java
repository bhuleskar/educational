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
 * Created on Oct 8, 2013
 */
package graphLinked;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
 



/**
 * This is more of Graph.java, except that am using a java Linked List instead of custom class Neighbor.
 *  *  Custom Array [] - > java LinkedList.
 *  ----       __________     ___________
 *  !   ! ->   !__!__!___! -> !__!__!___!
 *  ----
 *  
 * @author sridhar
 *
 */
//class Neighbor {
//    public int vertexNum;
//    public Neighbor next;
//    public Neighbor(int vnum, Neighbor nbr) {
//            this.vertexNum = vnum;
//            next = nbr;
//    }
//}
 
class Vertice {
    String name;
    LinkedList<Vertice> neighborList;
    boolean isVisited;
    Vertice(String name, LinkedList<Vertice> neighbors) {
            this.name = name;
            this.neighborList = neighbors;
    }
    public void setIsVisited(boolean isVisited){
        this.isVisited = isVisited;
    }
    
    public boolean getIsVisited(){
        return isVisited;
    }
}
 
/**
 * @author Sesh Venugopal. May 31, 2013.
 */
public class GraphLinkedList {
 
    Vertice[] adjLists;
    
    public GraphLinkedList(String file) throws FileNotFoundException {
         
        Scanner sc = new Scanner(new File(file));
         
        String graphType = sc.next();
        boolean undirected=true;
        if (graphType.equals("directed")) {
            undirected=false;
        }
         
        adjLists = new Vertice[sc.nextInt()];
 
        // read vertices
        for (int v=0; v < adjLists.length; v++) {
            adjLists[v] = new Vertice(sc.next(), null);
        }
 
        // read edges
        while (sc.hasNext()) {
             
            // read vertex names and translate to vertex numbers

            
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());
             
            //Because order doesn't matter, we are addding to the front of the list. This saves us traversing through linkedList.
            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            if(adjLists[v1].neighborList ==null){
            adjLists[v1].neighborList = new LinkedList<Vertice>();
            }
            adjLists[v1].neighborList.add(adjLists[v2]);

//            adjacencyLists.add(adjLists[v1].adjList);
            if (undirected) {
                if(adjLists[v2].neighborList ==null){
                    adjLists[v2].neighborList = new LinkedList<Vertice>();
                    }
                adjLists[v2].neighborList.add(adjLists[v1]);
            }
        }
    }
     
    int indexForName(String name) {
        for (int v=0; v < adjLists.length; v++) {
            if (adjLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }   
     
    public void print() {
        System.out.println();
        for (int v=0; v < adjLists.length; v++) {
            System.out.print(adjLists[v].name);
            for (int i=0; i< adjLists[v].neighborList.size();i++) {
                System.out.print(" --> " + adjLists[v].neighborList.get(i).name);
            }
            System.out.println("\n");
        }
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) 
    throws IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        GraphLinkedList graph = new GraphLinkedList(file);
        graph.print();
        graph.dfs();
        graph.bfs();
        
    }
    
    private void dfs(){
        System.out.print("Depth First Search: ");
        Stack<Vertice> s = new Stack<Vertice>();
        s.push(adjLists[0]);
        while(!s.isEmpty()){
            Vertice v= s.pop();
            if(!v.getIsVisited()){
               System.out.print(" " +v.name);
               v.setIsVisited(true);
            }
            for (int i=0; i< v.neighborList.size();i++) {
                if(!(v.neighborList.get(i)).getIsVisited()){
                s.push(v.neighborList.get(i));
                }
            }
        }
        
        for (int i=0; i< adjLists.length; i++){
            adjLists[i].setIsVisited(false);
        }
    }
    private void bfs(){
        System.out.print("\n");
        System.out.println("Breadth First Search: ");
        Queue<Vertice> q = new LinkedList<Vertice>();
        q.add(adjLists[0]);
        while(!q.isEmpty()){
            Vertice v= q.remove();
            if(!v.getIsVisited()){
               System.out.print(" " +v.name);
               v.setIsVisited(true);
            }
            for (int i=0; i< v.neighborList.size();i++) {
                if(!(v.neighborList.get(i)).getIsVisited()){
                q.add(v.neighborList.get(i));
                }
            }
        }
        
    }
 
}