package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static void main(String[] args) {
		fizzBuzz(15)
				.stream()
				.forEach(System.out::println);
	}

	public static List<String> fizzBuzz(int n) {
		List<String> s = new ArrayList<>();
		for(int i=1; i <=n; i++){
			if(i%3 == 0 && i%5 == 0){
				s.add("FizzBuzz");
			} else if(i%3 == 0){
				s.add("Fizz");
			} else if(i%5 == 0){
				s.add("Buzz");
			} else{
				s.add(String.valueOf(i));
			}
		}
		return s;
	}
}
