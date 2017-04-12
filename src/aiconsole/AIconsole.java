package aiconsole;

import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class AIconsole {

    public static int Menu() {
        int choice = 0;
        do {
            System.out.println("Solving Problem by Search");
            System.out.println("=========================");
            System.out.println("Enter your choice:");
            System.out.println("1- Read tree");
            System.out.println("2- BFS algo");
            System.out.println("3- DFS algo");
            System.out.println("4- Uniorm Cost");
            System.out.println("5- Greedy");
            System.out.println("6- A*");
            System.out.println("7- Print tree");
            System.out.println("=========================");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
        } while (choice < 1 || choice > 7);
        return choice;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree t = new Tree();
        String start = "s";
        String goal = "g";
        while (true) {
            int choice = Menu();
            switch (choice) {
                case 1: {
                    t = new Tree();
                    t.readTree();

                    System.out.println("Start from:");
                    Scanner input = new Scanner(System.in);
                    start = input.next();
                    System.out.println("Goal:");
                    goal = input.next();
                    break;
                }
                case 2: {
                    System.out.println("\tSolving using BFS");
                    if (t.isEmpty()) {
                        System.out.println("!\t!!!Please read tree beore solving!!!");
                        break;
                    }
                    BFS bfs = new BFS(t, start, goal);
                    Solution s = bfs.solve();
                    for (Node n : s.expanded) {
                        System.out.println(" " + n.data + " by " + n.getPath());
                    }
                    break;
                }
                case 3: {
                    System.out.println("\tSolving using DFS");
                    if (t.isEmpty()) {
                        System.out.println("!\t!!!Please read tree beore solving!!!");
                        break;
                    }
                    DFS dfs = new DFS(t, start, goal);
                    Solution s = dfs.solve();
                    for (Node n : s.expanded) {
                        System.out.println(" " + n.data + " by " + n.getPath());
                    }
                    break;
                }
                case 4: {
                    System.out.println("\tSolving using UC");
                    if (t.isEmpty()) {
                        System.out.println("!\t!!!Please read tree beore solving!!!");
                        break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("\tSolving using Greedy");
                    if (t.isEmpty()) {
                        System.out.println("!\t!!!Please read tree beore solving!!!");
                        break;
                    }
                    if (!t.isHeursticsWasRead) {
                        System.out.println("\t\tReading heuristics:");
                        t.readHeuristics();
                    }
                    Greedy greedy = new Greedy(t, start, goal);
                    Solution s = greedy.solve();
                    for (Node n : s.expanded) {
                        System.out.println(" " + n.data + " by " + n.getPath());
                    }
                    break;
                }
                case 6: {
                    System.out.println("\tSolving using A*");
                    if (t.isEmpty()) {
                        System.out.println("!\t!!!Please read tree beore solving!!!");
                        break;
                    }
                    break;
                }
                case 7: {
                    System.out.println("Printing the tree");
                    t.print();

                }
            }
        }
    }
}
