mkdir -p src/{main,test}/{resources,scala}
mkdir lib project target

# create an initial build.sbt file
echo 'name := "MyProject"
version := "1.0"
scalaVersion := "2.10.0"' > build.sbt
