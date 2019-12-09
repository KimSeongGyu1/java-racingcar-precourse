package seonggyu.participants;

import java.util.List;
import java.util.ArrayList;

public class Participants {
	private List<Car> cars = new ArrayList<Car>();
	
	public Participants(List<String> inputNames) {
		ParticipantsConstraints.checkValidCarNames(inputNames);
		inputNames.stream()
			.forEach(inputName -> addNewCar(inputName));
	}

	private void addNewCar(String inputName) {
		Car newCar = new Car(inputName);
		this.cars.add(newCar);
	}

	public void printNamesAndPositions() {
		this.cars.stream()
			.forEach(car -> car.printNameAndPosition());
		System.out.println();	// 출력 포멧 맞추기
	}
	
	public void goOrStay() {
		this.cars.stream()
			.forEach(car -> car.goOrStay());
	}
	
	public Winners getWinners() {
		Winners winners = new Winners();
		this.cars.stream()
			.filter(car -> car.isWinnerCandidate(winners.getMaxDistance()))
			.forEach(car -> winners.add(car));
		return winners;
	}
}