package com.fred1900.lop.base.spark;

import scala.Tuple2;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCount {

	private static final Pattern SPACE = Pattern.compile(" ");

	@SuppressWarnings({ "serial", "resource" })
	public static void main(String[] args) throws Exception {

		String filePath = "/Users/andpay/Downloads/spark_word_count";
		SparkConf sparkConf = new SparkConf().setMaster("localhost").setAppName("JavaWordCount");
		JavaSparkContext ctx = new JavaSparkContext(sparkConf);
		JavaRDD<String> lines = ctx.textFile(filePath, 1);

		JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			public Iterable<String> call(String s) {
				Iterable<String> value = Arrays.asList(SPACE.split(s));
				return value;
			}
		});

		JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
			public Tuple2<String, Integer> call(String s) {
				return new Tuple2<String, Integer>(s, 1);
			}
		});

		JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});

		List<Tuple2<String, Integer>> output = counts.collect();
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}
		ctx.stop();
	}

}
