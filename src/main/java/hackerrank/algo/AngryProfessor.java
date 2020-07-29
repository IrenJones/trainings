package hackerrank.algo;

public class AngryProfessor {

	static String angryProfessor(int k, int[] a) {
		int countArrivedInTime = 0;
		for(int i =0; i< a.length; i++){
			if (a[i] <= 0){
				countArrivedInTime++;
			}
		}
		return countArrivedInTime >= k ? "NO": "YES";
	}
}
