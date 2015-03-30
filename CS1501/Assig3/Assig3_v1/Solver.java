//Wentao Jiang, wej10@pitt.edu, 9394

import java.util.*;
import java.io.*;

public class Solver {

    Node start;
    int moves = 0;
    String method;

    public Solver(Board initial) {

        start = new Node(initial, 0, null);
        Scanner kbd = new Scanner(System.in);
        System.out.println("Manhattan or Hamming? (m/h)");
        method = kbd.next();
        try {
            if (!isSolvable()) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        ArrayList<Node> usedlist = new ArrayList<Node>();
        pq.add(start);
        usedlist.add(start);
        int count = 0;
        while (!pq.peek().board.isGoal()) {
            Node n = pq.poll();
            if (++count%1000==0) System.out.println(count);
            for (Board board : n.board.neighors()) {
                boolean flag = true;
                for (Node used : usedlist) {
                    if (used.board.equals(board)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    pq.add(new Node(board, n));
                    usedlist.add(new Node(board, n));
                }
            }
        }

        Node goal = pq.poll();
        moves = goal.moves;
        Iterable<Board> sol = solution(goal);
        for (Board b : sol) {
            System.out.println(b.toString());
        }
        //           print(goal.board);       
    }

    public boolean isSolvable() {
        return start.board.isSolvable();
    }

    public int moves() {
        return moves;
    }

    public Iterable<Board> solution(Node goal) {
        Stack<Board> soluS = new Stack<Board>();
        while (goal.pre != null) {
            soluS.add(goal.board);
            goal = goal.pre;
        }
        ArrayList<Board> solu = new ArrayList<Board>();
        while (!soluS.isEmpty()) {
            solu.add(soluS.pop());
        }
        return solu;
    }
    /*
     public void print(Board board){
     for (int row=0; row<board.dimension(); row++){
     for (int col=0; col<board.dimension(); col++){
     System.out.print(board.blocks[row][col]+ " ");
     }
     System.out.println();
     } 
     }
     public void printpath(Node node){
     print(node.board);
     System.out.println(node.board.manhattan());
     System.out.println();
     if (node.pre!=null) printpath(node.pre);
     }
     */

    class Node implements Comparable<Node> {

        Board board;
        int moves;
        Node pre;

        Node(Board b, int moves, Node pre) {
            this.board = b;
            this.moves = moves;
            this.pre = pre;
        }

        Node(Board b, Node pre) {
            this.board = b;
            this.pre = pre;
            this.moves = pre.moves + 1;
        }

        Node(Board b) {
            this.board = b;
            this.moves = 0;
            this.pre = null;
        }

        public int compareTo(Node other) {
            if (method.equals("m")) {
                if ((this.board.manhattan() + this.moves) > (other.board.manhattan() + other.moves)) {
                    return 1;
                } else if ((this.board.manhattan() + this.moves) < (other.board.manhattan() + other.moves)) {
                    return -1;
                } else {
                    return 0;
                }
            }
            else if (method.equals("h")){
                if ((this.board.hamming() + this.moves) > (other.board.hamming() + other.moves)) {
                    return 1;
                } else if ((this.board.hamming() + this.moves) < (other.board.hamming() + other.moves)) {
                    return -1;
                } else {
                    return 0;
                }              
            }
            else {
                if ((this.board.hamming() + this.board.manhattan() +this.moves) > (other.board.hamming() +other.board.manhattan()+ other.moves))
                    return 1;
                else if ((this.board.hamming() + this.board.manhattan() +this.moves) < (other.board.hamming() +other.board.manhattan()+ other.moves))
                    return -1;
                else
                    return 0;
            }
        }
    }
}
