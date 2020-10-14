package hackerrank.algo;

public class JumpingOnTheClouds {

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[]{1, 1, 1, 0, 1, 1, 0, 0, 0, 0}, 3) == 80);
		System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2) == 92);
		System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0}, 2) == 96);
	}

	// Complete the jumpingOnClouds function below.
	public static int jumpingOnClouds(int[] c, int k) {
		int n = c.length;
		int energy = 100;
		int index = c.length;
		while(index != 0){
			index = (index + k) % n;
			if(c[index] == 1){
				energy -= 2;
			}
			energy--;
		}
		return energy;
	}
}
