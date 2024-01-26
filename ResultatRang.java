package sujet2;

public class ResultatRang implements Resultat{
	int rang ;

	
	public ResultatRang(int rang) {
		this.rang = rang;
	}

	@Override
	public String toString() {
		return "ResultatRang [rang=" + rang + "]";
	}

	@Override
	public void affiche() {
		System.out.println(this.toString());		
	}

	@Override
	public int compareTo(Resultat r) throws IllegalArgumentException {
		if(r instanceof ResultatRang) {
			if (((ResultatRang) r).rang == this.rang)
				return 0 ;
			else if(((ResultatRang) r).rang < this.rang)
				return -1;
			else
				return 1;
		}else
			throw new IllegalArgumentException();
	}
	
}
