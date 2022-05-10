package ex1CreateLamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		Person person = new Person("Alex", "Batura", 20);
		Person person1 = new Person("Den", "Scoth", 30);
		Person person2 = new Person("Bob", "Martin", 60);
		Person person3 = new Person("Alice", "Smith", 39);
		Person person4 = new Person("Anjela", "Ahh", 18);

		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);

		persons.forEach(p -> System.out.println(p));
		System.out.println();

		Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		persons.forEach(p -> System.out.println(p));
		System.out.println();

		persons.forEach(p -> {
			if (!p.getFirstName().contains("o")) {
				System.out.println(p);
			}
		});

		System.out.println();

		List<Person> under21 = persons.stream().filter(p -> p.getAge() <= 21).collect(Collectors.toList());
		under21.forEach(p -> System.out.println(p));

	}

}
