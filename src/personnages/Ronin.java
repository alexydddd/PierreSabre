package personnages;

public class Ronin extends Humain {
    private int honneur = 1;

    public Ronin(String nom, String boisson, int argent) {
        super(nom, boisson, argent);
    }

    public void donner(Commercant beneficiaire) {
        int don = argent / 10;
        parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
        perdreArgent(don);
        beneficiaire.recevoir(don);
    }

    public void provoquer(Yakuza adversaire) {
        int force = 2 * honneur;
        parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
        
        if (force >= adversaire.getReputation()) {
            parler("Je t'ai eu petit yakusa!");
            int gain = adversaire.perdre();
            gagnerArgent(gain);
            honneur++;
        } else {
            honneur--;
            int perte = argent;
            adversaire.gagner(perte);
            perdreArgent(perte);
            parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
        }
    }
}