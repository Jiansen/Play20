logLevel := Level.Warn

resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.1.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.0.1")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0")
