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
    
    public static void main(String[] args) {
        Tree t=new Tree();
        t.readTree();
        t.readHeuristics();
        t.readCosts();
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
