package gr.duth.ee.euclid.datastructures.graphmst;

import java.io.PrintStream;
import java.io.Serializable;

public class WeightedGraph implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final int infinite = -1;

	protected int N; // Node count
	protected int[][] E; // Edges and distances/weights

	/**
	 * Create a new directed and weighted graph with numOfNodes nodes with integer IDs in the range [0, numOfNodes-1] and no edges
	 * @param numOfNodes
	 */
	public WeightedGraph(int numOfNodes) {
		N = numOfNodes;
		E = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				E[i][j] = infinite;
			}
		}
	}

	/**
	 * Set one of the graph's edges to have the specified distance/weight.
	 * If the edge was not present before, it is created with the specified distance/weight 
	 * @param i From node
	 * @param j To node
	 * @param distance The weight
	 */
	public void setEdge(int i, int j, int distance) {
		E[i][j] = distance;
		E[j][i] = distance;
	}

	/**
	 * Check if one of the graph's edges is present.
	 * @param i From node
	 * @param j To node
	 * @return true if it is present, false otherwise
	 */
	public boolean existsEdge(int i, int j) {
		return E[i][j] != infinite;
	}

	/**
	 * Get one of the graph's edges distance/weight.
	 *  
	 * @param i From node
	 * @param j To node
	 * @return If the edge is present, its distance/weight is returned. If the edge is not present, Double.NaN is returned
	 */
	public int getEdgeDistance(int i, int j) {
		return E[i][j];
	}

	/**
	 * Delete one of the graph's edges.
	 * @param i From node
	 * @param j To node
	 */
	public void removeEdge(int i, int j) {
		E[i][j] = infinite;
		E[j][i] = infinite;
	}

	/**
	 * Get the number of nodes in the graph.
	 * @return The number of nodes in the graph.
	 */
	public int getNumOfNodes() {
		return N;
	}

	/**
	 * Get the number of edges in the graph.
	 * @return The number of edges in the graph.
	 */
	public int getNumOfEdges() {
		int count = 0;

		for (int i = 0; i < N; i++) {
			count += getDegree(i);
		}
		return count / 2;
	}
	
	/**
	 * Get number of edges of a node.
	 * @param node The node
	 * @return The number of edges of this node
	 */
	public int getDegree(int node) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			if (existsEdge(node, i)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Helper method to print out the graph
	 * @param pst A {@link PrintStream}, typically {@link System#out} is given, where to print the edges
	 */
	public void printGraph(PrintStream pst) {
		int count = 0;
		pst.println("|V| = "+ getNumOfNodes()+", |E| = "+ getNumOfEdges() + ", E = {");
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if (existsEdge(i, j)) {
					pst.println("  " + i + "--" + j
							+ "=" + getEdgeDistance(i, j) + ",");
					count++;
				}
			}
		}
		pst.println("}");
	}	
	

	/**
	 * Helper method to print a full representation of the graph
	 * @return A {@link String} representation of the graph
	 */
	public String toString() {
		StringBuilder graphDesc = new StringBuilder(1000);
		graphDesc.append("|V|="+ getNumOfNodes() + ", |E|=" + getNumOfEdges());
		return graphDesc.toString();
		
	}
}