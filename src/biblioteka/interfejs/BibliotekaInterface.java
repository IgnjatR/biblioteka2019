package biblioteka.interfejs;

import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterface {
	
	public void dodajKnjigu(Knjiga k);
	
	public void obrisiKnjigu(Knjiga k);
	
	public List<Knjiga> vratiSveKnjige();
	
	public List<Knjiga> pronadjiKnjigu(Autor autor, String isbn, 
			String naslov, String izdavac);
	
	public void sacuvajUJSONFajl(String putanja);
	public void ucitajKnjigeIzJSON(String putanja);
}
