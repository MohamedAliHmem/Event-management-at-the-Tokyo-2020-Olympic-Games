package sujet2;

public class Epreuve {
	String denomination ;
	Athlete [] tabAth ;
	int max ;
	int nbEff ;
	private boolean etat ;
	public Epreuve(String denomination, int max) {
		this.denomination = denomination;
		this.max = max;
		this.tabAth = new Athlete[max];
	}
	@Override
	public String toString() {
		return "Epreuve [denomination=" + denomination + ", nbEff=" + nbEff + ", etat=" + etat + "]";
	}
	void ajoutAthlete(Athlete a) {
		if (this.nbEff ==this.max) {
			System.out.println("complet");
		}else {
			this.tabAth[this.nbEff] = a ;
			this.nbEff++;
		}
	}
	
	void terminer () {
		this.etat = true ;
	}
	
	boolean estTerminee() {
		return this.etat ;
	}
	
	Resultat getRecordOlymique() {
		Resultat r =this.tabAth[0].getResultat();
		for (int i=1 ; i<this.nbEff-1 ; i++) {
			if(this.tabAth[i].getResultat().compareTo(this.tabAth[i+1].getResultat()) == 1) {
				if(this.tabAth[i].getResultat().compareTo(r) == 1) {
					r = this.tabAth[i].getResultat();
				}
			}
		}
		return r ;
	}
	
	Athlete getVinqueur() {
		if (this.estTerminee()) {
			for(int i=0 ; i<this.nbEff ; i++) {
				if (this.tabAth[i].getResultat().compareTo(getRecordOlymique()) == 0) {
					return this.tabAth[i];
				}
			}
		}
		return null;
	}
	
	void fixeResultat(int id, Resultat r) throws IllegalStateException{
		if(this.estTerminee()) {
			throw new IllegalStateException("epreuve terminer");
		}else {
			for (int i=0 ; i<this.nbEff ; i++) {
				if(this.tabAth[i].getId()== id) {
					this.tabAth[i].setResultat(r);
					break;
				}
			}
		}
	}
	
	Resultat getResultat(int id) {
		for (int i=0 ; i<this.nbEff ; i++) {
			if(this.tabAth[i].getId() == id) {
				if(this.tabAth[i].getResultat() == null) {
					return null ;
				}else
					return this.tabAth[i].getResultat();
			}
		}
		return null ;
	}
	public static void main(String [] args) {
		Epreuve e = new Epreuve("sport" , 4);
		Athlete a1 = new Athlete(1,"dali");
		Athlete a2 = new Athlete(2,"ali");
		Athlete a3 = new Athlete(3,"med");
		
		e.ajoutAthlete(a1);
		e.ajoutAthlete(a2);
		e.ajoutAthlete(a3);
		
		Resultat r1 = new ResultatDistance(2);
		Resultat r2 = new ResultatDistance(5);
		Resultat r3 = new ResultatDistance(1);
		
		e.tabAth[0].setResultat(r1);
		e.tabAth[1].setResultat(r2);
		e.tabAth[2].setResultat(r3);
		
		e.terminer();
		e.getVinqueur().getResultat().affiche();
	}
	
	
	
	
	
	
}
