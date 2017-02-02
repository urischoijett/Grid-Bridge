import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	public static ArrayList<Node> history = new ArrayList<Node>();
	
	private ArrayList<Node> path = null;
	private int[] 			state = new int[9];
	
	Node(int[] s){
		state = s;
	}
	
	Node(int[] s, ArrayList<Node> p){
		state = s;
		path = p;
	}
	
	public int getDepth(){
		return path.size();
	}
	public ArrayList<Node> getPath(){
		return path;
	}
	public void addToPath(Node n){
		path.add(n);
	}
	public int[] getState(){
		return state;
	}

	public boolean isValid(){
		for (int i=0; i<Node.history.size(); i++){
			if (Arrays.equals(state, Node.history.get(i).getState())){
				return false;
			}
		}
		return true;
	}
	
};
