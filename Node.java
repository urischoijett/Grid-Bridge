import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	
	public static ArrayList<int[]>  history = new ArrayList<int[]>(); // list of all visited states
	public static final int[] 		goalState = {1,2,3,8,0,4,7,6,5};
	public static final int[] 		failState = {0,0,0,0,0,0,0,0,0};

	private ArrayList<int[]> path = new ArrayList<int[]>();
	private int[] 			 state = new int[9];
	
	//Constructors
	Node(int[] s){
		state = s;
	}
	Node(int[] s, ArrayList<int[]> p){
		state = s;
		path = p;
	}
	
	//methods
	public int getDepth(){
		return path.size();
	}
	
	public int[] getState(){
		return state;
	}
	
	public ArrayList<int[]> getPath(){
		return path;
	}
	
	public void addToPath(int[] n){
		path.add(n);
	}
	
	public boolean isValid(int[] newstate){
		for (int i=0; i<Node.history.size(); i++){
			if (Arrays.equals(newstate, Node.history.get(i))){
				return false;
			}
		}
		return true;
	}
	public ArrayList<Node> expandNode(){
		
		ArrayList<Node> children = new ArrayList<Node>();
		Node currNode, nextNode;
		currNode = this;
		
		ArrayList<int[]> newPath = new ArrayList<int[]> (currNode.getPath());
		newPath.add(currNode.getState().clone());
		int[] newState;
		
		int blankSpot = findBlank(currNode.getState());
		int temp;
		
		
		//move blank left
		if (blankSpot%3 != 0){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot-1];
			newState[blankSpot-1] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving Left");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		//move blank right
		if (blankSpot%3 != 2){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot+1];
			newState[blankSpot+1] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving right");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		//move blank up
		if (blankSpot > 2){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot-3];
			newState[blankSpot-3] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving up");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		//move blank down
		if (blankSpot < 6){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot+3];
			newState[blankSpot+3] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving down");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);	
			}
		}
		
		//move downleft
		if (blankSpot == 1 || blankSpot == 2 ||blankSpot == 4 ||blankSpot == 5 ){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot+2];
			newState[blankSpot+2] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving downleft");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		//move downright
		if (blankSpot == 0 || blankSpot == 1 ||blankSpot == 3 ||blankSpot == 4 ){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot+4];
			newState[blankSpot+4] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving downright");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		//move upleft
		if (blankSpot == 4 || blankSpot == 5 ||blankSpot == 7 ||blankSpot == 8 ){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot-4];
			newState[blankSpot-4] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving upleft");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		//move upright
		if (blankSpot == 3 || blankSpot == 4 ||blankSpot == 6 ||blankSpot == 7 ){
			newState = currNode.getState().clone();
			temp = currNode.getState()[blankSpot-2];
			newState[blankSpot-2] = 0;
			newState[blankSpot]   = temp;
			//add to possible children if valid
			if (currNode.isValid(newState)){
				System.out.println("Moving upright");
				nextNode = new Node(newState, newPath);
				children.add(nextNode);
				Node.history.add(newState);
			}
		}
		
		System.out.println("adding "+children.size()+" new nodes");
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
	
	public void print(){
		for (int i=0; i<9; i++){
			System.out.print(state[i]+" ");
		}
	}

};
