package aiconsole;

/**
 *
 * @author Mahmoud
 */
public class Astar {

    Tree tree;
    String start;
    String goal;

    public Astar() {
    }

    public Astar(Tree t, String Start, String Goal) {
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
        //
        return s;

    }

    
}
