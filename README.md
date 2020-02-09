# LearnSelenium

Framework will be developed on top of : 

Maven + Cucumber Java + Selenium Webdriver

### To try it out follow these steps : 
- make sure maven is installed on your machine where you are running this setup
- Try out [sdkman](https://sdkman.io/) utility with which you can install maven and lot more tools very easily on your computer
- Next is clone this repo `git clone https://github.com/devAvengersnl/LearnSelenium.git`
- `mvn clean verify`
- `mvn install`
- `mvn test`

### For latest versions of depedencies 

- Do a git checkout for branch cuc5-junit4-selenium4 by command : `git checkout cuc5-junit4-selenium4`
- This branch has following features: 
    - cucumber 5 with parallel test execution capability
    - integration with [allure](https://docs.qameta.io/allure/#_junit_4) reporting tool
    - junit4
    - works on Java JDK 8+ and maven 3.6.0+
- To see in action run command
    - `mvn clean install` - which will execute the tests in parallel
    - `mvn allure:serve` - which will publish the test results 
    

     
 