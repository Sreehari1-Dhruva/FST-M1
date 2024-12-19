package activities;

public class Car {

	String color;
	int year;
	String transmission;
	int tyres;
	int doors;

	Car(String color, int year, String transmission) {
		this.tyres = 4;
		this.doors = 4;
		this.color = color;
		this.year = year;
		this.transmission = transmission;
	}

	public void displayCharacterstics() {
		System.out.println("Color : " + color);
		System.out.println("year: " + year);
		System.out.println("Transmission: " + transmission);
		System.out.println("Number of doors: " + doors);
		System.out.println("Number of tyres: " + tyres);
	}

	public void accelerate() {
		System.out.println("Car is moving forward.");
	}

	public void brake() {
		System.out.println("Car is stopped");
	}

}
