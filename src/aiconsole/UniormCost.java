package aiconsole;
import java.util.ArrayList;
import java.util.List;
public class UniormCost {

    Tree tree;
    String start;
    String goal;

    public UniormCost() {
    }

    public UniormCost(Tree t, String Start, String Goal) {
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
