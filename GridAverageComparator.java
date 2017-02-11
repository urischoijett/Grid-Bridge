import java.util.Comparator;

public class GridAverageComparator implements Comparator<Node>{
	
	@Override
	public int compare(Node n1, Node n2) {
			if ((n1.correctSpots()+n1.totDistance())/2 < (n2.correctSpots()+n2.totDistance())/2){
				return 1;
			} else if((n1.correctSpots()+n1.totDistance())/2 > (n2.correctSpots()+n2.totDistance())/2) {
				return -1;
			} else {
				return 0;
			}
	}
}
