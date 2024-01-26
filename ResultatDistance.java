package sujet2;

public class ResultatDistance implements Resultat{
	double distance ;
	
	

	public ResultatDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "ResultatDistance [distance=" + distance + "]";
	}

	@Override
	public void affiche() {
		System.out.println(this.toString());
	}

	@Override
	public int compareTo(Resultat r){
		if(r instanceof ResultatDistance) {
			if(((ResultatDistance) r).distance == this.distance)
				return 0 ;
			else if (((ResultatDistance) r).distance < this.distance)
				return 1 ;
			else
				return -1 ;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
}
