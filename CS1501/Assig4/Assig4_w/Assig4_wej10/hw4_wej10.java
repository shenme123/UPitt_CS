import java.io.*;
import java.util.*;

public class hw4_wej10 {

    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.err.println("Usage:java ChangeableGraph input_file");
            System.exit(1);
        }
		In in = new In(args[0]);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
		boolean flag = true;
		while (flag) {
			System.out.println("1. R (eport)\n2. M (inimum Spanning Tree)\n3. S (hortest Path from) i j\n4. D (own edge) i j\n5. U (p edge) i j\n6. C (hange weight of edge) i j x\n7. E (ulerian)\n8. Q (uit)\n");
			System.out.print("Enter your choice: ");
            Integer opt = StdIn.readInt();
            if (opt == 1)
            {
                System.out.println(G);
                CC cc = new CC(G);
                int M = cc.count();
                Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
                for (int i = 0; i < M; i++) {
                    components[i] = new Queue<Integer>();
                }
                for (int v = 0; v < G.V(); v++) {
                    components[cc.id(v)].enqueue(v);
                }
                if (M == 1) {
                    System.out.println("Network is connected");
                    System.out.println("Connected components");
                    for (int i = 0; i < M; i++) {
                        System.out.print(" " + (i + 1) + ".  ");
                        for (int v : components[i]) {
                            StdOut.print(v + " ");
                        }
                        StdOut.println("\n");
                    }
                } else if (M > 1) {
                    System.out.println("Network is not connected");
                    System.out.println("Connected components");
                    for (int i = 0; i < M; i++) {
                        System.out.print((i + 1) + ".  ");
                        for (int v : components[i]) {
                            StdOut.print(v + " ");
                        }
                        StdOut.println();
                    }
                    System.out.println();
                }
            }
            else if (opt == 2)
            {
                System.out.println("Minimum Spanning Tree");
                KruskalMST mst = new KruskalMST(G);
                for (DirectedEdge e : mst.edges()) {
                    StdOut.println(e);
                }
                StdOut.printf("%.5f\n", mst.weight());
                System.out.println();
            }
            else if (opt == 3)
            {
                System.out.print("Enter from vertex: ");
                Integer s = StdIn.readInt();
                System.out.print("Enter to vertex: ");
                Integer t = StdIn.readInt();
                System.out.println("Shortest Path from vertex " + s + " to vertex " + t + " is:");
                DijkstraSP sp = new DijkstraSP(G, s);
                if (sp.hasPathTo(t)) {
                    StdOut.printf("(%.2f)  ", sp.distTo(t));
                    for (DirectedEdge e : sp.pathTo(t)) {
                        StdOut.print(e.tostring() + "   ");
                    }
                    System.out.println("\n");
                } else {
                    StdOut.printf("No path\n");
                    System.out.println();
                }
            }
            else if (opt == 4)
            {
                System.out.print("Enter from vertex: ");
                Integer from = StdIn.readInt();
                System.out.print("Enter to vertex: ");
                Integer to = StdIn.readInt();
                G.down(from, to);
                G.down(to, from);
                System.out.println("Remove edge " + from + "->" + to);
                System.out.println();
            }
            else if (opt == 5)
            {
                System.out.print("Enter from vertex: ");
                Integer from1 = StdIn.readInt();
                System.out.print("Enter to vertex: ");
                Integer to1 = StdIn.readInt();
                System.out.print("Enter weight:");
                Double newWeight = StdIn.readDouble();
                G.up(from1, to1, newWeight);
                G.up(to1, from1, newWeight);
                System.out.println("Insert edge " + from1 + "->" + to1 + " (" + newWeight + ")");
				System.out.println();
            }
            else if (opt == 6)
            {
                System.out.print("Enter from vertex: ");
                Integer from2 = StdIn.readInt();
                System.out.print("Enter to vertex: ");
                Integer to2 = StdIn.readInt();
                double weight = G.getWeight(from2, to2);
                System.out.print("Enter weight: ");
                Double newWeight2 = StdIn.readDouble();
                if (newWeight2 < 0) {
                    G.down(from2, to2);
                    G.down(to2, from2);
                    System.out.println("remove edge " + from2 + "->" + to2);
                } else {
                    G.changeWeight(from2, to2, newWeight2);
                    System.out.println("Change edge " + from2 + "->" + to2 + " from " + weight + " to " + newWeight2);
                }
                System.out.println();
            }
            else if (opt == 7)
            {
                Eulerian myEulerian = new Eulerian(G);
                if (myEulerian.isTour()) {
                    System.out.println("Graph has an Eulerian tour.");
                    System.out.print("Eulerian Tour: ");
                    myEulerian.printTour();
                } else if (myEulerian.isPath()) {
                    System.out.println("Graph has an Eulerian path.");
                    System.out.print("Eulerian Path: ");
                    myEulerian.printPath();
                } else {
                    System.out.println("Graph has neither Eulerian tour nor Eulerian path. ");
                }
            }
            else if (opt == 8)
            {
                flag = false;
                break;
            }
        }
    }
}
