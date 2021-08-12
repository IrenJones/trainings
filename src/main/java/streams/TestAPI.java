package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestAPI {
    private static Employee[] arrayOfEmps = {
        new Employee(1, "Hhh JJJ", 100000.0, "HR"),
        new Employee(2, "DDD KKK", 200000.0, "IT"),
        new Employee(3, "ghktjy", 300000.0, "HR"),
        new Employee(3, "ghktjyerkje", 300000.0, "IT"),
        new Employee(3, "ghktjyerkje;r;tjg", 300000.0, "M"),
    };

    public static void main(String[] args) {

        Map<String, List<Employee>> res = Stream.of(arrayOfEmps)
            .collect(Collectors.groupingBy(Employee::getDepartment));

        Employee employee = Stream.of(arrayOfEmps)
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .findFirst()
            .orElse(null);

        Employee[] employees = Stream.of(arrayOfEmps).toArray(Employee[]::new);

        List<List<String>> namesNested = Arrays.asList(
            Arrays.asList("Jeff", "Bezos"),
            Arrays.asList("Bill", "Gates"),
            Arrays.asList("Mark", "Zuckerberg"));

        List<String> names = namesNested.stream()
            .flatMap(list -> list.stream())
            .collect(Collectors.toList());

        Stream<Integer> infiniteStream = Stream.iterate(1, x -> x * 2);

        List<Integer> integers = infiniteStream.skip(0).limit(6).collect(Collectors.toList());

        Double sumSal = Arrays.asList(arrayOfEmps).stream()
            .map(Employee::getSalary)
            .reduce(0.0, (sum, x) -> sum + x);

        int sum = Arrays.asList(arrayOfEmps).stream()
            .mapToInt(e -> (int)((double)e.getSalary()))
            .sum();

        Double avg = Arrays.asList(arrayOfEmps).stream()
            .map(Employee::getSalary)
            .collect(Collectors.averagingDouble(num -> num));

        OptionalDouble average = Arrays.asList(arrayOfEmps).stream()
            .map(Employee::getSalary)
            .mapToDouble(v -> (double)v)
            .average();

        String str = Arrays.asList(arrayOfEmps).stream()
            .map(Employee::getName)
            .collect(Collectors.joining(", "));

        int[] input = {56, 6, 7, 89, 59, 3, 9, 3648};
        Map<Integer, List<String>> res1 = IntStream.of(input)
            .boxed()
            .collect(Collectors.groupingBy(v -> String.valueOf(v).length(),
                Collectors.mapping((Integer v) -> v % 2 == 0 ? "e" + v : "o" + v, Collectors.toList())));

        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream()
            .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        Map<Boolean, List<Integer>> result = intList.stream()
            .collect(Collectors.groupingBy(v -> v % 2 == 0, Collectors.toList()));

        Map<Boolean, Long> resCount = intList.stream()
            .collect(Collectors.groupingBy(v -> v % 2 == 0, Collectors.counting()));

        System.out.println(IntStream.of(new int[] {2, 4, 5, 6}).boxed()
            .filter(v -> v > 2)
            .collect(Collectors.toList()));

        Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);

        Map<String, Set<Employee>> map = groupByDepartmentTitle(Arrays.asList(arrayOfEmps));


    }

    public static Map<String, Set<Employee>> groupByDepartmentTitle(List<Employee> employeeList) {
        return employeeList
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
    }
}
