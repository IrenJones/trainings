package leetcode.easy;

public class IPAddress {

	public static void main(String[] args) {
		System.out.println(defangIPaddr("255.100.50.0"));
	}

	public static String defangIPaddr(String address) {
		return address.replaceAll("\\.", "[.]");
	}
}
