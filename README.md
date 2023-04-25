# Coding Dojo 2023 01

# TODO
- Add IntegerFlag
- test case for negative numbers
- test case for strings that start with dash
  - ex. `Wget -O - example.com` O is output, '-' is stdout
- test case for default values
- (ambitious) support lists as values for flags

## Introduction

### Main exercise

[Args Kata](https://codingdojo.org/kata/Args/), from [Clean Code](https://drive.google.com/file/d/0B6KDw53U4-V6SWFtbDlNVHVJbW8/view?usp=share_link&resourcekey=0-c0qD9xB3L3f5YQb8HtERgw).

Please don't look for solutions before the session, only read the description, try to understand the problem and think a bit about possible solutions.

### Sugested take-home exercise

For those interested in a simpler kata about code comments: 
  - In Chapter 4 (comments) look for the last section, "Example" at the end of the chapter. Line 71 in the physical book.


## Starting Point

I have cloned a Java -Maven boilerplate repo I had, which used the Maven Quickstart Archetype, adding JAR Archive Config as well.

### Creation

#### Archetype
`mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4`

#### Jar packaging
Added `maven-jar-plugin`config

### Test
`mvn test`

### Build
`mvn clean package`

### Run

#### Before jar config
`java -cp target/basic-archetype-test-1.0-SNAPSHOT.jar org.example.App`

#### After jar config
`java -jar target/basic-archetype-test-1.0-SNAPSHOT.jar`
