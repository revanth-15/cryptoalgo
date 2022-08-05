import scala.io.Source
import scala.collection.mutable.ArrayBuffer
object minmaxobj{
	def main(args: Array[String]):Unit={
		var arr=new ArrayBuffer[Int]()
		print("number of elements : ")
		val n=scala.io.StdIn.readInt()
		println("enter array elements :")
		for(i<- 1 to n)
			arr+=scala.io.StdIn.readInt()
		println(arr)
		val t=minmax(arr)
		println("Largest number : ",t._1)
		println("Smallest number : ",t._2)
	}
	def minmax(arr:ArrayBuffer[Int]):(Int,Int)={
		var min:Int= 999
		var max:Int= -999
		for(i<-arr)
		{
			if(i<min) min=i
			else if(i>max) max=i
		}
		(max,min)
	}
}
