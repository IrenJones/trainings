package different_tasks.sdet;

public class FibonacciSeries {
	public static void main(String[] args) {
		printFibonacciSeries(10);
		System.out.println();
		printFibonacciSeriesAnother(10);
		System.out.println();
		System.out.println(tailRecursion(10));
	}

	private static void printFibonacciSeries(int n) {
		if(n > 0) {
			int[] values = new int[n];
			int i = 0;
			while(i< n && i<2){
				values[i] = 1;
				i++;
			}
			while (i<n){
				values[i] = values[i-2] + values[i-1];
				i++;
			}

			for(int val: values){
				System.out.print(val + " ");
			}
		}
	}

	private static void printFibonacciSeriesAnother(int n) {
		int prev = 0;
		int current = 1;
		for(int i=1; i <= n; i++){
			int tmp = prev + current;
			prev = current;
			current = tmp;
			System.out.print(prev + " ");
		}
	}

	private static int tailRecursion(int n){
		if (n <= 2){
			return 1;
		}
		return tailRecursion(n-1) + tailRecursion(n-2);
	}
}
