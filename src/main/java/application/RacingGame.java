package application;

import domain.RacingCars;
import view.InputView;

public class RacingGame {
	private Rounds rounds;
	
	public void play() {
		RacingCars racingCars = new RacingCars();
		System.out.println(racingCars.toString());
		
		enterRounds();
	}
	
	private void enterRounds() {
		try {
			this.rounds = new Rounds(InputView.enterRounds());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			enterRounds();
		}
	}
}
