import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd._

import scala.Ordering


object tweet {


  val conf = new SparkConf()
    .setAppName("User mining")
    .setMaster("local[*]")

  val sc = new SparkContext(conf)


  var pathToFile = "/home/student/navya/rt.json"

  def main(args: Array[String]) {

    val tweets =
      sc.textFile(pathToFile).mapPartitions(TweetUtils.parseFromJson(_))
    val tweets_user = tweets.map(x=> (x.user, x)).groupByKey()
    tweets.take(0).foreach{case (tweet) => println(tweet.user)}
    val num = tweets_user.map(x => (x._1, x._2.size))
    val sortedUsersByNumTweets = num.sortBy(_._2, ascending = false)
    sortedUsersByNumTweets.take(10).foreach(println)

  }
}

import com.google.gson._

object TweetUtils {
  case class Tweet (
                     id : String,
                     user : String,
                     userName : String,
                     text : String,
                     place : String,
                     country : String,
                     lang : String
                   )


  def parseFromJson(lines:Iterator[String]):Iterator[Tweet] = {
    val gson = new Gson
    lines.map(line => gson.fromJson(line, classOf[Tweet]))
  }
}
