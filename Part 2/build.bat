@echo off

set build-path=./build
set src-path=./src
set jar-name=Part2.jar
set main-class=Part2

@echo Building %build-path%/%jar-name%

cd %src-path%
javac --release 8 -d ../%build-path%/ *.java

cd ../%build-path%
jar -cvfe %jar-name% %main-class% ./

del *.class /s /f /q

@echo done