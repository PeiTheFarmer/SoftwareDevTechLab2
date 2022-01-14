FROM tommybuonomo/javamaven
COPY ./* ./
WORKDIR ./
RUN mvn clean package
EXPOSE 9091

CMD ["java", "-jar", "/target/task-0.0.1-SNAPSHOT.jar"]