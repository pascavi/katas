package org.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {
    private static final int N = Integer.MAX_VALUE;

    private Dijkstra dijkstra;

    @Before
    public void setUp(){
        dijkstra = new Dijkstra();
    }

    @Test
    public void emptyGraph() {
        int[][] graph = {};

        String path = dijkstra.solve(graph, 0, 0);

        Assert.assertEquals("", path);
    }

    @Test
    public void oneNodeGraph() {
        int[][] graph = {{0}};

        String path = dijkstra.solve(graph, 0, 0);

        Assert.assertEquals("[]", path);
    }

    @Test
    public void twoNodesGraph() {
        int[][] graph = {{0,1},{1,0}};

        String path = dijkstra.solve(graph, 0, 1);

        Assert.assertEquals("[0, 1]", path);
    }

    @Test
    public void threeNodesGraph() {
        int[][] graph = {{0,1,N},
                         {1,0,1},
                         {N,1,0}};

        String path = dijkstra.solve(graph, 0, 2);

        Assert.assertEquals("[0, 1, 2]", path);
    }

    @Test
    public void triangleGraph() {
        int[][] graph = {{0,1,10},
                         {1,0,1},
                         {10,1,0}};

        String path = dijkstra.solve(graph, 0, 2);

        Assert.assertEquals("[0, 1, 2]", path);
    }



}
