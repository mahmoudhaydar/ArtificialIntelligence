/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiconsole;

import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class AIconsole {

    /**
     * @param args the command line arguments
     */
    
    public static Tree<String> readTree(){
    Tree<String> t=new Tree<String>();
    java.util.Scanner input=new java.util.Scanner(System.in);
        System.out.println("Enter Nodes of the form: Node, Child1, Child2, ...");
        System.out.println("double enter to finish");
        do{
        String s=input.nextLine();
        if(s.isEmpty()) break;
        String[] nodes=s.split(",");
        String parent=nodes[0];
            for (int i = 1; i < nodes.length; i++) {
                t.add(nodes[i],parent,1.0);
            }
        }while(true);
        System.out.println("Enter Nodes heuristics values of the form: Node hvalue");
        System.out.println("enter \"Stop\" to finish (defaul hvalue=0)");
         do{
        String s=input.next();
        double h=input.nextDouble();
        if(s.compareToIgnoreCase("stop")==0) break;
        t.getNode(s).root.hvalue=h;
        }while(true);
        
        
        
    return  t;
    }  
    public static void main(String[] args) {
      Tree t=readTree();
        System.out.println("Start from:");
        Scanner input=new Scanner(System.in);
        String start=input.next();
        System.out.println("Goal:");
        String goal=input.next();
      //  t.print();
      
        System.out.println("====== BFS ======");
        BFS bfs=new BFS(t,start,goal);
        
       Solution s=bfs.solve();
       for(Node n:s.expanded)
       {
           System.out.println(" "+n.data+" by "+n.getPath());
       }
       System.out.println("====== BFS ======");
       DFS dfs=new DFS(t,start,goal);
       s=dfs.solve();
       for(Node n:s.expanded)
       {
           System.out.println(" "+n.data+" by "+n.getPath());
       }
       System.out.println("====== Greedy ======");
       Greedy greedy=new Greedy(t,start,goal);
       s=greedy.solve();
       for(Node n:s.expanded)
       {
           System.out.println(" "+n.data+" by "+n.getPath());
       }
       
    }
    
}
