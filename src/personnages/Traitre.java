
package personnages;

import java.util.Random;

public class Traitre extends Samourai {

    private int niveauTraitrise = 0;
    private Random random = new Random();

    public Traitre(String seigneur, String nom, String boisson, int argent) {
        super(seigneur, nom, boisson, argent);
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
    }

    public void ranconner(Commercant commercant) {
        if (niveauTraitrise < 3) {
            int argentCommercant = commercant.getArgent();
            int argentRanconner = argentCommercant * 2 / 10;
            commercant.perdreArgent(argentRanconner);
            gagnerArgent(argentRanconner);
            commercant.parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner + " sous ou gare à toi !");
            parler("Tout de suite grand " + getNom() + ".");
            niveauTraitrise++;
        } else {
            parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
        }
    }

    public void faireLeGentil() {
        if (NbConaissance < 1) {
            parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
        } else {
            Humain ami = memoire[random.nextInt(NbConaissance)];
            int don = argent / 20;
            String nomAmi = ami.getNom();
            parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
            parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
            ami.gagnerArgent(don);
            perdreArgent(don);
            ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
            if (niveauTraitrise > 1) {
                niveauTraitrise--;
            }
        }
    }
}