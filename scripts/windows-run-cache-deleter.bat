@echo off

:: Define the path to the JAR file
set JAR_PATH=path\to\browser-cache-deleter-0.0.1-SNAPSHOT.jar

:: Run the JAR file with the main class
java -jar "%JAR_PATH%"

:: Check if the command was successful
if %ERRORLEVEL% EQU 0 (
    echo Cache deleter ran successfully.
) else (
    echo An error occurred while running the cache deleter.
)
