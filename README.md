# 🚀 Cucumber-TestNG-Hybrid-Framework

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java](https://img.shields.io/badge/Java-21-blue)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![Maven](https://img.shields.io/badge/Maven-3.9.9-orange)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-success)
![Allure](https://img.shields.io/badge/Allure-Reports-critical)

## 📌 Project Overview:

**Cucumber-TestNG-Hybrid-Framework** is a scalable and maintainable **UI test automation framework** built on top of a **hybrid BDD architecture**. It leverages **Cucumber**, **TestNG**, **Excel-based data driving**, **Allure & Cucumber reporting**, and industry-standard practices like reusable action layers, hooks, and modular **POM**.

Ideal for real-world applications where robust automation, data-driven flexibility, and BDD readability are required — with seamless test executions and integrations.

---

## 🧰 Technologies Used:

- ☕ Java 21  
- 🌐 Selenium WebDriver  
- 🥒 Cucumber & Cucumber-TestNG  
- 🧪 TestNG  
- 📄 Apache POI (Excel-based Data)  
- 📈 Allure & Cucumber Reports  
- 🪵 Log4j
- 🧪 TestNG Listeners 
- 🔧 Maven  

---

### 🔨 Implemented Features:

> The following core functionalities were **designed and developed from scratch** as part of the framework implementation:

✅ **Custom WebDriver Factory using Singleton Design Pattern**  
Ensures a single driver instance per thread to optimize browser session handling.

📦 **Page Object Model (POM) Structure**  
Each page has a dedicated class with clean and modular method definitions.

🥒 **Step Definitions Layer for Feature Files**  
Gherkin steps are mapped to reusable Java methods, improving clarity and maintainability.

📊 **Excel + Scenario Outline Data Support**  
Custom utility injects test data from Excel, with flexibility to also use Scenario Outlines.

🔁 **Reusable Action Layer**  
  Developed a centralized `ElementActions` class to perform all UI operations like clicks, inputs, waits, alert handling, frame switching, and date picker logic.

🧪 **TestNG-Cucumber Integration with Runner Class**  
Uses `@CucumberOptions` in a runner class to allow execution via `testng.xml`.

🪝 **Cucumber Hooks and Tag Support**  
Before/After hooks manage setup/cleanup; tags enable grouped execution like @Smoke, @Regression.

🔄 **Scenario  Failure Handling**  
Captures screenshots and logs test failures using custom scenario execution status method .

⚙️ **Externalized Configurations via Properties File**  
Environment variables like browser, base URL, and timeouts are easily configurable.

🧪 **Suite and Parallel Execution Support**  
testng.xml allows batch runs and multi-browser testing using parallel threads.

🌍 **Cross-Browser & Headless Execution Support**  
Supports both UI and headless runs in Chrome and Firefox for CI/CD adaptability.

🪵 **Log4j Logging Integration**  
Provides structured logging for debugging with INFO, DEBUG, ERROR level messages.

📈 **Allure & Cucumber Report Integration**  
Generates clean HTML reports with steps, logs, and failed screenshots for traceability.

▶️ **One-Click Execution via Batch File**  
Run all tests locally or via CI by simply executing the `.bat` file.

---

## ▶️ How To Run the Project:

### ✅ Prerequisites:

- Install **Java JDK 21**
- Install **Apache Maven**
- Install **Allure Commandline** (for generating Allure Reports)
- Set environment variables: `JAVA_HOME`, `MAVEN_HOME`, `ALLURE_HOME`

## Steps:
Step 1: Clone the Repository
https://github.com/Gangadhar2821/Cucumber-TestNG-Hybrid-Framework.git

Step 2: Navigate to the project directory and install dependencies and run 
"mvn clean install" command

Step 3: Run the project using the batch file  
        "run_tests.bat" (click on the batch file)


---
## 📸 Reports & Logs:
📈 Allure Reports are generated under allure-results/ after test execution and can be viewed by  using the below CLI Command:

   allure serve "allure-results / directory path "
   
📗 Cucumber HTML Reports with timestamps are also generated under the target/cucumber-reports directory.

🪵 Logs are captured via Log4j under the logs/ directory for every test run.

📷 Screenshots on test failure are saved in the errorshots/ folder for easier debugging.

---

## 👨‍💻 Developed By:  
### Gangadhar B
💼 Software Engineer

📧 gangadhar2821@gmail.com

🔗 XXXX 


---
## 💡 Future Enhancements:
🔧 Integration with Jenkins CI for Continuous Integration & Scheduling.

---
