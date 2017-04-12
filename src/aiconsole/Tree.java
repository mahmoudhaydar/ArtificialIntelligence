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
 * @author Mahmoud
 */
public class Tree<T> {

    Node<T> root;
    List<Tree> children;
    boolean isHeursticsWasRead=false;

    public Tree() {
        this.children = new ArrayList<Tree>();
    }

    public void readTree() {

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Enter Nodes of the form: Node, Child1, Child2, ...");
        System.out.println("double enter to finish");
        do {
            String s = input.nextLine();
            if (s.isEmpty()) {
                break;
            }
            String[] nodes = s.split(",");
            String parent = nodes[0];
            for (int i = 1; i < nodes.length; i++) {
                this.add(nodes[i], parent, 1.0);
            }
        } while (true);

    }

    public void readHeuristics() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        if (this.isEmpty()) {
            System.out.println("Please read the tree beore reading heuristics");
            return;
        }

        List<Tree> fring = new ArrayList<>();
        fring.add(this);
        while (!fring.isEmpty()) {
            Tree currentNode = fring.remove(0);
            System.out.print("\n"+currentNode.root.data + ":");
            double h = input.nextDouble();
            currentNode.root.hvalue = h;
            for (int i = 0; i < currentNode.children.size(); i++) {
                fring.add((Tree)currentNode.children.get(i));
            }
        }
        this.isHeursticsWasRead=true;
    }
    public void readCosts()
    {
        java.util.Scanner input = new java.util.Scanner(System.in);
        if (this.isEmpty()) {
            System.out.println("Please read the tree beore reading costs");
            return;
        }

        List<Tree> fring = new ArrayList<>();
        fring.add(this);
        while (!fring.isEmpty()) {
            Tree currentNode = fring.remove(0);
            if(currentNode.isLeaf()) continue;
            for (int i = 0; i < currentNode.children.size(); i++) {
                Tree child=(Tree)currentNode.children.get(i);
                System.out.print("\n"+currentNode.root.data + "-->"+child.root.data+": ");
                double h = input.nextDouble();
                //to do
                fring.add(child);
            }
        }

    
    }

    public Tree(Tree copy) {
        if (copy == null) {
            return;
        }
        this.children = new ArrayList<Tree>();
        this.root = new Node(copy.root);
        for (Object o : copy.children) {
            Tree t = (Tree) o;
            this.children.add(new Tree(t));
        }

    }

    public void print() {
        if(isEmpty()) 
        {
            System.out.println("!! Empty Tree !!");
            return;
        }
        System.out.print(root.data + ":");
        for (Tree n : children) {
            System.out.print(" " + n.root.data);
        }
        System.out.println("");
        for (Tree n : children) {
            n.print();
        }

    }

    boolean contains(Node n) {
        if (root == null) {
            return false;
        }
        if (root.data == n.data) {
            return true;
        }
        for (Tree t : children) {
            if (t.contains(n)) {
                return true;
            }
        }
        return false;

    }

    boolean contains(String node) {
        if (root == null) {
            return false;
        }
        if (node.compareToIgnoreCase((String) root.data) == 0) {
            return true;
        }
        for (Tree t : children) {
            if (t.contains(node)) {
                return true;
            }
        }
        return false;

    }

    boolean isEmpty() {
        return root == null;
    }

    boolean isLeaf() {
        return children.isEmpty();
    }

    Tree getNode(String name) {
        if (name.compareToIgnoreCase((String) this.root.data) == 0) {
            return this;
        }
        for (Tree t : this.children) {

            Tree r = t.getNode(name);
            if (r != null) {
                return r;
            }

        }
        return null;
    }

    public void add(Node child) {
        Tree t = new Tree();
        t.root = child;
        this.children.add(t);

    }

    public void add(String child, String parent, double cost) {
        if (this.isEmpty()) {
            Node pnode = new Node();
            pnode.data = parent;
            pnode.realCost = 0;
            this.root = pnode;
            Tree c = new Tree<>();
            Node<String> cnode = new Node<>();
            cnode.data = child;
            cnode.realCost = cost;
            c.root = cnode;
            this.children.add(c);
            return;
        }
        Tree p;
        p = this.getNode(parent);
        Tree c;
        if (this.contains(child)) {
            c = this.getNode(child);
        } else {
            c = new Tree<>();
            Node<String> cnode = new Node<>();
            cnode.data = child;
            cnode.realCost = cost;
            c.root = cnode;
        }
        p.children.add(c);

    }

}
