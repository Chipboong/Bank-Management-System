@echo off
call mvn clean package
java -jar target\bank-1.0-SNAPSHOT.jar
pause
 