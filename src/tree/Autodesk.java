package tree;

import java.util.ArrayList;
import java.util.Iterator;


public class Autodesk {
    
    private Node1 root;
    

    public int partsCount(String name){
        return df(root, name);
    }
    
    private int df(Node1 s, String name){
        if(s.hasName(name)){
            return s.getVal();
        }
        ArrayList childs = s.getChilds();
        int sum = 0;
        if(childs != null && childs.size() > 0){
            
            for (int j = 0; j < childs.size(); j++) {
                Node1 n = (Node1)childs.get(j);
                int tmp = df(n, name);
                if(tmp > 0 ){
                    if(s.getVal() > 0 ){
                        tmp *= s.getVal();
                    }
                    sum += tmp;
                }
            }
            
        }
        return sum;
    }
    
    public void whereUsed(String name){
        ArrayList<String> op = new ArrayList<String>();
        dfwhere(root, name, op);
        for (String string : op) {
            System.out.println(string);
        }
    }
    
    private boolean dfwhere(Node1 n, String name, ArrayList<String> op){
        if(n.hasName(name)){
            return true;
        }
        ArrayList childs = n.getChilds();
        if(childs != null && childs.size() > 0){
            for (int j = 0; j < childs.size(); j++) {
                Node1 ch = (Node1)childs.get(j);
                if(dfwhere(ch, name, op)){
                    op.add(n.name);
                }
            }
        }
        return false;
    }
    
    public void createSample(){
        root = new Node1("CAR", -1);
        
        Node1 chase = new Node1("Chase", 2);
        Node1 engine = new Node1("Engine", 1);
        Node1 body = new Node1("Body", 1);
        
        Node1 wheel = new Node1("Wheel", 4);
        Node1 rim = new Node1("Rim", 1);
        Node1 tire = new Node1("Tire", 1);
        Node1 bolt = new Node1("Bolt", 5);
        
        Node1 bolt1 = new Node1("Bolt", 3);
        
        Node1 bolt3 = new Node1("Bolt", 6);
        root.addChild(chase);
        root.addChild(engine);
        root.addChild(body);
        
        chase.addChild(wheel);
        
        wheel.addChild(rim);
        wheel.addChild(tire);
        wheel.addChild(bolt);
        body.addChild(bolt3);
        engine.addChild(bolt1);
       
    }
    
    public static void main(String[] args) {
        Autodesk ad = new Autodesk();
        ad.createSample();
        int o = ad.partsCount("bolt");
        System.out.println(o);
        ad.whereUsed("Engine");
    }
    
    
    class Node1 {
        String name;
        
        ArrayList childs = new ArrayList();
        
        int val = -1;
        
        Node1(String name, int val){
            this.name = name;
            this.val = val;
        }
        
        public void addChild(Node1 n){
            childs.add(n);
        }
        public boolean hasName(String name){
            if(this.name != null & this.name.equalsIgnoreCase(name)){
                return true;
            }
            return false;
        }
        
        public int getVal(){
            return val;
        }
        
        public ArrayList getChilds(){
            return childs;
        }
        /*
        public boolean hasChild(String name){
            for (int i = 0; i < childs.size(); i++) {
                
            }
            return false;
        }
        */
        
    }
}

