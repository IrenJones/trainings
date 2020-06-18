package different_tasks;

import java.util.List;

public class ArrangingCoins {

	public static void arrangeCoins(List<Long> coins) {
		int height;
		for(int i=0; i< coins.size(); i++){
			height = (int)(-1 + Math.sqrt(1 + 8*coins.get(i)))/2;
			System.out.println(height);
		}
	}
}
