# Pre-requisite to run the project

1- System should have JDK1.8 or Higher version of java

2- Install Cucumber Eclipse plugin from Help > Eclipse Marketplace > Fine

3- Eclipse should have Maven configured

4- Eclipse should have TestNg configured

5- Right Click on project > Build path > Configure Build path > libraries > Add JDK and TestNG library > select order and export Tab > check JRE , Maven Dependencies , TestNg 

##  How to Run the Test

1 you need to run the testng.xml file present at project level. It call indirectly TestRunner class

2 Change the tags as per your execution  

## Highlights

1- Added explicit wait at element level.
2- Exposed properties file to update/add locators, report configuration, email configuration

## Improvements

1- Possible to automate other count down timers ex: Special Timers
2- Adding other TestNg Listeners like IReporter
3- Capturing screenshot on failure
4- Adding more utility classes to handle reading data from excel,csv file etc..
5- Adding separate class for verification (soft & Hard assertion)
6- Adding utility class if required Data base verification.
7- Driver .exe files either referred to explicitly file or we can use webdriver manager class.

