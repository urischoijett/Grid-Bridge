import java.util.Comparator;

public class GridDistanceComparator implements Comparator<Node>{
	@Override
	public int compare(Node n1, Node n2) {
			if (n1.totDistance() < n2.totDistance()){
				return 1;
			} else if(n1.totDistance() > n2.totDistance()) {
				return -1;
			} else {
				return 0;
			}
	}
	
	
};
