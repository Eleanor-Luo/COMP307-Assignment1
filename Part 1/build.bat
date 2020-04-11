@echo off

set build-path=./build
set src-path=./src
set jar-name=Part1.jar
set main-class=Part1

@echo Building %build-path%/%jar-name%

cd %src-path%
javac -d ../%build-path%/ *.java

cd ../%build-path%
jar -cvfe %jar-name% %main-class% ./

del *.class /s /f /q

@echo done