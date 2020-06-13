package different_tasks;

public class PhoneNumber {
	// Complete the parseDistrict function below.
	static String parseDistrict(String phonenum) {
		String onlyIntegers = phonenum.replaceAll("-", "");
		String code = phonenum.substring(0,3);
		if ("101".equals(code)){
			return "Mystic";
		} else if(getSum(code) == 5){
			return "Valor";
		} else if (checkDigits(onlyIntegers)){
			return "Forbidden";
		}
		return "Instinct";
	}

	static int getSum(String s){
		return s.chars()
				.map(v -> Character.digit(v, 10))
				.sum();
	}

	static boolean checkDigits(String s){
		return s.chars()
				.map(v -> Character.digit(v, 10))
				.filter(v -> v != 2 && v != 3 && v != 5 && v != 7)
				.count() <= 0;
	}
}
