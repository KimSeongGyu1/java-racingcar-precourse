package application;

import java.util.stream.Collectors;

import domain.RacingCars;
import view.InputView;
import view.OutputView;

public class RacingGame {
	private Rounds rounds;
	
	public void play() {
		RacingCars racingCars = new RacingCars();
		
		enterRounds();
		proceedRounds(racingCars);
		
		getWinner(racingCars);
	}
	
	private void enterRounds() {
		try {
			this.rounds = new Rounds(InputView.enterRounds());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			enterRounds();
		}
	}
	
	private void proceedRounds(RacingCars racingCars) {
		OutputView.printStartOfTheGame();
		for (int i = 0; i < this.rounds.getRounds(); i++) {
			racingCars.goOrStay();
			OutputView.printGivenString(racingCars.convertStatesToString());
			OutputView.printBlankLine();
		}
	}
	
	private void getWinner(RacingCars racingCars) {
		String winnerNames = racingCars.getWinner().stream()
				.map(car -> car.getName())
				.collect(Collectors.joining(","));
		OutputView.printWinners(winnerNames);
	}
}
