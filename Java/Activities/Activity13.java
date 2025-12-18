package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numArr = new ArrayList<>();
		Random indexGen = new Random();

		System.out.println("Enter the numbers for list");
		System.out.println("Enter a EOL or non-integer char to stop: ");

		while (scan.hasNextInt()) {
			numArr.add(scan.nextInt());
		}
		int index = indexGen.nextInt(numArr.size());
		System.out.println("Index value generated: " + index);
		System.out.println("Value in arary at generated index: " + numArr.get(index));

		scan.close();
	}
}
