package asana.test

object SlickCodeGenerator extends App{
  val profile = "slick.jdbc.MySQLProfile"
  val jdbcDriver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://asana-test-db-1.c964qs46yibj.us-west-2.rds.amazonaws.com:3306/asana_test"
  val pkg = "asana.test"
  val outputFolder = "./src/main/scala"
  val user = "admin"
  val password = ""

  slick.codegen.SourceCodeGenerator.main(
    Array(profile, jdbcDriver, url, outputFolder, pkg, user, password)
  )
}
