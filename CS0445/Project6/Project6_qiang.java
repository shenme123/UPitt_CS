
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Project6 {

    public static void main(String[] args) throws Exception {
        dijkstra d = new dijkstra("graph.txt");
        System.out.println(d.getShortestPath("WAR", "SCR"));
    }
}

class dijkstra {

    int[][] graph = null;
    boolean[] cache = null;
    String[] cities = null;
    HashMap<ArrayList<Integer>, Integer> paths = null, candidate = null;

    public dijkstra(String file) throws IOException {
        BufferedReader infile = new BufferedReader(new FileReader(file));
        cities = infile.readLine().split("\t");
        int num = cities.length;
        cache = new boolean[num];
        graph = new int[num][num];
        int col = 0;
        while (infile.ready()) {
            String[] line = infile.readLine().split("\t");
            for (int row = 0; row < line.length; row++) {
                String item = line[row];
                if (item.equals("#")) {
                    graph[col][row] = Integer.MAX_VALUE;
                } else {
                    graph[col][row] = Integer.parseInt(item);
                }
            }
            col++;
        }
        infile.close();
        paths = new HashMap<>();
        candidate = new HashMap<>();
    }

    public String getShortestPath(String start, String target) {
        int a = -1, b = -1;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equals(start)) {
                a = i;
            } else if (cities[i].equals(target)) {
                b = i;
            }
        }
        return getShortestPathToString(a, b);
    }

    public String getShortestPathToString(int start, int target) {
        ArrayList<Integer> path = getShortestPath(start, target);
        if (path == null) {
            return "Cannot Arrive!";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer pos : path) {
                sb.append(cities[pos]).append(" ");
            }
            sb.append("DIST:" + paths.get(path));
            return sb.toString();
        }
    }

    public ArrayList<Integer> getShortestPath(int start, int target) {
        ArrayList<Integer> start_path = new ArrayList<>();
        start_path.add(start);
        paths.put(start_path, 0);
        while (true) {
            int min_val = Integer.MAX_VALUE, min_index = -1;
            ArrayList<Integer> temp_path = null;
            int temp_distance = -1;
            boolean exit = true;
            for (ArrayList<Integer> path : paths.keySet()) {
                int s = path.get(path.size() - 1);

                for (int row = 0; row < cities.length; row++) {
                    if (row != s && graph[s][row] != Integer.MAX_VALUE && !cache[row]) {
                        //add candidate
                        ArrayList<Integer> temp_candidate = new ArrayList<>();
                        temp_candidate.addAll(path);
                        temp_candidate.add(row);
                        int current_distance = paths.get(path) + graph[s][row];
                        candidate.put(temp_candidate, current_distance);
                        //find candidate for path
                        if (current_distance < min_val) {
                            min_val = graph[s][row];
                            min_index = row;
                            temp_path = temp_candidate;
                            temp_distance = current_distance;
                        }

                    }
                }
            }
            if (min_index != -1) {
                paths.put(temp_path, temp_distance);
                candidate.remove(temp_path);
                cache[min_index] = true;
                if (min_index == target) {
                    return temp_path;
                }
                //exit
                exit = false;
            }
            if (exit) {
                return null;
            }
        }
    }
}
