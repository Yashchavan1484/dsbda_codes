import org.apache.spark.sql.SparkSession
object WordCount {
def main(args: Array[String]): Unit = {
val spark = SparkSession.builder()
.appName("Word Count Example")
.master("local[*]")
.getOrCreate()
val sc = spark.sparkContext
val data = sc.textFile("C:\\spark-proj\\input.txt")
val counts = data
.flatMap(_.split(" "))
.map((_,1))

.reduceByKey(_+_)
counts.collect().foreach(println)
spark.stop()
}
}