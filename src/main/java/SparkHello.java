import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class SparkHello {
	public static void main(String[] args) {

		SparkConf sparkConf = new SparkConf()
				.setAppName("example")
				.setMaster("local");

		JavaSparkContext ctx = new JavaSparkContext(sparkConf);

		JavaRDD<Integer> nums = ctx.parallelize(Arrays.asList(1, 2, 3, 4));
		nums.map(x -> x * x)
				.collect()
				.forEach(System.out::println);
	}
}
