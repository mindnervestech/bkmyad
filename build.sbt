name := "adschela"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,filters,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
    "mysql" % "mysql-connector-java" % "5.1.18",
    "org.hibernate" % "hibernate-entitymanager" % "4.2.7.Final"
)     

play.Project.playJavaSettings
