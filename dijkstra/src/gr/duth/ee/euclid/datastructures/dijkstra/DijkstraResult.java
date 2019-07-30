package gr.duth.ee.euclid.datastructures.dijkstra;

import java.io.PrintStream;
import java.io.Serializable;

/**
 * Represents the result of the Dijkstra algorithm
 * WARNING: THIS MUST NOT BE MODIFIED BY STUDENTS!
 */
public class DijkstraResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public double[] nodeDistance = null; // Contains the distances/labels for each node i from the startNode 
	public int[] nodeThrough = null; // Contains the the previous node through which each node i is reached from the startNode
	
	/**
	 * Create a correctly sized {@link DijkstraResult} for the given {@link DirectedDistanceGraph}
	 * @param graph
	 */
	public DijkstraResult(DirectedDistanceGraph graph){
		nodeDistance = new double[graph.getNumOfNodes()];
		nodeThrough = new int[graph.getNumOfNodes()];
	}
	
	/**
	 * Helper method to print out the distances which result from the Dijkstra algorithm running on a graph
	 * @param pst A {@link PrintStream}, typically {@link System#out} is given, where to print the distances
	 */
	public void printDistances(PrintStream pst) {
		for (int i = 0; i < nodeDistance.length; i ++) {
			pst.println("Node:" + i + ", distance: " + nodeDistance[i] + ", through node: " + nodeThrough[i]);
		}
	}
	
}
