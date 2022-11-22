package application;

public class Sprawdzenie implements ISprawdzenie {

    public boolean sprawdz_kwadrat(int[] tablica, int element) {
        for (int i = 0; i < 9; i++) {
            if (i == element) {
                continue;
            }
            if (tablica[element] == tablica[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean sprawdz_wiersz(int[] tablica, int element, int[] tab) {
        int k = 0, j = 0;
        if (element >= 0 && element <= 2)
            k = 0;
        if (element >= 3 && element <= 5)
            k = 3;
        if (element >= 6 && element <= 8)
            k = 6;
        j = k + 2;
        for (int i = k; i <= j; i++) {
            if (i == element && tablica == tab) {
                continue;
            }
            if (tablica[element] == tab[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean sprawdz_kolumne(int[] tablica, int element, int[] tab) {
        int k = 0, j = 0;
        if (element == 0 || element == 3 || element == 6)
            k = 0;
        if (element == 1 || element == 4 || element == 7)
            k = 1;
        if (element == 2 || element == 5 || element == 8)
            k = 2;
        j = k + 6;
        for (int i = k; i <= j; i = i + 3) {
            if (i == element && tablica == tab) {
                continue;
            }
            if (tablica[element] == tab[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean sprawdz(String tablica, String indeks, IPlansza plansza) {
        int[] tab = plansza.wez_tablice(tablica);
        if (!sprawdz_kwadrat(tab, Integer.parseInt(indeks))) {
            return false;
        }

        int k = 0, j = 0;
        int[] tab2;
        if (tablica.equals("A") || tablica.equals("B") || tablica.equals("C")) {
            k = 0;
        }
        if (tablica.equals("D") || tablica.equals("E") || tablica.equals("F")) {
            k = 3;
        }
        if (tablica.equals("G") || tablica.equals("H") || tablica.equals("I")) {
            k = 6;
        }
        j = k + 2;

        for (int i = k; i <= j; i++) {
            tab2 = plansza.wez_tablice(i);
            if (sprawdz_wiersz(tab, Integer.parseInt(indeks), tab2) == false) {
                return false;
            }
        }
        if (tablica.equals("A") || tablica.equals("D") || tablica.equals("G")) {
            k = 0;
        }
        if (tablica.equals("B") || tablica.equals("E") || tablica.equals("H")) {
            k = 1;
        }
        if (tablica.equals("C") || tablica.equals("F") || tablica.equals("I")) {
            k = 2;
        }
        j = k + 6;
        for (int i = k; i <= j; i = i + 3) {
            tab2 = plansza.wez_tablice(i);
            if (sprawdz_kolumne(tab, Integer.parseInt(indeks), tab2) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean sprawdz(int tablica, int indeks, IPlansza plansza) {
        int[] tab = plansza.wez_tablice(tablica);

        if (!sprawdz_kwadrat(tab, indeks)) {
            return false;
        }

        int k = 0, j = 0;
        int[] tab2;
        if (tablica >= 0 && tablica <= 2) {
            k = 0;
        }
        if (tablica >= 3 && tablica <= 5) {
            k = 3;
        }
        if (tablica >= 6 && tablica <= 8) {
            k = 6;
        }
        j = k + 2;

        for (int i = k; i <= j; i++) {
            tab2 = plansza.wez_tablice(i);
            if (sprawdz_wiersz(tab, indeks, tab2) == false) {

                return false;
            }
        }
        if (tablica == 0 || tablica == 3 || tablica == 6) {
            k = 0;
        }
        if (tablica == 1 || tablica == 4 || tablica == 7) {
            k = 1;
        }
        if (tablica == 2 || tablica == 5 || tablica == 8) {
            k = 2;
        }
        j = k + 6;
        for (int i = k; i <= j; i = i + 3) {
            tab2 = plansza.wez_tablice(i);
            if (sprawdz_kolumne(tab, indeks, tab2) == false) {
                return false;
            }
        }
        return true;
    }

}
