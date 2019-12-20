package view;

public class OutputView {
	public static void printBlankLine() {
		System.out.println();
	}
	
	public static void printGivenString(String input) {
		System.out.println(input);
	}
	
	public static void printStartOfTheGame() {
		System.out.println("\n실행결과");
	}
	
	public static void printWinners(String winnerNames) {
		System.out.println(winnerNames + "가 최종 우승했습니다");
	}
}
