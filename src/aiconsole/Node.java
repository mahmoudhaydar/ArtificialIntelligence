/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiconsole;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class Node<T> {

    List<Node> path;
    double realCost = 0;
    double hvalue;
    T data;

    public Node() {
        this.path = new ArrayList<Node>();
    }

    ;
public Node(T data) {
        this.path = new ArrayList<Node>();
        this.data = data;
    }

    public Node(Node copy) {
        if(copy==null) return;
        this.path = new ArrayList<Node>();
        this.data = (T) copy.data;
        this.hvalue = copy.hvalue;
        this.realCost = copy.realCost;

        for (Object o : copy.path) {
            Node n = (Node) o;
            this.path.add(new Node(n));
        }

    }

    public String getPath() {
        String s = "";
        for (Node n : path) {
            s += n.data + " ";
        }
        return s;
    }
}
