@echo off
REM Generate timestamp
for /f %%i in ('powershell -Command "Get-Date -Format yyyy.MM.dd_HH.mm.ss"') do set timestamp=%%i

REM Navigate to project directory
cd /d "D:\Automation_Redefined\CogmentocrmWeb_BDD"

REM Run Maven with dynamic plugin argument
mvn test -Dcucumber.plugin="pretty,html:target/cucumber-reports/report_%timestamp%.html,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"

pause


