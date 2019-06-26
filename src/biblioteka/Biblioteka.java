package biblioteka;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	// Gson gson = new Gson();
	private List<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga k) {
		if (k == null)
			throw new NullPointerException("Knjiga ne sme biti null");

		if (knjige.contains(k))
			throw new RuntimeException("Knjiga ne sme vec postojati u biblioteci");

		knjige.add(k);
	}

	@Override
	public void obrisiKnjigu(Knjiga k) {
		if (k == null)
			throw new RuntimeException("Knjiga ne sme biti null");

		knjige.remove(k);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (autor == null && isbn == null && naslov == null && izdavac == null)
			throw new RuntimeException("Morate uneti bar jedan kriterijum za pretragu");

		LinkedList<Knjiga> rezultati = new LinkedList<Knjiga>();

		for (Knjiga knjiga : knjige)
			if (knjiga.getNaslov().contains(naslov))
				rezultati.add(knjiga);

		return rezultati;
	}

	@Override
	public void sacuvajUJSONFajl(String putanja) {
		try (FileWriter out = new FileWriter(putanja)) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			out.write(gson.toJson(knjige.toArray()));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ucitajKnjigeIzJSON(String putanja) {

		try (FileReader in = new FileReader(putanja)) {
			knjige.removeAll(knjige);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			knjige = Arrays.asList(gson.fromJson(in, Knjiga[].class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
