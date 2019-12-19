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
			List<String> input = InputView.enterCarNames();
			checkValidCarNames(input);
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
	
	private void checkValidCarNames(List<String> input) {
		checkOverlappingNames(input);
	}
	
	private void checkOverlappingNames(List<String> input) {
		if (input.stream().distinct().count() != input.size()) {
			throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요");
		}
	}
	
	public String toString() {
		StringBuilder SB = new StringBuilder();
		for (Car car : this.racingCars) {
			SB.append(car.getName() + " ");
		}
		return SB.toString();
	}
}
