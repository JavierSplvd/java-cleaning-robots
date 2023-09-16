# Define the main class for your Java application
MAIN_CLASS = com.javier.App

# Default target: display help message
help:
	@echo "Java Project Makefile"
	@echo "---------------------"
	@echo "Available targets:"
	@echo "  help     - Display this help message"
	@echo "  build    - Build the Java project"
	@echo "  run      - Run the Java application"
	@echo "  test     - Run unit tests"
	@echo "  clean    - Clean build artifacts"
	@echo ""

# Build the Java project using Maven
build:
	mvn clean install

# Run the Java application
run:
	java -cp target/cleaning-robots-1.0-SNAPSHOT.jar $(MAIN_CLASS)

# Run unit tests using Maven
test:
	mvn test jacoco:report

# Clean build artifacts
clean:
	mvn clean

# Ensure that targets not conflicting with file names work
.PHONY: help build run test clean
