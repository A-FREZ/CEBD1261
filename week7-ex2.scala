// Databricks notebook source
// Weex7 Exercise 2:

// Generate a list from 1 to 45 :
	var list_45 = List.range(1, 46)

// W7 Ex2-1A) Then apply filter to compute the Sum of the numbers divisible by 4 :
	var divby4 = list_45.filter( (x: Int) => x%4 == 0 )
	var sumdivby4 = divby4.reduce( (x: Int, y: Int) => x + y)

// COMMAND ----------

// W7 Ex2-1B) Sum of the squares of the numbers divisible by 3 and less than 20 :
    var divby3 = list_45.filter(_ % 3 == 0)
  	var div3lt20 = divby3.filter(_ < 20)
var sq_from0 = List.tabulate(7)(n => (n*3)*(n*3))
var sq_div3lt20 = sq_from0.tail
var SUM_sq_div3lt20 = sq_div3lt20.reduce( (x: Int, y: Int) => x + y)

// COMMAND ----------

// W7 Ex2-2) Write a Max_function that picks the max of two numbers and 
  // Max_Dbl function picks the max of two Double numbers:
  def Max_Dbl (x:Double,y:Double): Double={
  	if (x > y)	return (x)
  				else	return (y)}

  val a = 0.3                                     
  val b = 0.1 + 0.2                               //> b  : Double = 0.30000000000000004
  Max_Dbl(a, b)                           //> 0.30000000000000004
//Max_Dbl function Also work properly when precision is small. OK


// COMMAND ----------

// Write another get_max function to call the first one with inputs.
  def Get_Max (x: Double, y:Double, f: (Double,Double)
      => Double) : Double = {f(x,y)}
   /* function Get_Max calls max_Dbl with 2 inputs, OK  */
  val MaxVal = Get_Max (a,b, Max_Dbl)
