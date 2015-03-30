//this file is the test client
//import java.io.*;
import java.util.*;
public class hw4_xuw10
{
  public static void main(String[] args)
  {
    if(args.length !=1)//detects improper usage
   {
     System.err.println("Usage:java ChangeableGraph input_file");
     System.exit(1);
   }
    System.out.println("");
    System.out.println("1. R (eport)");
    System.out.println("2. M (inimum Spanning Tree)");
    System.out.println("3. S (hortest Path from) i j");
    System.out.println("4. D (own edge) i j");
    System.out.println("5. U (p edge) i j");
    System.out.println("6. C (hange weight of edge) i j x");
    System.out.println("7. E (ulerian)");
    System.out.println("8. Q (uit)\n");
    boolean flag = true;
    In in = new In(args[0]);
    EdgeWeightedDigraph myGraph = new EdgeWeightedDigraph(in);
    while(flag == true)
    {
      System.out.print("Enter your choice:");    
        Integer choices = StdIn.readInt();
           if(choices == 1)//Report the current active network, show whether it's connected or not; show the connected components.
           {  System.out.println(myGraph);
             CC cc = new CC(myGraph);//connected components
             int M = cc.count();
             Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
             for (int i = 0; i < M; i++)
             {
               components[i] = new Queue<Integer>();
             }
             for (int v = 0; v < myGraph.V(); v++) 
             {
               components[cc.id(v)].enqueue(v);
             }
             if(M == 1)
             {   System.out.println("Network is connected");
             System.out.println("Connected components");
            for (int i = 0; i < M; i++) 
             {System.out.print(" "+(i+1)+".  ");
               for (int v : components[i])
               {
                StdOut.print(v + " ");
               }
               StdOut.println("\n");
             }
             }
             else if (M >1)
              {   System.out.println("Network is not connected");
             System.out.println("Connected components");
            for (int i = 0; i < M; i++) 
             {
              System.out.print((i+1)+".  ");
               for (int v : components[i])
               {
                StdOut.print(v + " ");
               }
               StdOut.println();
             }
            System.out.println();
             }             
           }//end choice 1
           else if(choices == 2)//show the vertices and edges in the current mst
           {  System.out.println("Minimum Spanning Tree");
             KruskalMST mst = new KruskalMST(myGraph);
             for (DirectedEdge e : mst.edges()) 
             { StdOut.println(e);}
             StdOut.printf("%.5f\n", mst.weight());
             System.out.println();
           }//end choice 2
           else if(choices ==3)//display the shortest path from vertex i to j.
           {  System.out.print("Enter from vertex:");    
             Integer s = StdIn.readInt();
             System.out.print("Enter to vertex:");
             Integer t = StdIn.readInt();
             System.out.println("Shortest Path from vertex "+ s + " to vertex " + t + " is:");
             DijkstraSP sp = new DijkstraSP(myGraph, s);
             if (sp.hasPathTo(t)) {
                StdOut.printf("(%.2f)  ", sp.distTo(t));    
                    for (DirectedEdge e : sp.pathTo(t)) {
                        StdOut.print(e.tostring() + "   ");
                    }
                System.out.println("\n");
            }
            else
            {
              StdOut.printf("No path\n");
              System.out.println();
            }
           }//end choice 3
           else if(choices == 4)//edge(from,to,w) will go down.
           {
             System.out.print("Enter from vertex:");    
             Integer from = StdIn.readInt();
              System.out.print("Enter to vertex:");
              Integer to = StdIn.readInt();
              myGraph.down(from, to);
              myGraph.down(to,from);
              System.out.println("Remove edge "+from+"->"+to);
              System.out.println();
           }//end choice 4
           else if (choices == 5)//restore the edge
           {
            System.out.print("Enter from vertex:");    
              Integer from1 = StdIn.readInt();
              System.out.print("Enter to vertex:");
              Integer to1 = StdIn.readInt();
              System.out.print("Enter weight:");
              Double newWeight = StdIn.readDouble();
              myGraph.up(from1, to1,newWeight);
              myGraph.up(to1,from1,newWeight);
             System.out.println("Insert edge "+from1+"->"+to1 + " ("+newWeight+")");
           }//end choice 5
           else if(choices == 6)//change the weight of edge(i,j) and (j,i) to value x.
           { System.out.print("Enter from vertex:");    
              Integer from2 = StdIn.readInt();
              System.out.print("Enter to vertex:");
              Integer to2 = StdIn.readInt();
              double weight = myGraph.getWeight(from2,to2);
              System.out.print("Enter weight:");
              Double newWeight2 = StdIn.readDouble();
              if(newWeight2 < 0)
              {
                myGraph.down(from2,to2);
                myGraph.down(to2,from2);
                System.out.println("remove edge "+from2+"->"+to2);
              }
              else
              {myGraph.changeWeight(from2, to2, newWeight2);
             System.out.println("Change edge "+from2+"->"+to2 + " from " + weight + " to "+newWeight2);
              }
              System.out.println();
           }//end choice 6
           else if(choices == 7)//does the graph possess an Eulerian tour or Eulerian path or none or these?
           {
             Eulerian myEulerian = new Eulerian(myGraph);
             if(myEulerian.isTour())
             {
               System.out.println("Graph has an Eulerian tour.");
               System.out.print("Eulerian Tour: ");
               myEulerian.printTour();
             }
             else if(myEulerian.isPath())
             {
               System.out.println("Graph has an Eulerian path.");
               System.out.print("Eulerian Path: ");
               myEulerian.printPath();
             }
             else
             {
               System.out.println("Graph has neither Eulerian tour nor Eulerian path.");
             }
           }//end choice 7
          else if(choices ==  8)//quit the program
           {
             flag = false;
             break;
           }//end choice 8
          System.out.println("1. R (eport)");
          System.out.println("2. M (inimum Spanning Tree)");
          System.out.println("3. S (hortest Path from) i j");
          System.out.println("4. D (own edge) i j");
          System.out.println("5. U (p edge) i j");
          System.out.println("6. C (hange weight of edge) i j x");
          System.out.println("7. E (ulerian)");
          System.out.println("8. Q (uit)\n"); 
  }//end while
  }//end main
}//end class