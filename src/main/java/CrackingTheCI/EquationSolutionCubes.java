package CrackingTheCI;

import lombok.val;
import scala.tools.nsc.typechecker.PatternMatching;

public class EquationSolutionCubes {

	// a^3 + b^3 = c^3 + d^3
	// Find all solutions from 1 under 1000
	public static void main(String[] args) {
		/*
			a^3 = c^3 + d^3 - b^3. Left and right parts should be positive and be greater or equal than 1.
		 */
		EquationSolutionCubes solution = new EquationSolutionCubes();
		final int N = 100;
		solution.bruteForce(N);
		solution.bruteForceABitBetter(N);
	}
	// Time complexity - O(n^4)
	public void bruteForce(int n){
		int count = 0;
		for(int a = 1; a < n; a++) {
			for(int b = 1; b < n; b++) {
				for(int c=1; c < n; c++) {
					for(int d = 1; d < n; d++) {
						if(a*a*a + b*b*b == c*c*c + d*d*d) {
							//System.out.println(a + "   " + b + "   " + c + "   " + d);
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

	// Time complexity - O(n^3)
	public void bruteForceABitBetter(int n){
		int count = 0;
		for(int a = 1; a < n; a++) {
			for(int b = 1; b < n; b++) {
				for(int c = 1; c < n; c++) {
					int a3 = a*a*a;
					int b3 = b*b*b;
					int c3 = c*c*c;
					int d3 = a3 + b3 - c3;
					double d = Math.round(Math.pow(d3, 1/3.0));
					if (d > 0 && d < n && (d3 - Math.pow(d, 3) == 0)) {
						//System.out.println(a + "   " + b + "   " + c + "   " + d);
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
