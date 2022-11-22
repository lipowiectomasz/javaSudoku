package application;

public interface IGenerator {

	public int[] wez_tablice_rozwiazan(int k);
	public void zapisz_rozwiazanie(IPlansza plansza);
	public IPlansza oczysc(IPlansza plansza);
	public int generuj(int tablica, int indeks);
	public int zmien(int tablica, int indeks, int wartosc);
	public String wez_przycisk(int k);
	public int[] wez_tablice_poczatkowe(int k);
	public void zapisz_rozwiazanie_poczatkowe(IPlansza plansza);

}
