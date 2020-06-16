-- Databricks notebook source
-- MAGIC %fs ls

-- COMMAND ----------

-- MAGIC %fs ls dbfs:/FileStore/tables

-- COMMAND ----------

-- MAGIC %scala
-- MAGIC 
-- MAGIC // WEEK7 EXERCISE 3: (Migrate Exercise 2 from week 6 to Databricks) 
-- MAGIC 
-- MAGIC // 1. Read insurance.csv file 
-- MAGIC val insurance = spark.read.format("csv")
-- MAGIC .option("header", "true")
-- MAGIC .option("inferSchema", "true")
-- MAGIC .load("/FileStore/tables/insurance.csv")
-- MAGIC display(insurance)

-- COMMAND ----------

-- MAGIC %scala
-- MAGIC 
-- MAGIC // 2. Print the size of .csv file in Number of records
-- MAGIC     // Count the Number of records:
-- MAGIC     val NRecs = spark.sql("SELECT COUNT(*) FROM insurance").collect().head.getLong(0)
-- MAGIC     println(" ")
-- MAGIC     println("2. Print the size: ")
-- MAGIC     println(s"Number of records in our .csv file = $NRecs") 

-- COMMAND ----------

-- MAGIC %scala
-- MAGIC // 3. Print sex and count of sex (use group by in sql)
-- MAGIC     println(" ")
-- MAGIC     println("3. Print sex and count of sex: ")
-- MAGIC     spark.sql("SELECT sex, COUNT(*) FROM insurance group by sex").collect().foreach(println)

-- COMMAND ----------

-- MAGIC %sql
-- MAGIC -- mode "FAILFAST" will abort file parsing with a RuntimeException if any malformed lines are encountered
-- MAGIC CREATE TEMPORARY TABLE insurance2
-- MAGIC USING csv
-- MAGIC OPTIONS (path "/FileStore/tables/insurance.csv", header "true", mode "FAILFAST")

-- COMMAND ----------

-- 3. Print sex and count of sex (use group by in sql)
select sex, count(*) from insurance2 group by 1

-- COMMAND ----------

-- MAGIC %scala
-- MAGIC // 4. Filter smoker=yes and print again the sex,count of sex
-- MAGIC     println(" ")
-- MAGIC     println("4. Print sex and count of sex for Smokers:  ")
-- MAGIC     spark.sql("SELECT sex, COUNT(*) FROM insurance WHERE smoker='yes' group by sex").collect().foreach(println) 

-- COMMAND ----------

-- MAGIC %scala
-- MAGIC // 5. Group by region and sum the charges (in each region), 
-- MAGIC //    then print rows by  descending order (with respect to sum)
-- MAGIC     println(" ")
-- MAGIC     println("5. Group by region and sum the charges descending by sum:  ")
-- MAGIC     spark.sql("SELECT region, SUM(charges) FROM insurance group by region ORDER BY SUM(charges) DESC").collect().foreach(println)       
-- MAGIC      
