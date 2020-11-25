![](https://github.com/dounine/spark-sql-datasource/workflows/Publish%20package%20to%20the%20Maven%20Central%20Repository/badge.svg) ![](https://img.shields.io/github/license/dounine/spark-sql-datasource)

## Useage
Depend on
```
<dependency>
    <groupId>com.dounine</groupId>
    <artifactId>spark-sql-datasource</artifactId>
    <version>1.0.4</version>
</dependency>

```

example
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
          "duplicateIncs" -> "indicator",
          "showSql" -> "true"
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
