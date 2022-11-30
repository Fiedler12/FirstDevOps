FROM maven:3.8.6-openjdk-18 as MAVEN
WORKDIR /tmp
COPY /src/ ./src
COPY /pom.xml ./
RUN mvn package -Dmaven.test.skip

FROM node:18-slim AS REACT
WORKDIR /tmp
RUN yarn install
COPY /web/package.json  ./
COPY /web/src ./src
COPY /web/public ./public
RUN yarn run build

FROM openjdk:18-alpine
WORKDIR /tmp
COPY --from=MAVEN /tmp/target ./
COPY --from=REACT /tmp/build ./src/main/webapp/

EXPOSE 8080
CMD ["java","-Xmx1024m", "-jar", "/tmp/devops-fatjar.jar"]
