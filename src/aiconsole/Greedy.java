package aiconsole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahmoud.haydar
 */
public class Greedy {

    Tree tree;
    String start;
    String goal;

    public Greedy() {
    }

    public Greedy(Tree t, String Start, String Goal) {
        tree = t;
        start = Start;
        goal = Goal;
    }

    public void setTree(Tree t) {
        this.tree = t;

    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Solution solve() {
        Solution s = new Solution();
        List<Tree> fring = new ArrayList<>();
        fring.add(new Tree(tree.getNode(start)));
        while (!fring.isEmpty()) {
            Tree currentNode = fring.remove(0);
            if (s.expanded.contains(currentNode.root)) {
                continue;
            }
            s.expanded.add(currentNode.root);
            if (goal.compareToIgnoreCase((String) currentNode.root.data) == 0) {
                break;
            }
            for (int i = 0; i < currentNode.children.size(); i++) {
                Tree t = (Tree) currentNode.children.get(i);
                t.root.path.addAll(currentNode.root.path);
                t.root.path.add(currentNode.root);
                int position=0;
                if(fring.isEmpty()) fring.add(new Tree(t));
                while(fring.get(position).root.hvalue<=t.root.hvalue)
                { 
                    position++;
                    if(position==fring.size()) break;
                }
                fring.add(position,new Tree(t));
            }
        }
        return s;

    }

}
