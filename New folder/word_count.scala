import scala.io.Source

object wordcountobj{
def main(args: Array[String]){
	if(args.length!=1)
	{
		System.err.println("error")
		System.exit(1)
	}
val filename=args(0)
val wc=scala.collection.mutable.Map[String,Int]()
for(line<-Source.fromFile(filename).getLines)
for(word<-line.split(" "))
wc(word)=if(wc.contains(word)) wc(word)+1 else 1
for ((k,v)<-wc) printf("%s --> %d\n",k,v)		
	}
}
