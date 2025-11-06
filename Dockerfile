# ---- Build Stage ----
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy everything
COPY . .

# Make mvnw executable (needed on Mac/Linux)
RUN chmod +x mvnw

# Build the jar (skip tests to speed up)
RUN ./mvnw -DskipTests package

# ---- Run Stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Start app
CMD ["java", "-jar", "app.jar"]
