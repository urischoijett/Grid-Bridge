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
			System.out.println(brain.size()+" nodes left to expand");
			currNode = brain.pop();
			if (Arrays.equals(currNode.getState(), goalState)){ //current node matches goal
				return currNode;
			} else {
				next = expandNode(currNode); //create new nodes
				if (next!= null){
					brain.addAll(next);
				}
			}			
		}
		return new Node(failState);	//no node matches goal, return fail
	}
	
	public Node createRandomNode(){
		//int[] randState = {0,1,2,3,4,5,6,7,8};
		int[] randState = {1,2,3,0,8,4,7,6,5};
		Node n = new Node(randState);
		return n;
	}
	
	//the meat. returns a list of all possible valid children of a given node
	private ArrayList<Node> expandNode(Node currNode){
		
		ArrayList<Node> children = new ArrayList<Node>();
		Node nextNode;
		
		int[] newState;
		int blankSpot = findBlank(currNode.getState());
		int temp;
		
		
		//move blank left
		if (blankSpot%3 != 0){
			newState = currNode.getState();
			temp = currNode.getState()[blankSpot-1];
			newState[blankSpot-1] = 0;
			newState[blankSpot]   = temp;
			nextNode = new Node(newState);
			
			if (nextNode.isValid()){
				System.out.println("Moving Left");
				Node.history.add(nextNode);
				children.add(nextNode);
			}
		}
		
		//move blank right
		if (blankSpot%3 != 2){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot+1];
			newState[blankSpot+1] = 0;
			newState[blankSpot]   = temp;
			nextNode = new Node(newState);
			
			if (nextNode.isValid()){
				System.out.println("Moving right");
				Node.history.add(nextNode);
				children.add(nextNode);
			}
		}
		
		//move blank up
		if (blankSpot > 2){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot-3];
			newState[blankSpot-3] = 0;
			newState[blankSpot]   = temp;
			nextNode = new Node(newState);
			
			if (nextNode.isValid()){
				System.out.println("Moving up");
				Node.history.add(nextNode);
				children.add(nextNode);
			}
		}
		
		//move blank down
		if (blankSpot < 6){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot+3];
			newState[blankSpot+3] = 0;
			newState[blankSpot]   = temp;
			nextNode = new Node(newState);
			
			if (nextNode.isValid()){
				System.out.println("Moving down");
				Node.history.add(nextNode);
				children.add(nextNode);
			}
		}
		System.out.println("adding "+children.size()+" new nodes");
		Node.history.add(currNode);
		return children;
	}
	
	private int findBlank(int[] a){
		int index = -1;
		for (int i =0; i<a.length; i++){
			if(a[i] == 0){
				return i;
			}
		}
		
		return index;
	}

	
	
};
