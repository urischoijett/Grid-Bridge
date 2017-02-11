import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solver {

	public Node solveDFS(Node start){
		Node.history.clear();
		Node.history.add(start.getState());
		
		Stack<Node> 		brain = new Stack<Node>();
		Node 				currNode;
		ArrayList<Node> 	next;
		brain.push(start);
		
		while(!brain.empty()){
			System.out.println(brain.size()+" nodes left to expand");
			currNode = brain.pop();
			
			if (Arrays.equals(currNode.getState(), Node.goalState)){ //current node matches goal
				return currNode;
			} else {
				next = currNode.expandNode(); //create new nodes
				if (next!= null){
					brain.addAll(next);
				}
			}			
		}
		return (new Node(Node.failState));	//no node matches goal, return fail
	}
	
	public Node solveBFS(Node start){
		Node.history.clear();
		Node.history.add(start.getState());
		
		ArrayDeque<Node> 	brain = new ArrayDeque<Node>();
		Node 				currNode;
		ArrayList<Node> 	next;
		brain.add(start);
		
		while(!brain.isEmpty()){
			System.out.println(brain.size()+" nodes left to expand");
			currNode = brain.pop();
			
			if (Arrays.equals(currNode.getState(), Node.goalState)){ //current node matches goal
				return currNode;
			} else {
				next = currNode.expandNode(); // else create new nodes and add to queue
				if (next!= null){
					for (int i=0; i<next.size(); i++){
						brain.addLast(next.get(i));
					}
				}
			}			
		}
		return (new Node(Node.failState));	//no node matches goal, return fail
	}
	
	public Node solveAStarOne(Node start){
		Node.history.clear();
		Node.history.add(start.getState());
		
		PriorityQueue<Node> 	brain = new PriorityQueue<Node>(10, new CorrectGridSpotsComparator());  //replace with appropriate comparator for different problems
		Node 					currNode;
		ArrayList<Node> 		next;
		brain.add(start);
		
		while(!brain.isEmpty()){
			System.out.println(brain.size()+" nodes left to expand");
			currNode = brain.poll();
			
			if (Arrays.equals(currNode.getState(), Node.goalState)){ //current node matches goal
				return currNode;
			} else {
				next = currNode.expandNode(); // else create new nodes and add to queue
				if (next!= null){
					for (int i=0; i<next.size(); i++){
						brain.offer(next.get(i));
					}
				}
			}			
		}
		return (new Node(Node.failState));	//no node matches goal, return fail
	}

	public Node solveAStarTwo(Node start){
		Node.history.clear();
		Node.history.add(start.getState());
		
		PriorityQueue<Node> 	brain = new PriorityQueue<Node>(10, new GridDistanceComparator());  //replace with appropriate comparator for different problems
		Node 					currNode;
		ArrayList<Node> 		next;
		brain.add(start);
		
		while(!brain.isEmpty()){
			System.out.println(brain.size()+" nodes left to expand");
			currNode = brain.poll();
			
			if (Arrays.equals(currNode.getState(), Node.goalState)){ //current node matches goal
				return currNode;
			} else {
				next = currNode.expandNode(); // else create new nodes and add to queue
				if (next!= null){
					for (int i=0; i<next.size(); i++){
						brain.offer(next.get(i));
					}
				}
			}			
		}
		return (new Node(Node.failState));	//no node matches goal, return fail
	}
	
	public Node solveAStarThree(Node start){
		Node.history.clear();
		Node.history.add(start.getState());
		
		PriorityQueue<Node> 	brain = new PriorityQueue<Node>(10, new GridAverageComparator());  //replace with appropriate comparator for different problems
		Node 					currNode;
		ArrayList<Node> 		next;
		brain.add(start);
		
		while(!brain.isEmpty()){
			System.out.println(brain.size()+" nodes left to expand");
			currNode = brain.poll();
			
			if (Arrays.equals(currNode.getState(), Node.goalState)){ //current node matches goal
				return currNode;
			} else {
				next = currNode.expandNode(); // else create new nodes and add to queue
				if (next!= null){
					for (int i=0; i<next.size(); i++){
						brain.offer(next.get(i));
					}
				}
			}			
		}
		return (new Node(Node.failState));	//no node matches goal, return fail
	}
	
	public Node createRandomNode(){
		int[] randState = {0,1,2,3,4,5,6,8,7};
//		int[] randState = {2,0,3,1,8,4,7,6,5};
		
		Node n = new Node(randState);
		return n;
	}
	
};
