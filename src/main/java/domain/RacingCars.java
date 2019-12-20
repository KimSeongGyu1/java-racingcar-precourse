package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import view.InputView;

public class RacingCars {
	private List<Car> racingCars = new ArrayList<Car>();
	
	public RacingCars() {
		generateCars();
	}
	
	private void generateCars() {
		try {
			List<String> input = InputView.enterCarNames();
			RacingCarsException.checkValidCarNames(input);
			generateCarsFromNames(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			generateCars();
		}
	}
	
	private void generateCarsFromNames(List<String> names) {
		names.stream()
			.map(name -> new Car(name))
			.forEach(car -> this.racingCars.add(car));
	}
	
	public void goOrStay() {
		this.racingCars.stream()
				.forEach(car -> car.goOrStay());
	}
	
	public String convertStatesToString() {
		return this.racingCars.stream()
				.map(car -> car.convertStatesToString())
				.collect(Collectors.joining("\n"));
	}
	
	public List<Car> getWinner() {
		List<Car> winner = new ArrayList<Car>();
		Position maxPosition = new Position();				// 0으로 초기화 된다
		this.racingCars.stream()
				.filter(car -> car.isWinnerCandidate(maxPosition))
				.forEach(car -> updateWinner(winner, car, maxPosition));
		return winner;
	}
	
	private void updateWinner(List<Car> winner, Car candidate, Position maxPosition) {
		if (candidate.hasBiggerPosition(maxPosition)) {
			winner.clear();
		}
		winner.add(candidate);
	}
}
