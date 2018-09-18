# Job parser using Github Jobs API

The objective of this application is to extract a list of jobs filtered by city and the type of programming languages 
and show the percentage of jobs taht are full-time, part-time or otherwise.

## Getting Started

1. Download/Clone the project from Github into your local repository
2. The application is built using Java and it uses Maven to handle any dependencies.
3. You can also run the application on the command line using the following steps.
 - You should first download Maven onto your system
 - Navigate to the directory that contains the required pom file
 - Run the following command to download all dependencies,compile project and generate target folder
  ```
 mvn compile
  ```
  - To run the project, type the following command
  ```
  mvn exec:java -Dexec.mainClass=com.validic.githubjobsapi.GithubJobsApplication
  ```
## Output

Below is a sample output that we get when we run the application

```
New York:
 -Java
 --Full Time-->18.18%
 -Python
 --Full Time-->9.09%
 --Contract-->9.09%
 -React
 --Full Time-->9.09%
 
 Sourced : 46
```
## Built With

* Java - Programming language
* Maven - Dependency Management
* RestTemplate - For API calls
