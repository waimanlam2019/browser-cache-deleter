#!/bin/bash

# Define the path to the JAR file
JAR_PATH="/Users/raylam/eclipse-workspace-new/browser-cache-deleter/target/browser-cache-deleter-0.0.3-SNAPSHOT-jar-with-dependencies.jar"

# Run the JAR file with the main class
java -jar "$JAR_PATH"

# Check if the command was successful
if [ $? -eq 0 ]; then
    echo "Cache deleter ran successfully."
else
    echo "An error occurred while running the cache deleter."
fi
