package leetcode.leetcode_by_topics.bit;

public class DecodeXORedArray {

	public int[] decode(int[] encoded, int first) {
		int[] hid = new int[encoded.length + 1];
		hid[0] = first;
		for (int i = 0; i < encoded.length; i++) {
			int hidden = hid[i] ^ encoded[i];
			hid[i + 1] = hidden;
		}

		return hid;
	}
}
