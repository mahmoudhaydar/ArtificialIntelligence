/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiconsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mahmoud.haydar
 */
public class DFS {
 Tree tree;
 String start;
 String goal;
 
 public DFS()
 {
 }
 public DFS(Tree t,String Start,String Goal)
 {
     tree=t;
     start=Start;
     goal=Goal;
 }
 
 public void setTree(Tree t)
 {
     this.tree=t;     
 
 }
 public void setGoal(String goal)
 {
     this.goal=goal;
 }
 public void setStart(String start)
 {
     this.start=start;
 }
 public Solution solve(){
  Solution s = new Solution();
        Stack<Tree> fring = new Stack();
        fring.push(new Tree(tree.getNode(start)));
        while (!fring.isEmpty()) {
            Tree currentNode = fring.pop();
            if(s.expanded.contains(currentNode.root)) continue;
            s.expanded.add(currentNode.root);
            if(goal.compareToIgnoreCase((String)currentNode.root.data)==0)break;
            for (int i = 0; i < currentNode.children.size(); i++) {
            Tree t = (Tree) (currentNode.children.get(i));
                t.root.path.addAll(currentNode.root.path);
                t.root.path.add(currentNode.root);
                fring.push(new Tree(t));
            }
        }
        return s;
 
 }
    
}
