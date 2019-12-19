package view;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class InputView {
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static List<String> enterCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		return ParseStringToList(SCANNER.nextLine());
	}
	
	private static List<String> ParseStringToList(String input) {
		List<String> output = new ArrayList<String>();
		String[] splittedString = input.split(",");
		for (String partition : splittedString) {
			output.add(partition.trim());
		}
		return output;
	}
	
	public static int enterRounds() {
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			return Integer.parseInt(SCANNER.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("정수를 입력해 주세요");
			return enterRounds();
		}
	}
}
