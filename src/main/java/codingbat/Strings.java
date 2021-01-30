package codingbat;

public class Strings {

	public int sumNumbers(String str) {
		int sum = 0;

		for(int i=0; i< str.length(); i++) {
			int value = 0;
			while(i < str.length() && Character.isDigit(str.charAt(i))){
				value = value * 10 + str.charAt(i) - '0';
				i++;
			}
			sum += value;
		}

		return sum;
	}

	public static String withoutString(String base, String remove) {
		remove = remove.toLowerCase();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i < base.length(); i++) {
			if(i + remove.length() <= base.length() && base.substring(i, i + remove.length()).toLowerCase().equals(remove)){
				i += remove.length() - 1;
			} else{
				sb.append(base.charAt(i));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		withoutString("Hello there", "llo");
	}
}
