## Usage
Spark-sql-datasource jdbc2

## Demo
```
spark.sql("select name,time,indicator from log")
      .write
      .format("org.apache.spark.sql.execution.datasources.jdbc2")
      .options(
        Map(
          "savemode" -> JDBCSaveMode.Update.toString,
          "driver" -> "com.mysql.jdbc.Driver",
          "url" -> "jdbc:mysql://localhost:3306/ttable",
          "user" -> "root",
          "password" -> "root",
          "dbtable" -> "test",
          "useSSL" -> "false",
          "duplicateIncs" -> "indicator"
        )
      ).save()
```
will be create the follow sql
```
INSERT INTO test (`name`,`time`,`indicator`) VALUES (?,?,?) ON DUPLICATE KEY UPDATE `name`=?,`time`=?,`indicator`=`indicator`+?
```
if option duplicateIncs unset will be create the follow sql
```
INSERT INTO test (`name`,`time`,`indicator`) VALUES (?,?,?) ON DUPLICATE KEY UPDATE `name`=?,`time`=?,`indicator`=?
```