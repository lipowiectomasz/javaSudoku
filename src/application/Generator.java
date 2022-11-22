package application;


import java.util.Random;

import application.Plansza;

public class Generator implements IGenerator {
    public int[] rozA = new int[9];
    public int[] rozB = new int[9];
    public int[] rozC = new int[9];
    public int[] rozD = new int[9];
    public int[] rozE = new int[9];
    public int[] rozF = new int[9];
    public int[] rozG = new int[9];
    public int[] rozH = new int[9];
    public int[] rozI = new int[9];

    public int[] wez_tablice_rozwiazan(int k)
    {
        int[] tablica = new int[9];
        switch (k) {
            case 0:
                return rozA;
            case 1:
                return rozB;
            case 2:
                return rozC;
            case 3:
                return rozD;
            case 4:
                return rozE;
            case 5:
                return rozF;
            case 6:
                return rozG;
            case 7:
                return rozH;
            case 8:
                return rozI;
        }
        return tablica;
    }

    public void zapisz_rozwiazanie(IPlansza plansza) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                wez_tablice_rozwiazan(i)[j] = plansza.wez_tablice(i)[j];
            }
        }
    }

    public IPlansza oczysc(IPlansza plansza) {

        Random losuj_liczbe = new Random();
        int liczba1, liczba2;
        for (int i = 0; i < 55; i++) {
            liczba1 = losuj_liczbe.nextInt(9);
            liczba2 = losuj_liczbe.nextInt(9);

            if (plansza.wez_tablice(liczba1)[liczba2] == 0) {
                i--;
            }
            plansza.wez_tablice(liczba1)[liczba2] = 0;
        }
        return plansza;
    }

    public int generuj(int tablica, int indeks) {
        Random losuj_liczbe = new Random();
        int liczba;
        liczba = losuj_liczbe.nextInt(9) + 1;
        return liczba;
    }

    public int zmien(int tablica, int indeks, int wartosc) {
        if (wartosc == 9) {
            wartosc = 0;
        }
        wartosc++;
        return wartosc;
    }

    public String wez_przycisk(int k) {
        switch (k) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
        }
        return "";
    }

    public int[] poczatkoweA = new int[9];
    public int[] poczatkoweB = new int[9];
    public int[] poczatkoweC = new int[9];
    public int[] poczatkoweD = new int[9];
    public int[] poczatkoweE = new int[9];
    public int[] poczatkoweF = new int[9];
    public int[] poczatkoweG = new int[9];
    public int[] poczatkoweH = new int[9];
    public int[] poczatkoweI = new int[9];

    public int[] wez_tablice_poczatkowe(int k)
    {
        int[] tablica = new int[9];
        switch (k) {
            case 0:
                return poczatkoweA;
            case 1:
                return poczatkoweB;
            case 2:
                return poczatkoweC;
            case 3:
                return poczatkoweD;
            case 4:
                return poczatkoweE;
            case 5:
                return poczatkoweF;
            case 6:
                return poczatkoweG;
            case 7:
                return poczatkoweH;
            case 8:
                return poczatkoweI;
        }
        return tablica;
    }

    public void zapisz_rozwiazanie_poczatkowe(IPlansza plansza) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                wez_tablice_poczatkowe(i)[j] = plansza.wez_tablice(i)[j];
            }
        }
    }

}
