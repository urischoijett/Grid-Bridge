import java.util.Comparator;

public class CorrectGridSpotsComparator implements Comparator<Node>{

	@Override
	public int compare(Node node1, Node node2) {
			if (correctSpots(node1) < correctSpots(node2)){
				return -1;
			} else if(correctSpots(node1) > correctSpots(node2)) {
				return 1;
			} else {
				return 0;
			}
	}
	
	private int correctSpots(Node n){
		int cs =0;
		for (int i=0; i<9; i++){
			if (n.getState()[i] == Node.goalState[i]){
				cs++;
			}
		}
		return cs;
	}
	

};
