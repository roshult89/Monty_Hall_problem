# Monty Hall problem dev test

## Requirements
- JAVA 17
- Depending on idea, Lombok-plugin could be needed for alter the code

## To Run

#### if supported by the idea
- navigate to main/java/se/roshult/devtest/TvShow and press play

#### otherwise build with maven
- run `mvn clean install` in terminal
- followed by `java -jar target/GameShow-1.0-SNAPSHOT-jar-with-dependencies.jar` 

<p> If wanted, an argument for how many times the game should be played (both where player stick with original box, and where the player change box) can be given </p>

- run `java -jar target/GameShow-1.0-SNAPSHOT-jar-with-dependencies.jar 20000` will run the game 20000 * 2 (20000 for changing box, and 20000 for not changing box)

#### Comment to solution
I decided not to over-engineer this by adding dependencies that's adds a lot, but in this does not contribute a lot, like spring.
The benefit with adding libraries like that would be that it would be easier to have a loose coupling, by dependency injection,
and thereby easier to test some scenarios...

I did not however find that many extra test-cases that could be added by adding such a library, so I decided to keep this slim instead.
