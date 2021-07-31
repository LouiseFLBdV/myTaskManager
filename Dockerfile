FROM openjdk:8-jre-alpine

COPY myTaskManager.war /usr/local/tomcat/webapps/
COPY .idea/.run