package hackerrank.algo;

public class SuperReducedString {

	public static void main(String[] args) {
		System.out.println(superReducedString("aa").equals("Empty String"));
		System.out.println(superReducedString("aabbc").equals("c"));
		System.out.println(superReducedString("aabccd").equals("bd"));
		System.out.println(superReducedString("abccd").equals("abd"));
		System.out.println(superReducedString("abcc").equals("ab"));
		System.out.println(superReducedString("kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuerhhsanpdtmrzibswswzjjbjqytgfewiuu")
				.equals("kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuersanpdtmrzibswswzbjqytgfewi"));
	}

	static String superReducedString(String s) {
		while(true){
			if(s.length() < 1){
				return "Empty String";
			} else if (s.length() == 1){
				return s;
			}
			boolean notChanged = true;
			for(int i = 1; i< s.length(); i++){
				if(s.charAt(i-1)== s.charAt(i)){
					notChanged = false;
					s = s.substring(0, i-1) + s.substring(i+1);
					if( i + 1 > s.length()) {
						i=0;
					}
				}
			}
			if (notChanged){
				return s;
			}
		}
	}
}
