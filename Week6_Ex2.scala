/********   Alex Frez: Week6 EXERCISE 2:  ********/
package org.apache.spark.examples.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.types.{IntegerType,StringType,StructField,StructType}
import java.io.File

object Week6_Ex2 {
  def main(args: Array[String]): Unit = {
    println("Starting Apache Spark App")
    val spark = SparkSession.builder()
        .appName("Create df from csv file")
        .master("local[*]")
        .getOrCreate() 
    spark.sparkContext.setLogLevel("ERROR") 
// Input Data file location:   
    val csv_file = "C:/spark/data/week7/insurance.csv"
//  Our df (DataFrame) definition:
    val df = spark.read
      .option("header","true")
      .option("inferSchema", "true")
// 1. Here below we Read into df file insurance.csv       
      .csv(csv_file)    
    
    df.printSchema()
    df.show()
    
    df.createOrReplaceTempView("records")
    
    // Once df table have been registered, you can run SQL queries over them.
    println("==============  Result of my Spark SQL Queries:  ===============")    
    // Print All record lines:
//    spark.sql("SELECT * FROM records").collect().foreach(println)     

// 1. Read insurance.csv file 
    println(" ")
    println("1. Read insurance.csv file: ")
    println(s"Read insurance.csv file from =  $csv_file")   
    

// 2. Print the size of .csv file in Number of records
    // Count the Number of records:
    val NRecs = spark.sql("SELECT COUNT(*) FROM records").collect().head.getLong(0)
    println(" ")
    println("2. Print the size: ")
    println(s"Number of records in our .csv file = $NRecs")   
    
// 3. Print sex and count of sex (use group by in sql)
//  val rddFromSql = spark.sql("SELECT key, value FROM records WHERE key < 10")    
//  val Nmen = spark.sql("SELECT COUNT(*) FROM records where sex = 'men'").collect().head.getLong(0)
    println(" ")
    println("3. Print sex and count of sex: ")
    spark.sql("SELECT sex, COUNT(*) FROM records group by sex").collect().foreach(println)       
    
// 4. Filter smoker=yes and print again the sex,count of sex
    println(" ")
    println("4. Print sex and count of sex for Smokers:  ")
    spark.sql("SELECT sex, COUNT(*) FROM records WHERE smoker='yes' group by sex").collect().foreach(println)       
    
// 5. Group by region and sum the charges (in each region), 
//    then print rows by  descending order (with respect to sum)
    println(" ")
    println("5. Group by region and sum the charges descending by sum:  ")
    spark.sql("SELECT region, SUM(charges) FROM records group by region ORDER BY SUM(charges) DESC").collect().foreach(println)       
     
    
    println("===============   EOF   =================")     
     
  }  
}