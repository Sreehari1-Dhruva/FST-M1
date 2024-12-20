package activities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

class Plane {
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTookOfftime;
	private Date lastTimeLanded;

	Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<String>();
	}

	public void onboard(String passenger) {
		this.passengers.add(passenger);
	}

	public void settakeOfftime() {
		this.lastTookOfftime = new Date();

	}

	public Date gettakeOfftime() {
		return this.lastTookOfftime;
	}

	public void setland() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}

	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}

	public List<String> getPassengers() {
		return passengers;
	}
}

public class Activity6 {
	public static void main(String[] args) throws InterruptedException {

		Plane indigo = new Plane(3);
		indigo.onboard("Hari");
		indigo.onboard("Dhruva");
		indigo.onboard("Kumar");

		// set takeoff time
		indigo.settakeOfftime();
		System.out.println("Plane took off at:" + indigo.gettakeOfftime());
		System.out.println("Passengers are landing:" + indigo.getPassengers());

		// plane flying
		System.out.println("Plane is flying");
		Thread.sleep(5000);

		// set landing time
		indigo.setland();
		System.out.println("Plane landed at: " + indigo.getLastTimeLanded());
		System.out.println("Passengers in plane after landing:" + indigo.getPassengers());

	}

}
