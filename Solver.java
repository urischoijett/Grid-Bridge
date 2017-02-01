import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solver {
/* Square [i]
 * -------------
 * |i=0|i=1| 2 | int[i] = number in square i   
 * -------------
 * | 3 | 4 | 5 |
 * -------------
 * | 6 | 7 | 8 |
 * -------------
 */

	private int[] goalState = {1,2,3,8,0,4,7,6,5};
	private int[] failState = {0,0,0,0,0,0,0,0,0};
	
	//general DFS solution, compare to goal state line might change
	public Node solveDFS(Node start){
		Stack<Node> brain = new Stack<Node>();
		Node currNode;
		ArrayList<Node> next;
		
		brain.push(start);
		while(!brain.empty()){
			currNode = brain.pop();
			if (Arrays.equals(currNode.getState(), goalState)){ //current node matches goal
				return currNode;
			} else {
				next = expandNode(currNode); //create new nodes
				brain.addAll(next);			
			}			
		}
		return new Node(failState);	//no node matches goal, return fail
	}
	
	//the meat. returns a list of all possible valid children of a given node
	private ArrayList<Node> expandNode(Node n){
		ArrayList<Node> children = null;
		
		return children;
	}
	
	public Node createRandomNode(){
		int[] randState = {0,1,2,3,4,5,6,7,8};
		Node n = new Node(randState);
		return n;
	}
	
};
