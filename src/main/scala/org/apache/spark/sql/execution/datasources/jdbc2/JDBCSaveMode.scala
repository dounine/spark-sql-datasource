package org.apache.spark.sql.execution.datasources.jdbc2

object JDBCSaveMode extends Enumeration {

  type JDBCSaveMode = Value

  val Append = Value("Append")
  val Overwrite = Value("Overwrite")
  val ErrorIfExists = Value("ErrorIfExists")
  val Ignore = Value("Ignore")
  val Update = Value("Update")

}
