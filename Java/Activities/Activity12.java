package activities;

@FunctionalInterface
interface Addable {
	int add(int a, int b);
}

public class Activity12 {
	public static void main(String[] args) {

		Addable ad1 = (int a, int b) -> {
			return a + b;
		};
		System.out.println(ad1.add(10, 20));

	}
}
