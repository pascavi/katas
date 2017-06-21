package org.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by Pascual on 24/12/2016.
 */
public class Dijkstra {


    public String solve(int[][] graph, int start, int end) {

        //check graph structure
        if (graph.length == 0) return "";
        for (int[] row : graph) {
            if (row.length != graph.length) return "";
        }

        //Initialization
        Map<Integer, Integer> dist = new TreeMap<>(), prev = new TreeMap<>();
        IntStream.range(0, graph.length).forEach(i -> dist.put(i, Integer.MAX_VALUE)); // dist[v] <- Infinity
        IntStream.range(0, graph.length).forEach(i -> prev.put(i, null)); // prev[v] <- undefined
        ArrayList<Integer> q = new ArrayList<>();
        IntStream.range(0, graph.length).forEach(i -> q.add(i)); // All nodes initially in Q (unvisited)
        dist.put(start, 0); // distance from source to source

        int c = 0;
        while (q.size() > 0 && c++ < graph.length) {
            int u = findNodeAtMinDist(dist); // node with the least distance will be selected first
            if (u == end) break; // Terminal condition, we found end.

            for (int v : q) { // nodes remaining in Q
                if (graph[u][v] == Integer.MAX_VALUE) continue; //not a neighbour of u
                int alt = dist.get(u) + graph[u][v];
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                }
            }

            q.removeIf(i -> i == u);
            dist.remove(u);
        }

        // build the path
        List<Integer> path = new ArrayList<>();

        if (prev.get(end) != null) { //we got a path to the end
            int u = end;
            c = 0;
            while (prev.get(u) != null && c++ < graph.length) {
                path.add(0, u);
                u = prev.get(u);
            }
            path.add(0,start);
        }

        return path.toString();
    }



    public static int findNodeAtMinDist( Map<Integer, Integer> dist) {
        // The entry with minimum distance

        Map.Entry<Integer, Integer> minimum = dist.entrySet().stream()
                .min(Map.Entry.comparingByValue(Integer::compareTo)).get();
        return minimum.getKey();
    }

}
