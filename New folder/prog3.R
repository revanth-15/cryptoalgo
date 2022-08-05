data()
head(mtcars)
r<-nrow(mtcars)
c<-ncol(mtcars)
r
c
aut<-as.integer(0)
man<-as.integer(0)
x<-data.frame(mtcars)
x
for (i in 1:r){
  ifelse(x$am[i]==0,aut<-aut+1,man<-man+1)
}
ifelse(aut>man,"automatic more","manual more")
with(mtcars,scatter.smooth(hp,wt))
am<-as.integer(x$am)
cyl<-as.integer(x$cyl)
vs<-as.integer(x$vs)
newmtc<-data.frame(am,cyl,vs)
newmtc
for (i in 1:r) {
  if(newmtc$cyl[i]<5)
    print(newmtc[i,])
}

