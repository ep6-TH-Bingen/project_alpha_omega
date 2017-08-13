# project_alpha_omega

This is our term project for a computer science class at UAS Bingen. Our aim is to create a traffic simulation. The team members are:
* [Ralf](https://github.com/RalfBr)
* [Sören](https://github.com/SoerenDbl)
* [Dominik](https://github.com/Domm2501)
* [Eden](https://github.com/EdenTewelde)

Our lecturer is [Nicolai Parlog](https://github.com/nicolaiparlog).

We have to solve the [tasks](https://olat.vcrp.de/auth/RepositoryEntry/1676804160/CourseNode/95999652079122) in the limited period from 30.07.2017 (18:00) to 13.08.2017 (18:00).

## Application
You can download the newest release [here](https://github.com/ep6-TH-Bingen/project_alpha_omega/releases).
As input you should provide a csv-file (cars.csv) in the resources folder. See the following example for the structure of the file:
```
Car-ID, wantsToDriveAtHour
1, 3
1, 5
1, 12
1, 21
2, 4
2, 5
2, 20
3, 13
...
```

To start our application you need to open command prompt or Windows PowerShell. Navigate to the directory the jar-file is in. Use the following command to run the simulation:

```
java -jar project_alpha_omega-2.0-jar-with-dependencies.jar
```
Then the application simulates the traffic for 24 hours and returns for each car the hours it wanted to drive and whether it was delayed or not. A car that wants to drive e.g. at hour 4 and is delayed keeps the desire to drive until it is fulfilled.

## Communication
For communication and code-sharing we use **_GitHub_** and **_Git_**.
For Programming we use [Kotlin](https://kotlinlang.org/) and [Maven](https://maven.apache.org/).

- the language for coding should be English
- all communication on Github should be in English

* Link to the [License](https://github.com/ep6-TH-Bingen/project_alpha_omega/blob/master/licence.txt)
* Link to the [Code of Conduct](https://github.com/ep6-TH-Bingen/project_alpha_omega/blob/master/code_of_conduct.md)
