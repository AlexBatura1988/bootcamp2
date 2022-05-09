package ex2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {

		List<GameCharacter> characters = Arrays.asList(
				new GameCharacter("Arthas Menethil", "Lich King", "Icecrown", 80, 1500, Continent.Northrend),
				new GameCharacter("Thrall", "Warchief", "Orgrimmar", 90, 1200, Continent.Kalimdor),
				new GameCharacter("Jaina Proudmoore", "Lord Admiral", "Kul Tiras", 120, 1000,
						Continent.Eastern_Kingdoms),
				new GameCharacter("Tyrande Whisperwind", "Priestess of Elune", "Teldrassil", 120, 1100,
						Continent.Kalimdor),
				new GameCharacter("Sylvanas Windrunner", "Dark Ranger", "Undercity", 120, 1100,
						Continent.Eastern_Kingdoms));

		List<String> names = characters.stream().filter((c) -> c.getContinent() == Continent.Kalimdor)
				.map(c -> c.getName()).collect(Collectors.toList());
		names.forEach(c -> System.out.println(c));
		System.out.println();

		characters.stream().sorted(Comparator.comparing(c -> c.getHitPoints())).forEach(c -> System.out.println(c));
		System.out.println();

		List<Double> hitPoints = characters.stream().filter((c) -> c.getLevel() == 120) 
				.map(c -> c.getHitPoints()) 
				.collect(Collectors.toList());

		double average = hitPoints.stream().reduce(0.0, (acc, next) -> acc + next) / hitPoints.size();
		System.out.println("average is " + average);

	}

}
