public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    private int[][] adjMatrix = new int[6][6];
    public int[][] getMatrix()
    {
      return adjMatrix;
    }
    public EdgeWeightedDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }
    public EdgeWeightedDigraph(int V, int E) {
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = (int) (Math.random() * V);
            int w = (int) (Math.random() * V);
            double weight = Math.round(100 * Math.random()) / 100.0;
            DirectedEdge e = new DirectedEdge(v, w, weight);
            DirectedEdge ee = new DirectedEdge(w,v,weight);
            addEdge(e);
            addEdge(ee);
        }
    }
    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            adjMatrix[v][w] = 1;
            adjMatrix[w][v] = 1;
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
            addEdge(new DirectedEdge(w, v, weight));
        }
    }
    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
            for (DirectedEdge e : G.adj[v]) {
                reverse.push(e);
            }
            for (DirectedEdge e : reverse) {
                adj[v].add(e);
            }
        }
    }
    public int V() 
    {return V;}
    public int E()
    {return E;}
    public double getWeight(int from,int to)
    {
      double weight = 0;
      for(DirectedEdge e: adj[from])
      {
        if(e.to()==to)
        {weight = e.weight();}
      }
      return weight;
    }
    
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v) 
    {
        
        return adj[v];
    }
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }
    public Iterable<Integer> vertices()
    {
      Bag<Integer> list = new Bag<Integer>();
      for(int e = 0 ; e < E; e++)
      {
        list.add(e);
      }
      return list;
    }
    public boolean containsEdge(int from,int to)
    {
      DirectedEdge ee = new DirectedEdge(from,to,getWeight(from,to));
      DirectedEdge reverse = new DirectedEdge(to,from,getWeight(to,from));
      for(DirectedEdge e : edges())
      {
        if (e.equals(ee) || e.equals(reverse))
          return true; 
      }
      return false;
    }
    
    public int outdegree(int v) 
    { return adj[v].size();}
    public void down(int from, int to)
    { 
       Bag<DirectedEdge> list = new Bag<DirectedEdge>();  
      for (DirectedEdge e : adj[from])
      //for(DirectedEdge e : this.adj(from))
       {
           if(e.to()!=to)
           list.add(e);
       }
        adj[from] = list;
      E--;
    }
    public void up(int from, int to,double newWeight)
    {
      DirectedEdge newEdge = new DirectedEdge(from, to, newWeight);
     addEdge(newEdge);
     
    }
    public void changeWeight(int from, int to, double x)
    {
        down(from,to);
        down(to,from);
        DirectedEdge newEdge = new DirectedEdge(from,to,x);
        addEdge(newEdge);
        DirectedEdge reverseEdge = new DirectedEdge(to,from,x);
        addEdge(reverseEdge);
    }
    public boolean isConnected()
    {
      CC cc = new CC(this);
      if(cc.count() ==1)
      return true;
      return false;
    }
     public String toString() {
        //String NEWLINE = System.getProperty("line.separator");
        //StringBuilder s = new StringBuilder();
       String s = ""; 
       s+=V + " " + E/2 + "\n";
        for (int v = 0; v < V; v++) {
            s+=v + ": ";
            for (DirectedEdge e : adj[v]) {
              
                s+=e + "  ";
            }
            s+="\n";
        }
        return s;
    }
}
