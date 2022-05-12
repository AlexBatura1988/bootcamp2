package exam4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

	private static List<Tent> sortedByArea(List<Tent> tents) {
		return tents.stream().sorted(Comparator.comparing(c -> c.getWidth() * c.getLength()))
				.collect(Collectors.toList());
	}

	private static List<Tent> numPeople(int numPeople, List<Tent> tents) {
		return tents.stream().filter(t -> t.getNumPeople() >= numPeople)
				.sorted(Comparator.comparing(t -> t.getNumPeople())).collect(Collectors.toList());
	}

	private static boolean checkIfTensIsHighest(List<Tent> tents, Tent max) {
		return tents.stream().anyMatch(t -> t.getHeight() > max.getHeight());
	}

	private static Map<Double, List<Tent>> convertToMap(List<Tent> tents) {
		return tents.stream().collect(Collectors.toMap(Tent::getHeight,
				tent -> tents.stream().filter(t -> t.getHeight() == tent.getHeight()).collect(Collectors.toList()),
				(o1, o2) -> o1));
	}

	private static List<Tent> minMaxListFromMap(Map<Double, List<Tent>> mapTents, double maxHeight, double minHeight) {
		return mapTents.keySet().stream().filter(height -> height >= minHeight && height <= maxHeight)
				.flatMap(height -> mapTents.get(height).stream()).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Tent t1 = new Tent(4, 12, 10, 12);
		Tent t2 = new Tent(5, 6, 11, 5);
		Tent t3 = new Tent(6, 8, 15, 4);
		Tent t4 = new Tent(7, 8, 100, 4);
		Tent t5 = new Tent(8, 55, 10, 10);
		Tent t6 = new Tent(9, 8, 10, 9);
		Tent t7 = new Tent(10, 8, 10, 12);
		Tent t8 = new Tent(11, 8, 10, 12);
		Tent t9 = new Tent(12, 8, 12, 12);
		Tent t10 = new Tent(20, 11, 10, 7);

		List<Tent> tents = new ArrayList<>();
		tents.add(t1);
		tents.add(t2);
		tents.add(t3);
		tents.add(t4);
		tents.add(t5);
		tents.add(t5);
		tents.add(t6);
		tents.add(t7);
		tents.add(t8);
		tents.add(t9);
		tents.add(t10);

		System.out.println(sortedByArea(tents));
		System.out.println(numPeople(6, tents));

		System.out.println(checkIfTensIsHighest(tents, t1));
		System.out.println(checkIfTensIsHighest(tents, t3));

		Map<Double, List<Tent>> map = convertToMap(tents);

		System.out.println(map);

		System.out.println(minMaxListFromMap(map, 10, 7));

	}

}
