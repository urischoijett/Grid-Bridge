import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	
	public static ArrayList<int[]> history = new ArrayList<int[]>(); // list of all visited states

	private ArrayList<int[]> path = new ArrayList<int[]>();
	private int[] 			 state = new int[9];
	
	Node(int[] s){
		state = s;
	}
	
	Node(int[] s, ArrayList<int[]> p){
		state = s;
		path = p;
	}
	
	public int getDepth(){
		return path.size();
	}
	public ArrayList<int[]> getPath(){
		return path;
	}
	public void addToPath(int[] n){
		path.add(n);
	}
	public int[] getState(){
		return state;
	}

	public boolean isValid(int[] newstate){
		for (int i=0; i<Node.history.size(); i++){
			if (Arrays.equals(newstate, Node.history.get(i))){
				return false;
			}
		}
		return true;
	}
	
	public void print(){
		for (int i=0; i<9; i++){
			System.out.print(state[i]);
		}
	}
};
