@echo off

:: Define the path to the JAR file
set JAR_PATH=C:\Users\USER\eclipse-workspace\browser-cache-deleter\target\browser-cache-deleter-0.0.3-SNAPSHOT-jar-with-dependencies.jar

:: Run the JAR file with the main class
java -jar "%JAR_PATH%"

:: Check if the command was successful
if %ERRORLEVEL% EQU 0 (
    echo Cache deleter ran successfully.
) else (
    echo An error occurred while running the cache deleter.
)
