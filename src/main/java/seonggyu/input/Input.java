package seonggyu.input;

import java.util.Scanner;
import java.util.List;

import seonggyu.participants.ParticipantsConstraints;
import seonggyu.rounds.RoundsConstraints;

public class Input {	
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static List<String> enterParticipantsNames() {
		List<String> carNames;
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = InputParser.parseStringArrToList(SCANNER.nextLine().split(","));
			ParticipantsConstraints.checkValidParticipantsNames(carNames);
			return carNames;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterParticipantsNames();
		}
	}
	
	public static int enterRounds() {
		int rounds;
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			rounds = InputParser.parseStringToInt(SCANNER.nextLine());
			RoundsConstraints.checkValidRounds(rounds);
			return rounds;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterRounds();
		}
	}
}