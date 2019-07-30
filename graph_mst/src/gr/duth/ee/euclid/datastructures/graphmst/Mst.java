package gr.duth.ee.euclid.datastructures.graphmst;

import gr.duth.ee.euclid.datastructures.graphmst.WeightedGraph;

public class Mst {
        public static WeightedGraph mst(WeightedGraph g) {
                WeightedGraph r = new WeightedGraph(g.getNumOfNodes());
                int n = g.getNumOfNodes();
                boolean v[] = new boolean[n];
                v[0] = true;

                while (r.getNumOfEdges() < (n - 1)) {
                        int minWeight = Integer.MAX_VALUE;
                        int minSource = -1;
                        int minTarget = -1;
                        for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                        if (g.existsEdge(i, j) && (v[i] != v[j])) {
                                                if (g.getEdgeDistance(i, j) < minWeight) {
                                                        minWeight = g.getEdgeDistance(i, j);
                                                        minSource = i;
                                                        minTarget = j;
                                                }
                                        }
                                }
                        }
                        r.setEdge(minSource, minTarget, minWeight);
                        v[minTarget] = true;
                        v[minSource] = true;
                }
                return r;
        }
}