FROM tommybuonomo/javamaven
COPY ./* ./
WORKDIR ./
RUN mvn clean package
EXPOSE 9090

CMD ["java", "-jar", "/target/staff-0.0.1-SNAPSHOT.jar"]