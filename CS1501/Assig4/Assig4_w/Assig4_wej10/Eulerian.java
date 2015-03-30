import java.util.*;
public class Eulerian
{
  private final EdgeWeightedDigraph graph;
  private ArrayList<Integer> path = new ArrayList<Integer>(); //the pathway of Eulerian Path
  private ArrayList<Integer> tour = new ArrayList<Integer>(); //the pathway of Eulerian Tour
  public Eulerian(EdgeWeightedDigraph myGraph)
  { this.graph = myGraph;}
  public boolean isTour()
  {
    if(!graph.isConnected())
      return false;
    for(int v = 0; v < graph.V(); v++)
    {
      if((graph.outdegree(v)%2) == 1)
        return false;
    }
    return true;
  }//this method is to test whether graph has an Eulerian tour.
  public boolean isPath()
  {
    if(!graph.isConnected())
      return false;
    int count = 0;
    for(int v = 0; v < graph.V(); v++)
    {
      if((graph.outdegree(v)%2) == 1)
        count++;
    }
      if(count == 2) 
        return true;
      else 
        return false;
  }//this method is to test whether graph has an Eulerian path. 
    public void printTour()
  {
        if(!isTour()) tour = null;
        EdgeWeightedDigraph tempG = new EdgeWeightedDigraph(graph);
        tour.add(0);
        while(tempG.E() > 0)
        {
          int v = 0;
          int index = 0;
          for(Iterator<Integer> iter = tour.iterator(); iter.hasNext();index++)
          {
            v = iter.next();
            if(tempG.outdegree(v) > 0) {break;} 
          }
          while(tempG.outdegree(v) > 0)
          {
            for(Iterator<Integer> iter = tempG.vertices().iterator();iter.hasNext();)
            {
              int temp = iter.next();
              if(tempG.containsEdge(v,temp))
              {
                tour.add(index,temp);
                tempG.down(v,temp);
                v = temp;
                break;
              }
            }
          }
        }
         for(int count = 0; count < tour.size()-1; count++)
           System.out.print(tour.get(count)+" - ");
         System.out.print(tour.get(tour.size()-1));
         System.out.println("\n");
    }//this method is to print the Eulerian tour.
  
  public void printPath()
  {
    int v = graph.V();
    int[][] arg = new int[v][v];
    arg = graph.getMatrix(); //convert the graph information into the adjacency matrix 
    int n = arg.length;            // number of v
    int[][] a = new int [n][n];
    for (int i = 0; i < n; i++ ) 
    {
      for (int j = 0; j < n; j++)
        a[i][j] = arg[i][j];
    }
    int counter = 0, counterE = 0, vertBegin = 0, vertEnd = 0;
    for (int i = 0; i < n; i++ ) 
    {
      int connections = 0;
      for (int j = 0; j < n; j++)
        connections += a[i][j];
      counterE += connections;
      if (connections % 2 == 1)
      {
        counter++;
       if (counter == 1) vertBegin = i;
       else if (counter == 2) vertEnd = i;
       else
       {
         path = null;
         return;
       }
     }
    }
    counterE/=2;
    path.add(new Integer(vertBegin));
    int cc = vertBegin;
    do
    {
      for (int j = 0; j < n; j++)
       if (a[cc][j] > 0) 
       {
         int ff = j;
         a[cc][ff] -= 1;
         a[ff][cc] -= 1;
         path.add(new Integer(ff));
         cc = ff;
         break;
       }
    } while (cc != vertEnd);
    while (path.size() < counterE + 1) 
    { 
      int temp = 0;
      search:
      for (Integer pp :  path)
      {
        int i = pp.intValue();
        for (int j = 0; j < n; j++)
          if (a[i][j] > 0) 
          {
            temp = i;
            break search;
          }
      }
      ArrayList<Integer> ip = new ArrayList<Integer>();
      cc = temp;
      do
      {
        for (int j = 0; j < n; j++)
          if (a[cc][j] > 0) 
          {
            int ff = j;
            a[cc][ff] -= 1;
            a[ff][cc] -= 1;
            if (ff != temp) 
              ip.add(new Integer(ff));
              cc = ff;
              break;
          }
      } while (cc != temp);
      ArrayList<Integer> np = new ArrayList<Integer>();
      boolean done = false;
      for (Integer vvv : path)
      {
        int i = vvv.intValue();
        if (done || (i != temp))
          np.add(vvv);
        else
        {
          np.add(vvv);
          for (Integer vv : ip) np.add(vv);
          done = true;
          np.add(vvv);
        }
      }
      path = np;
    }
    for(int count = 0; count < path.size()-1; count++)
      System.out.print(path.get(count)+" - ");
      System.out.print(path.get(path.size()-1));
      System.out.println("\n");
  }//this method is to print the Eulerian path.
  
}