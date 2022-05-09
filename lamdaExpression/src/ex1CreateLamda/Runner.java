package ex1CreateLamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		Person person = new Person("Alex", "Batura", 20);
		Person person1 = new Person("Den", "Scoth", 30);
		Person person2 = new Person("Bob", "Martin", 60);
		Person person3 = new Person("Alice", "Smith", 39);
		Person person4 = new Person("Anjela", "hhh", 18);

		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);

		persons.forEach(p -> System.out.println(p));

//		Comparator<Person> lastNameComporataor = new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//
//				return o1.getLastName().compareTo(o2.getLastName());
//			}
//
//		};

		Collections.sort(persons, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		System.out.println();
		persons.forEach(p -> System.out.println(p));
		System.out.println();

		persons.forEach(p -> {
			if (!p.getFirstName().contains("o")) {
				System.out.println(p);
			}
		});
		System.out.println();

		persons.forEach(p -> {
			if (p.getAge() <= 21) {
				System.out.println(p);
			}
		});

	}

}
