n<-as.integer(readline(prompt('enter the number of students: ')))
usn<-vector(mode='character',length=n)
name<-vector(mode='character',length=n)
marks<-vector(mode='integer',length=n)
print('enter the student usn name and marks : ')
for(i in 1:n) {
  usn[i]<-as.character(readline())
  name[i]<-as.character(readline())
  marks[i]<-as.integer(readline())
}
stud<-data.frame(usn,name,marks)
print(stud)
print('enter the student age : ')
age<-vector(mode='integer',length=n)
for(i in 1:n) {
  age[i]<-as.integer(readline())
}
table<-cbind(stud,age)
for (i in 1:n) {
  if((table$age[i]<20)&&(table$marks[i]>25))
    print(table[i,])
}
print(table)
  

