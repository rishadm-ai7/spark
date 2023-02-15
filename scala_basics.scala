// Databricks notebook source
// MAGIC %md
// MAGIC ##Scala programming

// COMMAND ----------

// VALUES are immutable

val hello : String = "Hello"

// COMMAND ----------

// VARIABLES are mutable

var hola: String = hello

hola=hello+" World!"

// COMMAND ----------

println(hello,hola)

// COMMAND ----------

//Data Types 

val one : Integer = 1

val value : Boolean = true

val a : Char = 'a'

val num1 : Double = 1.23312

val num2 : Float = 1.1611332743924923f

//(what f does is rounds up the value under floating point aka 7 digits)

val num3 : Long = 12342843

val num4 : Byte = 127

// COMMAND ----------

println("Here is a mess !"+num1+a+value+num2+num4+num3+one)

// COMMAND ----------

//Formatted like printf
println(f"My number is about $num2%.3f")

// COMMAND ----------

//d tells it that its an integer and 05 adds 5 zeroes before it
println(f"Left side with 5 digits padding : $one%05d")

// COMMAND ----------

//difference between s and f is that , f has more formatting options and s doesnt.
println(s"My number is about $one $value")

// COMMAND ----------

var x :Integer = 5
val y : Integer = 3

// COMMAND ----------

// curly braces actually calculate the expression within it before printing it
println(s"I can do operations like ${x+y}")

// COMMAND ----------

//defining a regex

val pattern = """.* ([\d]+).*""".r

// COMMAND ----------

val mysentence :String = "I need 100 documents for this problem"
val pattern(answer)=mysentence

// COMMAND ----------

val answer1=answer.toInt

// COMMAND ----------

print(answer1)

// COMMAND ----------

//write some codes that takes value of pi and doubles it then prints with a string till 3 decimal places

val pi : Float = 3.14159265359f
println(f"The desired value is ${pi*2}%.3f")

// COMMAND ----------

// MAGIC %md
// MAGIC 
// MAGIC ##Flow Control

// COMMAND ----------

//if/else statement

if (1>3) println("Its impossible") else println("World makes sense")

// COMMAND ----------

if (1>3) {
  println("Wait what?")
  println("Wait Really?")
}
else {
  println("Ok this works!")
}

// COMMAND ----------

val num = 2

num match {
  case 1 => println("One")
  case 2 => println("Two")
  case 3 => println("Three")
  case _ => println("Something else")
}

// COMMAND ----------

for (x <- 1 to 4) {
  val squared = x*x
  println(squared)
}

// COMMAND ----------

var x = 10
while (x>=0) {
  println(x)
  x-=1
}

// COMMAND ----------

//do while loop

x=0

do {println(x);x+=1} while (x<10)

// COMMAND ----------

//Fibonacci series

var y=0
var a=1
var z=0
for (i <-1 to 9) {
  println(z);
  z=a+y;
  y=a;
  a=z
}

// COMMAND ----------

// MAGIC %md
// MAGIC 
// MAGIC ##Functions in Scala

// COMMAND ----------

// format def <function name> (parameter name: type...): return type = { }

// COMMAND ----------

def sqit(x: Int) : Int ={
  x*x
}

// COMMAND ----------

sqit(2)

// COMMAND ----------

def sum(y:Int) : Int ={
  y+y
}

// COMMAND ----------

sum(4)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Functions inside functions

// COMMAND ----------

def transformer (x:Int,f:Int=>Int): Int = {f(x)}

// COMMAND ----------

val result = transformer(3,sqit)

// COMMAND ----------

println(result)

// COMMAND ----------

//Doing this without defining sqit function


val result2 = transformer(3,x=>x*x)
println(result2)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Convert to uppercase

// COMMAND ----------

def caps(x: String) : String = {x.toUpperCase}

// COMMAND ----------

println(caps("foo"))

// COMMAND ----------

// MAGIC %md
// MAGIC ##Data Structures using Scala

// COMMAND ----------

//tuples
//immutable lists
//tuples can hold items of different data types, list can't

// COMMAND ----------

val tuple = ("a","b","c",1,true)

println(tuple)

// COMMAND ----------

//indexing
println(tuple._2)

// COMMAND ----------

val kvpair = "a"->"b"

kvpair._2 //gives b ie the value

// COMMAND ----------

//lists 

//Can only contain an item of same kind 

// COMMAND ----------

val shiplist = List("a","b","c","d","e")

// COMMAND ----------

println(shiplist(1))

// COMMAND ----------

println(shiplist.head)//first element

// COMMAND ----------

println(shiplist.tail)//gives all the rest element

// COMMAND ----------

for (ship <-shiplist) {println(ship)} //iterate through the list

// COMMAND ----------

val capped = shiplist.map((ship : String) => {ship.toUpperCase}) //mapping function

for (ship<-capped){println(ship)}

// COMMAND ----------

val number_list = List(1,2,3,4,5)

// COMMAND ----------

val sum = number_list.reduce((x:Int,y:Int)=> x+y) //1+2, then result goes to x, adds y (3) and keeps going

// COMMAND ----------

println(sum)

// COMMAND ----------

//filter stuffs (remove things)

// COMMAND ----------

val no4 = number_list.filter((x:Int) => x!=4)

val no3 = number_list.filter(_!=3) //shorter version of it

// COMMAND ----------

println(no4)

// COMMAND ----------

//concatinate list 

// COMMAND ----------

val nums = List(6,7,8,9,10)

// COMMAND ----------

val num1 = number_list++nums

// COMMAND ----------

println(num1)

// COMMAND ----------

val a=number_list.reverse

// COMMAND ----------

a.sorted

// COMMAND ----------

val not_distinct = number_list++number_list

// COMMAND ----------

val distinctlist = not_distinct.distinct

// COMMAND ----------

println(number_list.max,number_list.min,number_list.sum) //to get the sum,min and max in a list

// COMMAND ----------

  no4.contains(4) //doesn't contain 4 in the given list

// COMMAND ----------

//maps also called dictionaries

//data types needs to be consistant within each key value pair

// COMMAND ----------

val shipmap = Map("Kirk"->"Enterprise","Picard"->"Enterprise-D","Sisko"->"Deep Space Nine","Janeway"->"Voyager")

// COMMAND ----------

println(shipmap("Janeway"))

// COMMAND ----------

println(shipmap.contains("Archer"))

// COMMAND ----------

//exception handling

// COMMAND ----------

val archership = util.Try(shipmap("Archer")) getOrElse "Unknown"

// COMMAND ----------

// Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
// modula operator, like other languages, is %, which gives you the remainder after division. For example, 9% 3 = 0
// because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
// one as you go. Then, do it again by using a filter function on the list instead.

// COMMAND ----------

val num20 = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

// COMMAND ----------

val rdivby3 = for(x <- num20 if (x % 3 == 0)) yield x
println(rdivby3)

// COMMAND ----------

val divby3 = num20.filter(_%3==0)
