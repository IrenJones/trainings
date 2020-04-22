package apache.commons.examples;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionUtilsExamples {
	public static void main(String[] args) {
		arrayToArrayList(new Integer[]{1, 2, 3});
	}

	public static List<Integer> arrayToArrayList(Integer src[]){

		List<Integer> list;

		// 1. As list
		list = Arrays.asList(src);
		list = new ArrayList<Integer>();
		// 2. Collections - adding to empty collection
		Collections.addAll(list, src);

		// 3. Apache Commons
		CollectionUtils.addAll(list,src);

		return list;
	}
}
