# Snake Game
Simple snake game, reads user input from standard in to tell the snake the direction to move in, up, down, left, right. User input is case-insensitive. After 5 steps the snake's length increases by a segment. The game ends if the snake collides with itself or falls off the board. 

## Run it
### Run
To run compile the game, `$ mvn clean package` this will also run the unit tests before compiling. Then to start the game `$ mvn exec:java` or `$ java -jar ./target/snake-game-1.0-SNAPSHOT-jar-with-dependencies.jar`.
### Test
To run all the tests (only has unit tests, there are no integration tests to run at this time) `$ mvn clean verify`.

### Docker
The game can be run within a docker container, building the docker container is quite slow due to pulling in of the maven dependencies, `$ docker build -t snake-game ./<path to docker file>`.  
Run the built image, `$ docker run -it --rm snake-game`