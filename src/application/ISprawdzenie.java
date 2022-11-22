package application;

public interface ISprawdzenie {
	public boolean sprawdz_kwadrat(int[] tablica, int element);
	public boolean sprawdz_wiersz(int[] tablica, int element, int[] tab);
	public boolean sprawdz_kolumne(int[] tablica, int element, int[] tab);
	public boolean sprawdz(String string, String string2, IPlansza plansza);
	public boolean sprawdz(int tablica, int indeks, IPlansza plansza);
}
