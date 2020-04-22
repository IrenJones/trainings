package statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solutions {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.valueOf(scan.nextLine());

		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for(int i = 0; i< n; i++){
			Integer v = Integer.valueOf(scan.nextInt());
			if(map.containsKey(v)){
				map.put(v, map.get(v) + 1);
			} else{
				map.put(v, 1);
			}
			sum+=v;
			list.add(v);
		}

		// mean
		System.out.printf("%.1f\n", 1.0*sum/n);

		//
		double meridian = 0;
		Collections.sort(list);
		if(n%2 == 0){
			meridian = (list.get(n/2-1) + list.get(n/2))/2.0;
		}else{
			meridian = list.get(n/2);
		}
		System.out.printf("%.1f\n", 1.0*meridian);

		// mode
		int mode = 0;
		int count = 0;
		boolean flag = false;
		for(Map.Entry<Integer, Integer> e: map.entrySet()){
			if(false){
				mode = e.getKey();
				count = e.getValue();
				flag = true;
			}
			if(count < e.getValue()){
				mode = e.getKey();
				count = e.getValue();
			}
			if(count == e.getValue() && mode > e.getKey()){
				mode = e.getKey();
			}
		}
		System.out.println(mode);
	}
}
