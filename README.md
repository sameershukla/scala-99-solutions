# My Scala99 Solutions

1. Created project simply using sbt, execute the script sbtDirStr.sh. SBT uses the same
directory structure as Maven, same structure like src/main/scala or src/main/resources etc.

2. Manually create the plugins.sbt file and add 
   addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
   
3. Execute sbt eclipse and import project in eclipse.


# To test the problems Execute the Test cases, written as FunSuite using ScalaTest