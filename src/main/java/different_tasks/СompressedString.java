package different_tasks;

public class СompressedString {
	public static void main(String[] args) {
		System.out.println(compressedString("abaabbbc"));
		System.out.println(compressedString("abc"));
	}

	public static String compressedString(String message) {
		StringBuilder s = new StringBuilder();
		char current;
		if (message.length() > 0) {
			char prev = message.charAt(0);
			int count = 1;
			for (int i = 1; i < message.length(); i++) {
				current = message.charAt(i);
				if(current == prev){
					count++;
				} else {
					addValueToString(s, prev, count);
					prev = current;
					count = 1;
				}
			}
			addValueToString(s, prev, count);
		}
		return s.toString();
	}

	public static void addValueToString(StringBuilder s, char c, int count){
		s.append(c);
		if(count > 1){
			s.append(count);
		}
	}
}
