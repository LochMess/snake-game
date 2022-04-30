FROM maven:3.8.5-openjdk-11

ENV PRJ_PATH=/home/snake-game

RUN mkdir $PRJ_PATH
COPY . $PRJ_PATH
WORKDIR $PRJ_PATH
RUN mvn install
CMD java -jar ./target/snake-game-1.0-SNAPSHOT-jar-with-dependencies.jar
