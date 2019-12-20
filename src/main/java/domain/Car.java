package domain;

public class Car {
	private CarName carName;
	private Position position = new Position();
	
	public Car(String name) {
		this.carName = new CarName(name);
	}
	
	public String getName() {
		return this.carName.getName();
	}
	
	public void goOrStay() {
		this.position.goOrStay();
	}
	
	public String convertStatesToString() {
		StringBuilder output = new StringBuilder();
		output.append(this.carName.getName() + ":");
		output.append(this.position.toString());
		return output.toString();
	}
	
	public boolean isWinnerCandidate(Position maxPosition) {
		if (!this.position.isSmallerThan(maxPosition)) {
			maxPosition.setTo(this.position);
			return true;
		}
		return false;
	}
	
	public boolean hasBiggerPosition(Position maxPosition) {
		if (this.position.isBiggerThan(maxPosition)) {
			return true;
		}
		return false;
	}
}
