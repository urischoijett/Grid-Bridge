import java.util.ArrayList;

public class Node {
	public static ArrayList<Node> history = new ArrayList<Node>();
	
	private ArrayList<Node> path = null;
	private int[] 			state = new int[9];
	
	Node(int[] s){
		state = s;
		history.add(this);
	}
	
	Node(int[] s, ArrayList<Node> p){
		state = s;
		path = p;
		history.add(this);
	}
	
	public int getDepth(){
		return path.size();
	}
	public ArrayList<Node> getPath(){
		return path;
	}
	public int[] getState(){
		return state;
	}

	
};
