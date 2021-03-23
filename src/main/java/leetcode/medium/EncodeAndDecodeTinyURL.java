package leetcode.medium;

import java.util.Base64;

public class EncodeAndDecodeTinyURL {

	static String BASE_HOST = "http://tinyurl.com/";

	public static void main(String[] args) {
		EncodeAndDecodeTinyURL solution = new EncodeAndDecodeTinyURL();
		String s = solution.encode("https://leetcode.com/problems/design-tinyurl");
		solution.decode(s);
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		return BASE_HOST + Base64.getUrlEncoder().encodeToString(longUrl.getBytes());
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return new String(Base64.getUrlDecoder().decode(shortUrl.substring(BASE_HOST.length())));
	}
}
