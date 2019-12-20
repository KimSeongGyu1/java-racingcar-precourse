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
	
	public String toString() {
		StringBuilder SB = new StringBuilder();
		for (Car car : this.racingCars) {
			SB.append(car.getName() + " ");
		}
		return SB.toString();
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
}
