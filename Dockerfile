#### ---- Stage 1: Build (Maven) ---- ####
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom first for dependency caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the Spring Boot JAR (NO Nexus)
RUN mvn clean package -DskipTests

#### ---- Stage 2: Runtime ---- ####
FROM  eclipse-temurin:17-jdk-jammy AS runtime


LABEL maintainer="dhee31" \
      description="Spring Boot Application (Docker + Jenkins)"

WORKDIR /app

# Copy only the final JAR from build stage
COPY --from=build /app/target/boot-movie-crud-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
