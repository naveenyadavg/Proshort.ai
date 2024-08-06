# Proshort.ai-Web

## Cucumber BDD Framework

This repository contains a basic REST API testing framework developed using the Rest-Assured library for Java.

## Prerequisites

1. Java JDK (version 11 or higher)
2. Maven (for managing dependencies) - refer to the pom.xml

## Framework Details

1. Dependencies: Refer to the pom.xml for the list of dependencies and any other required libraries.

## Folder Structure

1. Feature Files: Located at 'ps-automation-test-cases-fe/src/test/java/Features'.
   These files contain scenarios written in Gherkin language.

2. Step Definitions: Located at 'ps-automation-test-cases-fe/src/test/java/StepDefinitions'.
   These files contain step definitions for all the scenarios in feature files.

3. Page Files: Located at 'ps-automation-test-cases-fe/src/test/java/Pages'.
   These files contain methods defining actions on different pages of the application under test.

4. Support Files: Located at 'ps-automation-test-cases-fe/src/test/java/Supports'.
   Responsible for storing constant variables, reading properties files, and storing common methods in webDriverHelper.

5. Settings: Configuration file located at 'config/setting.properties'.
   Stores URLs, browser configurations, usernames, passwords, and other settings used in tests.

6. Runner Class: Test runner class for executing scenarios and methods using tags.
   Example: TestRunner.java

7. TestData: Video files and images are stored here to be passed into the request body while sending requests.

8. Browser Creation: Located at 'ps-automation-test-cases-fe/src/test/java/Supports/BrowserCreation'.
   Here, we declare the browsers, whether to run the script in headless mode or not, and specify which browser to run.

## How to Run

1. Via Runner Class:
   • We can run tests through the runner class by changing tags (e.g., tags = "@Sanity and @Admin").

## Test Data

1. All external files are stored here; we can access and read from these files.

## Changes to be Made

1. Settings.properties - for changing email IDs, passwords, URLs, etc.
2. Constants - All hardcoded values are stored in this file.
3. Features - If we want to add any data types, we can add them in the feature file under the respective feature.

### Contribution Guidelines

1. Write the scenarios in the feature file using Gherkin language.
2. For the steps you have written, create a step definition in respective feature related step file.
3. In the step definition:
    - Use the Page Object Model (POM) to create methods in the page file.
    - Declare all the XPaths, methods, and actions in the page file.
