head(airquality)
x<-data.frame(airquality)
x
dim(x)
sapply(x,class)
which(is.na(x))
sum(is.na(x))
x1<-as.data.frame(x)
for(j in 1:ncol(x)){
  x1[,j]<-ifelse(is.na(x[,j]),mean(x[,j],na.rm = TRUE),x[,j])
}
head(x1)
