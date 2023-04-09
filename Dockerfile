FROM gradle:7.2.0-jdk17
ARG JAR_FILE=build/libs/cookbook-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} cookbook.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","cookbook.jar"]


#FROM gradle:7.2.0-jdk17
#ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en' LC_ALL='en_US.UTF-8'
#
#ARG APP_HOME=/app
#WORKDIR $APP_HOME
#
#
#COPY build/libs/*.jar $APP_HOME/cookbook.jar
#
#ENTRYPOINT java $JAVA_OPTS -jar cookbook.jar $JAVA_ARGS