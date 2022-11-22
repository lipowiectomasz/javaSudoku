package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements IController {
	@FXML
	private TextField A0, A1, A2, A3, A4, A5, A6, A7, A8, B0, B1, B2, B3, B4, B5, B6, B7, B8, C0, C1, C2, C3, C4, C5,
			C6, C7, C8, D0, D1, D2, D3, D4, D5, D6, D7, D8, E0, E1, E2, E3, E4, E5, E6, E7, E8, F0, F1, F2, F3, F4, F5,
			F6, F7, F8, G0, G1, G2, G3, G4, G5, G6, G7, G8, H0, H1, H2, H3, H4, H5, H6, H7, H8, I0, I1, I2, I3, I4, I5,
			I6, I7, I8;
	@FXML
	private Label wyswietlacz;

	@FXML
	private Button nowa_gra, wyczysc_plansze, uzupelnij, od_nowa;

	private int warunek_zwyciestwa;
	private IPlansza plansza;
	private IGenerator generator;
	private ISprawdzenie sprawdzenie;


	public Controller(){
		this.warunek_zwyciestwa=0;
		this.plansza = new Plansza();
		this.generator = new Generator();
		this.sprawdzenie = new Sprawdzenie();
	}

	public void onKeyTyped(KeyEvent event) {

		if (plansza.sprawdzStatus()) {
			Node tabela = (Node) A0.getParent();
			String wpisana_wartosc = event.getCharacter();
			Node zrodlo = (Node) event.getSource();
			String id_okno = zrodlo.getId();
			TextField okno = (TextField) tabela.lookup("#" + id_okno);
			wyswietlacz.setText("");
			if (okno.isEditable()) {
				okno.setText("");
				okno.setStyle("-fx-background-color:white;");
				if (wpisana_wartosc.equals("1") || wpisana_wartosc.equals("2") || wpisana_wartosc.equals("3")
						|| wpisana_wartosc.equals("4") || wpisana_wartosc.equals("5") || wpisana_wartosc.equals("6")
						|| wpisana_wartosc.equals("7") || wpisana_wartosc.equals("8") || wpisana_wartosc.equals("9")) {
					wyswietlacz.setText("");
					plansza.wpisz(String.valueOf(id_okno.charAt(0)), String.valueOf(id_okno.charAt(1)),
							wpisana_wartosc);
					if (sprawdzenie.sprawdz(String.valueOf(id_okno.charAt(0)), String.valueOf(id_okno.charAt(1)),
							plansza)) {
						szukaj_blednych();
						warunek_zwyciestwa++;
						if (warunek_zwyciestwa >= 81) {
							if (sprawdz_czy_zwyciezono()) {
								okno.setText(wpisana_wartosc);
								zwyciestwo();
							}
						}
					} else {
						wyswietlacz.setText("Niestety twoja cyfra powtarza sie! Wybierz inna :).");
						szukaj_blednych();

						okno.setStyle("-fx-backgroundcolor:red;");
					}
				} else {
					wyswietlacz.setText("Wprowadzony znak nie jest liczba z zakresu 1-9!");
					okno.setStyle("-fx-backgroundcolor:red;");
				}
			}
		} else {
			wyswietlacz.setText("Najpierw rozpocznij grê!");
		}
	}

	public void onKeyReleased(KeyEvent event) {
		Node tabela = (Node) A0.getParent();
		Node zrodlo = (Node) event.getSource();
		String id_okno = zrodlo.getId();
		TextField okno = (TextField) tabela.lookup("#" + id_okno);
		if (event.getCode() == KeyCode.BACK_SPACE) {
			if (okno.isEditable()) {
				okno.setStyle("-fx-background-color:white;");
				if (sprawdzenie.sprawdz(String.valueOf(id_okno.charAt(0)), String.valueOf(id_okno.charAt(1)), plansza)
						&& (okno.isEditable())) {
					warunek_zwyciestwa--;
					System.out.println("Pomniejszam warunek zwyciestwa!");
				}
				wyswietlacz.setText("");
			}
		}

	}

	public void onActionButtonNowaGra(ActionEvent event) {
		plansza.zmienStatus(true);
		stworz_nowa_gre();
		wyswietlacz.setText("Nowa gra");
	}

	public void onActionButtonOdNowa(ActionEvent event) {


		warunek_zwyciestwa = 26;
		if (plansza.sprawdzStatus()) {
			Node tabela = (Node) A0.getParent();
			TextField okno;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
					if (generator.wez_tablice_poczatkowe(i)[j] == 0) {
						okno.setText("");
						okno.setStyle("-fx-backgroundcolor:white;");
						okno.setStyle("-fx-text-fill:black;");
						okno.setEditable(true);
					} else {
						okno.setEditable(false);
						okno.setStyle("-fx-text-fill:blue;");
					}
				}
			}
			wyswietlacz.setStyle("-fx-text-fill: red;");
			wyswietlacz.setText("Od nowa");
		} else {
			wyswietlacz.setText("Najpierw zacznij nowa gre!");
		}

	}

	public void onActionButtonWyczyscPlansze(ActionEvent event) {
		warunek_zwyciestwa = 0;
		czyszczenie_planszy();
		plansza.zmienStatus(false);
		wyswietlacz.setText("");
	}

	public void onActionButtonUzupelnij(ActionEvent event) {
		if (plansza.sprawdzStatus()) {
			Node tabela = (Node) A0.getParent();
			TextField okno;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
					okno.setText(String.valueOf(generator.wez_tablice_rozwiazan(i)[j]));
					okno.setStyle("-fx-background-color:white;");
					okno.setStyle("-fx-text-fill: black;");
					okno.setEditable(false);
				}
			}
			zwyciestwo();
		} else {
			wyswietlacz.setStyle("-fx-text-fill: red;");
			wyswietlacz.setText("Najpierw zacznij nowa gre!");
		}

	}

	public void czyszczenie_planszy() {
		plansza.czyszczenie();
		Node tabela = (Node) A0.getParent();
		TextField okno;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
				if (plansza.wez_tablice(i)[j] == 0) {
					okno.setText("");
					okno.setStyle("-fx-background-color:white;");
					okno.setEditable(false);
				}

			}
		}
	}

	public void stworz_nowa_gre() {

		warunek_zwyciestwa = 26;
		czyszczenie_planszy();
		Node tabela = (Node) A0.getParent();
		TextField okno;
		int licznik_k;
		licznik_k = 2;

		for (int i = 0; i < 9; i++) {
			start: {
				for (int j = 0; j < 9; j++) {
					int liczba = generator.generuj(i, j);
					plansza.wpisz(i, j, liczba);

					if (!sprawdzenie.sprawdz(i, j, plansza)) {
						int licznik = 9;
						while (!sprawdzenie.sprawdz(i, j, plansza)) {
							liczba = generator.zmien(i, j, plansza.wez_tablice(i)[j]);
							plansza.wpisz(i, j, liczba);
							licznik--;
							if (licznik == 0) {
								wyczysc_kwadrat(i);
								j = 0;
								i--;
								licznik_k--;
								if (licznik_k == 0) {
									wyczysc_kwadrat(i);
									i--;
									licznik_k = 2;
									break start;
								}
								break start;
							}
						}
					}

					okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
					okno.setText("");
					okno.setText(String.valueOf(plansza.wez_tablice(i)[j]));
					okno.setEditable(true);
				}
			}
		}
		generator.zapisz_rozwiazanie(plansza);
		plansza = generator.oczysc(plansza);
		generator.zapisz_rozwiazanie_poczatkowe(plansza);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
				if (plansza.wez_tablice(i)[j] == 0) {
					okno.setText("");
					okno.setStyle("-fx-background-color:white;");
				} else {
					okno.setEditable(false);
					okno.setStyle("-fx-text-fill: blue;");
				}
			}
		}
		wyswietlacz.setStyle("-fx-text-fill: red;");

	}

	public void wyczysc_kwadrat(int k) {
		plansza.czyszczenie_kwadratu(k);
		Node tabela = (Node) A0.getParent();
		TextField okno;
		for (int i = 0; i < 9; i++) {
			okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(k) + String.valueOf(i));
			if (plansza.wez_tablice(k)[i] == 0) {
				okno.setText("");
			}
		}
	}

	public void szukaj_blednych() {
		Node tabela = (Node) A0.getParent();
		TextField okno;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
				if (okno.getStyle() == "-fx-background-color:red;") {
					if (sprawdzenie.sprawdz(i, j, plansza)) {
						okno.setStyle("-fx-background-color:white;");
						warunek_zwyciestwa++;
					}
				}
			}
		}
	}

	public boolean sprawdz_czy_zwyciezono() {
		Node tabela = (Node) A0.getParent();
		TextField okno;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
				if (okno.getStyle() == "-fx-background-color:red;" || plansza.wez_tablice(i)[j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	public void zwyciestwo() {
		Node tabela = (Node) A0.getParent();
		TextField okno;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				okno = (TextField) tabela.lookup("#" + generator.wez_przycisk(i) + String.valueOf(j));
				okno.setStyle("-fx-background-color:#FFF200;-fx-text-fill: black;");
				okno.setEditable(false);
			}
		}
		wyswietlacz.setStyle("-fx-text-fill: black;");

		wyswietlacz.setText("Zwyciestwo!!!");
	}
}
