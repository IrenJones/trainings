package hackerrank.algo;

import java.util.Arrays;

public class ElectronicsShop {
	public static void main(String[] args) {
		System.out.println(getMoneySpent(new int[]{5}, new int[]{4}, 6) == -1);
		System.out.println(getMoneySpent(new int[]{3,1}, new int[]{5,2,8}, 10) == 9);
	}
	// It should return the maximum total price for the two items within Monica's budget,
	// or -1 if she cannot afford both items.
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int biggestResult = -1;
		for(int i =0; i< keyboards.length; i++){
			for(int j =0; j< drives.length; j++){
				int result = keyboards[i] + drives[j];
				if(result > biggestResult && result <= b){
					biggestResult = result;
				}
			}
		}
		return biggestResult;
	}
}
