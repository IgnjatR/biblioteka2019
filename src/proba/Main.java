package proba;

import biblioteka.Autor;
import biblioteka.Biblioteka;
import biblioteka.Knjiga;

public class Main {

	public static void main(String[] args) {
		Biblioteka b = new Biblioteka();

		Autor a = new Autor("Pero", "Peric");
		Autor a1 = new Autor("Pero1", "Peric1");
		Autor a2 = new Autor("Pero2", "Peric2");
		Autor[] niz = { a1, a2 };
		Autor[] niz2 = { a };

		Knjiga k = new Knjiga("Naslov1", "Yesssssss", niz, "Izdavac1", 4);
		Knjiga k1 = new Knjiga("Naslov2", "Yessssses", niz2, "Izdavac2", 42);

		b.dodajKnjigu(k);
		b.dodajKnjigu(k1);

		b.sacuvajUJSONFajl("biblioteka.json");
		Biblioteka b2 = new Biblioteka();

		b2.ucitajKnjigeIzJSON("biblioteka.json");
		System.out.println(b2.vratiSveKnjige());

	}
}
