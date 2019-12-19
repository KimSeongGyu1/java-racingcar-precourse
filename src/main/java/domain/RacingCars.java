package domain;

import java.util.List;
import java.util.ArrayList;

import view.InputView;

public class RacingCars {
	private List<Car> racingCars = new ArrayList<Car>();
	
	public RacingCars() {
		generateCars();
	}
	
	private void generateCars() {
		try {
			generateCarsFromNames(InputView.enterCarNames());
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
}
