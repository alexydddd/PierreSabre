package histoire;

import personnages.Commercant;
import personnages.GrandMere;
import personnages.Yakuza;
import personnages.Ronin;
import personnages.Samourai;
import personnages.Traitre;

public class HistoireTP5 {

	public static void main(String[] args) {
		
		Commercant marco = new Commercant("Marco", 20);
		Commercant chonin = new Commercant("Chonin", 40);
		Commercant kumi = new Commercant("Kumi", 10);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		
		marco.faireConaissanceAvec(roro);
		marco.faireConaissanceAvec(yaku);
		marco.faireConaissanceAvec(chonin);
		marco.faireConaissanceAvec(kumi);
		
		marco.listerConnaissance();
		roro.listerConnaissance();
		yaku.listerConnaissance();
		
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
		akimoto.faireConaissanceAvec(marco);
		akimoto.listerConnaissance();
		akimoto.boire("thé");
		
		Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
		masako.faireLeGentil();
		masako.ranconner(kumi);
		masako.ranconner(chonin);
		masako.ranconner(marco);
		akimoto.faireConaissanceAvec(masako);
		masako.direBonjour();
		masako.ranconner(marco); 
		masako.direBonjour();
		masako.faireConaissanceAvec(yaku);
		masako.faireLeGentil();
		masako.direBonjour();
		roro.faireConaissanceAvec(masako);
		
		GrandMere grandMere = new GrandMere("Grand-Mère", 10);
		grandMere.faireConaissanceAvec(akimoto);
		grandMere.faireConaissanceAvec(yaku);
		grandMere.faireConaissanceAvec(masako);
		grandMere.faireConaissanceAvec(kumi);
		grandMere.faireConaissanceAvec(marco);
		grandMere.faireConaissanceAvec(chonin);
		grandMere.ragoter();
	}
}
