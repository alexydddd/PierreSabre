
package personnages;

public class Yakuza extends Humain {

    private String clan;
    private int reputation = 0;

    public Yakuza(String nom, String boisson, int argent, String clan) {
        super(nom, boisson, argent);
        this.clan = clan;
    }
    
    @Override
    public void direBonjour() {
        super.direBonjour();
        parler("Mon clan est celui de " + clan + ".");
    }

    public int getReputation() {
        return reputation;
    }

    public void extorquer(Commercant victime) {
        parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
        parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
        int somme = victime.seFaireExtorquer();
        gagnerArgent(somme);
        reputation++;
        parler("J'ai piqué les " + somme + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi ! Hi !");
    }
    
    public int perdre() {
        int montantPerdu = getArgent(); 
        perdreArgent(montantPerdu);   
        reputation--;                
        parler("J'ai perdu mon duel... snif.");
        return montantPerdu;          
    }

    public void gagner(int gain) {
        gagnerArgent(gain);            
        reputation++;               
        parler("Hi! Hi! J'ai gagné " + gain + " sous !");
    }
}