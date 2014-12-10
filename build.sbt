name := "adschela"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,filters,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
    "net.coobird" % "thumbnailator" % "0.4.3",
    "commons-io" % "commons-io" % "2.1",
    "mysql" % "mysql-connector-java" % "5.1.18",
    "org.hibernate" % "hibernate-entitymanager" % "4.2.7.Final"
)     

resolvers +=  Resolver.url("Edulify Repository", url("https://edulify.github.io/modules/releases/"))(Resolver.ivyStylePatterns)


play.Project.playJavaSettings
