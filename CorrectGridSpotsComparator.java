import java.util.Comparator;

public class CorrectGridSpotsComparator implements Comparator<Node>{

	@Override
	public int compare(Node n1, Node n2) {
			if (n1.correctSpots() < n2.correctSpots()){
				return 1;
			} else if(n1.correctSpots() > n2.correctSpots()) {
				return -1;
			} else {
				return 0;
			}
	}
};
