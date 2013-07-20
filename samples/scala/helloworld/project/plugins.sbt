// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += Resolver.file("Local Repository", file("/home/jiansen/TAkka-Play20/repository/local"))(Resolver.ivyStylePatterns)

addSbtPlugin("play" % "sbt-plugin" % Option(System.getProperty("play.version")).getOrElse("2.2-SNAPSHOT"))
//addSbtPlugin("play" % "sbt-plugin" % "2.2-SNAPSHOT")
