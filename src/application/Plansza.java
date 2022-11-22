
package application;

public class Plansza implements IPlansza {

    private boolean status = false;

    public int[] A = new int[9];
    public int[] B = new int[9];
    public int[] C = new int[9];
    public int[] D = new int[9];
    public int[] E = new int[9];
    public int[] F = new int[9];
    public int[] G = new int[9];
    public int[] H = new int[9];
    public int[] I = new int[9];

    public void czyszczenie() {
        for (int i = 0; i < 9; i++) {
            int[] tab = wez_tablice(i);
            for (int j = 0; j < 9; j++) {
                tab[j] = 0;
            }
        }
    }

    public void czyszczenie_kwadratu(int k) {
        int[] tab = wez_tablice(k);
        for (int i = 0; i < 9; i++) {
            tab[i] = 0;
        }
    }

    public int[] wez_tablice(int k)
    {
        int[] tablica = new int[9];
        switch (k) {
            case 0:
                return A;
            case 1:
                return B;
            case 2:
                return C;
            case 3:
                return D;
            case 4:
                return E;
            case 5:
                return F;
            case 6:
                return G;
            case 7:
                return H;
            case 8:
                return I;
        }
        return tablica;
    }

    public int[] wez_tablice(String k)
    {
        int[] tablica = new int[9];
        switch (k) {
            case "A":
                return A;
            case "B":
                return B;
            case "C":
                return C;
            case "D":
                return D;
            case "E":
                return E;
            case "F":
                return F;
            case "G":
                return G;
            case "H":
                return H;
            case "I":
                return I;
        }
        return tablica;
    }

    public void wpisz(String tablica, String indeks, String wartosc) {
        int[] tab;
        tab = wez_tablice(tablica);

        tab[Integer.parseInt(indeks)] = Integer.parseInt(wartosc);
    }

    public void wpisz(int tablica, int indeks, int wartosc) {
        int[] tab;
        tab = wez_tablice(tablica);
        tab[indeks] = wartosc;
    }
    public void zmienStatus(boolean stan){
    	this.status=stan;
    }
	public boolean sprawdzStatus(){
		return this.status;
	}
}
