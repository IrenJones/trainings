package streams;

import org.apache.avro.ipc.specific.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
		return Stream.of(names)
				.filter(n -> n.length() > 5)
				.map(String::length)
				.mapToInt(v -> v)
				.sum();
	}

	public static List<String> transform(List<List<String>> collection) {
		return collection.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	public static Person getOldestPerson(List<Person> people) {
		return people.stream()
				.max(Comparator.comparingInt(Person::getAge))
				.orElse(new Person("", 0));
	}

	// try to use reduce
	public static int calculate(List<Integer> numbers) {
		int result = 0;
		result = numbers.stream()
				.reduce(result, Integer::sum);
		return result;
	}

	public static Set<String> getKidNames(List<Person> people) {
		return people.stream()
				.filter(p -> p.getAge() < 18)
				.map(Person::getName)
				.collect(Collectors.toSet());
	}

	public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
		/*
		Map<Boolean, List<Person>> map = new HashMap<>();
		map.put(true, new ArrayList<>());
		map.put(false, new ArrayList<>());
		for (Person person : people) {
			map.get(person.getAge() >= 18).add(person);
		}
		 */
		return people.stream()
				.collect(Collectors.partitioningBy(person -> person.getAge() >= 18));
	}

	public static Map<String, List<Person>> groupByNationality(List<Person> people) {
		/*Map<String, List<Person>> map = new HashMap<>();
		for (Person person : people) {
			if (!map.containsKey(person.getNationality())) {
				map.put(person.getNationality(), new ArrayList<>());
			}
			map.get(person.getNationality()).add(person);
		}
		return map;
		 */

		return people.stream()
				.collect(Collectors.groupingBy(Person::getNationality));
	}

	public static String namesToString(List<Person> people) {
		/*
		String label = "Names: ";
		StringBuilder sb = new StringBuilder(label);
		for (Person person : people) {
			if (sb.length() > label.length()) {
				sb.append(", ");
			}
			sb.append(person.getName());
		}

		sb.append(".");
		return sb.toString();
		 */

		String result = people.stream()
				.map(Person::getName)
				.collect(Collectors.joining(", "));

		return "Names: " + result + ".";
	}

	public static String getString(List<Integer> list) {
		return list.stream()
				.map(value -> {
					if(value % 2 == 0) {
						return "e" + value;
					} else {
						return "o" + value;
					}
				})
				.collect(Collectors.joining(", "));
	}

	static class Person {

		private String name;
		private int age;
		private String nationality;

		public Person(String name, int age, String nationality) {
			this.name = name;
			this.age = age;
			this.nationality = nationality;
		}

		public Person(String name, int age) {
			this(name, age, "");
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String getNationality() {
			return nationality;
		}
	}
}

class PhoneBook {

	private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
		{
			put("Jos de Vos", "016/161616");
			put("An de Toekan", "016/161617");
			put("Kris de Vis", "016/161618");
		}
	};

	private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

	PhoneBook() { }

	public HashMap<String, String> getPhoneBookEntries() {
		return phoneBookEntries;
	}

	public Optional<String> findPhoneNumberByName(String name){
		return Optional.ofNullable(phoneBookEntries.getOrDefault(name, null));
	}

	public Optional<String> findNameByPhoneNumber(String phoneNumber){
		Optional<Map.Entry<String, String>> first = phoneBookEntries
				.entrySet()
				.stream()
				.filter(e -> e.getValue().equals(phoneNumber))
				.findFirst();

		return first.map(Map.Entry::getKey);
	}

	@Override
	public String toString() {
		System.out.println("Hello from PhoneBook's toString method");
		return "PhoneBook{" +
				"phoneBookEntries=" + phoneBookEntries +
				'}';
	}
}
