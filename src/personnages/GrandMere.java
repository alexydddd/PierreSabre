
package personnages;

import java.util.Random;

public class GrandMere extends Humain {

    private Random random = new Random();

    private enum TypeHumain {
        COMMERCANT, RONIN, SAMOURAI, TRAITRE, YAKUZA, HABITANT
    }

    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);
    }

    protected void memoriser(Humain humain) {
        if (NbConaissance < 5) {
            super.memoriser(humain);
        } 
        else {
            parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
        }
    }

    private String humainHasard() {
        TypeHumain[] types = TypeHumain.values();
        TypeHumain type = types[random.nextInt(types.length)];
        switch (type) {
            case COMMERCANT: return "commerçant";
            case RONIN:      return "ronin";
            case SAMOURAI:   return "samouraï";
            case TRAITRE:    return "traître";
            case YAKUZA:     return "yakuza";
            default:         return "habitant";
        }
    }

    public void ragoter() {
        for (int i = 0; i < NbConaissance; i++) {
            Humain h = memoire[i];
            if (h instanceof Traitre) {
                parler("Je sais que " + h.getNom() + " est un traître. Petit chenapan !");
            } else {
                parler("Je crois que " + h.getNom() + " est un " + humainHasard());
            }
        }
    }
}