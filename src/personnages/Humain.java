
package personnages;

public class Humain {

    private String nom;
    private String boisson;
    protected int argent;
    protected int NbConaissance = 0;
    protected Humain[] memoire = new Humain[30];

    public Humain(String nom, String boisson, int argent) {
        this.nom = nom;
        this.boisson = boisson;
        this.argent = argent;
    }

    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }

    protected void gagnerArgent(int gain) {
        argent += gain;
    }

    protected void perdreArgent(int perte) {
        argent -= perte;
    }

    protected void parler(String texte) {
        System.out.println("(" + nom + ") - " + texte);
    }

    public void direBonjour() {
        parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
    }

    public void boire() {
        parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
    }

    public void acheter(String bien, int prix) {
        if (argent >= prix) {
            parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
            perdreArgent(prix);
        } else {
            parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
        }
    }
    
    private void memoriser( Humain humain ) {
    	if ( NbConaissance < 30 ) {
    		memoire[NbConaissance] = humain;
    		NbConaissance ++;
    	}
    	else {
    		for ( int i=0; i < 30 - 1; i++) {
    			memoire[i] = memoire[i + 1];
    		}
    		memoire[30 - 1] = humain;
    	}
    }
    
    private void repondre( Humain humain) {
    	direBonjour();
    	memoriser(humain);
    }
    
    public void faireConaissanceAvec( Humain humain ) {
    	direBonjour();
    	humain.repondre(this);
    	memoriser(humain);
    }
    
    public void listerConnaissance() {
    	String liste = "";
    	
    	for ( int i=0 ; i < NbConaissance; i++ ) {
    		liste += memoire[i].getNom();

    	}
    	
    	parler("Je connais beaucoup de monde dont : " + liste);
    }
}