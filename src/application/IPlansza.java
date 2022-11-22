package application;

public interface IPlansza {
	boolean status = false;
	public void zmienStatus(boolean stan);
	public boolean sprawdzStatus();
	public void czyszczenie();
	public void czyszczenie_kwadratu(int k);
	public int[] wez_tablice(int k);
	public int[] wez_tablice(String k);
	public void wpisz(String tablica, String indeks, String wartosc);
	public void wpisz(int tablica, int indeks, int wartosc);
}
