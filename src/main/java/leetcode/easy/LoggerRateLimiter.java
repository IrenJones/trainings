package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	public static void main(String[] args) {
		Logger logger = new Logger();

		// logging string "foo" at timestamp 1
		System.out.println(logger.shouldPrintMessage(1, "foo")); // true

		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2, "bar"));// true

		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3, "foo"));//false

		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8, "bar"));//false

		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10, "foo"));//false

		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11, "foo"));//true
	}
}

class Logger {

	Map<String, Integer> messages;
	int limiter = 10;

	public Logger() {
		this.messages = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String s) {
		if(this.messages.containsKey(s)){
			if(timestamp - this.messages.get(s) < limiter){
				return false;
			}
		}
		this.messages.put(s, timestamp);
		return true;
	}
}
