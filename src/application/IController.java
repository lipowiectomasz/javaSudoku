package application;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

public interface IController {
	public void onKeyTyped(KeyEvent event);
	public void onKeyReleased(KeyEvent event);
	public void onActionButtonNowaGra(ActionEvent event);
	public void onActionButtonOdNowa(ActionEvent event);
	public void onActionButtonWyczyscPlansze(ActionEvent event);
	public void onActionButtonUzupelnij(ActionEvent event);
	public void czyszczenie_planszy();
	public void stworz_nowa_gre();
	public void wyczysc_kwadrat(int k);
	public void szukaj_blednych();
	public boolean sprawdz_czy_zwyciezono();
	public void zwyciestwo();
}
