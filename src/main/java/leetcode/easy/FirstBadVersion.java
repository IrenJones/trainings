package leetcode.easy;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int l = 1;
		int r = n;
		int medium;
		while(l < r){
			medium = l + (r-l)/2;
			if(isBadVersion(medium)){
				r = medium;
			} else{
				l = medium + 1;
			}
		}
		return l;
	}

	public boolean isBadVersion(int v){
		return true;
	}
}
