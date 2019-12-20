package domain;

public class CarName {
	private final String name;
	
	public CarName(String input) {
		CarNameException.checkValidCarName(input);
		this.name = input;
	}
	
	public String getName() {
		return this.name;
	}
}
