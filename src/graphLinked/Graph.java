package graphLinked;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
 
/**
 *  This uses a custom link list kind of structure. More of class Node{ } kind.
 *  
 *  This is more of the representation
 *  
 * Custom Array [] - > Custom LinkedList.
 *  ----       __________     ___________
 *  !   ! ->   !__!__!___! -> !__!__!___!
 *  ----
 *  
 * @author sridhar
 *
 */

// This essentially is a LinkedList class
class Neighbor {
    public int vertexNum;
    public Neighbor next;
    public Neighbor(int vnum, Neighbor nbr) {
            this.vertexNum = vnum;
            next = nbr;
    }
}
 
class Vertex {
    String name;
    Neighbor neighborList;
    boolean isVisited;
    Vertex(String name, Neighbor neighbors) {
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
public class Graph {
 
    Vertex[] adjLists;
     
    public Graph(String file) throws FileNotFoundException {
         
        Scanner sc = new Scanner(new File(file));
         
        String graphType = sc.next();
        boolean undirected=true;
        if (graphType.equals("directed")) {
            undirected=false;
        }
         
        adjLists = new Vertex[sc.nextInt()];
 
        // read vertices
        for (int v=0; v < adjLists.length; v++) {
            adjLists[v] = new Vertex(sc.next(), null);
        }
 
        // read edges
        while (sc.hasNext()) {
             
            // read vertex names and translate to vertex numbers
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());
             
            //Because order doesn't matter, we are addding to the front of the list. This saves us traversing through linkedList.
            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].neighborList = new Neighbor(v2, adjLists[v1].neighborList);
            if (undirected) {
                adjLists[v2].neighborList = new Neighbor(v1, adjLists[v2].neighborList);
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
        for (int v = 0; v < adjLists.length; v++) {
            System.out.print(adjLists[v].name);
            Neighbor nbr = adjLists[v].neighborList;
            while (nbr != null) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name);
                nbr = nbr.next;
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
        Graph graph = new Graph(file);
        graph.print();
        graph.dfs();
 
    }

    private void dfs(){
        Stack<Vertex> s = new Stack<Vertex>();
        s.push(adjLists[0]);
        while(!s.isEmpty()){
            Vertex v= s.pop();
            if(!v.getIsVisited()){
               System.out.println(v.name);
               v.setIsVisited(true);

            }
            for (Neighbor nbr=v.neighborList; nbr != null;nbr=nbr.next) {
                if(!(adjLists[nbr.vertexNum]).getIsVisited()){
                s.push(adjLists[nbr.vertexNum]);
                }
            }
        }
    }
 
}