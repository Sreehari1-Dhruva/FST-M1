package activities;

import java.util.ArrayList;

public class Activity9 {
	public static void main(String[] args) {
		// declaring Arraylist of String objects
		ArrayList<String> myList = new ArrayList<String>();
		// Adding objects to Array List at default index
		myList.add("Raghu");
		myList.add("Ramesh");
		myList.add("Suresh");

		// Adding object at specific index
		myList.add(3, "Nikhil");
		myList.add(1, "Vimal");

		System.out.println("Print All the Objects:");
		for (String s : myList) {
			System.out.println(s);
		}
		//Iterator<String> iter = myList.iterator();
		System.out.println("3rd element in the list is: " + myList.get(3));
		System.out.println("Is Suresh in list: " + myList.contains("Suresh"));
		System.out.println("Size of ArrayList: " + myList.size());

		// remove element from list
		myList.remove("Vimal");
		System.out.println("New Size of ArrayList: " + myList.size());
	}

}
