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
public class Solution {
String methodeName="";
List<Node> path;
List<Node> expanded;
private double cost=0;
public Solution(){
path=new ArrayList<Node>();
expanded=new ArrayList<Node>();
};
public Solution(String method,List<Node> path, List<Node> exp,double cost)
{
    this.methodeName=method;
    this.path=path;
    this.expanded=exp;
    this.cost=cost;
}

}
