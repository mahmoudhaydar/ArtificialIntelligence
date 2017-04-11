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

    public Tree() {
        this.children = new ArrayList<Tree>();
    }

    public Tree(Tree copy){
        if(copy==null) return;
    this.children=new ArrayList<Tree>();
    this.root=new Node(copy.root);
    for(Object o:copy.children)
    {
        Tree t=(Tree)o;
        this.children.add(new Tree(t));
    }
    
    }
    public void print() {
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
        if (node.compareToIgnoreCase((String)root.data)==0) {
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
        if (name.compareToIgnoreCase((String)this.root.data)==0) {
            return this;
        }
        for (Tree t : this.children) {
            
            Tree r=t.getNode(name);
            if(r!=null) return r;

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
            cnode.realCost=cost;
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
            cnode.realCost=cost;
            c.root=cnode;
        }
        p.children.add(c);

    }

    
}