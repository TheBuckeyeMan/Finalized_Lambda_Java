# Use Amazon Linux 2 as the base for AWS Lambda
FROM public.ecr.aws/lambda/java:17

# Copy the built JAR file from Maven to the Lambda container
COPY target/demo-0.0.1-SNAPSHOT.jar ${LAMBDA_TASK_ROOT}/app.jar

# Set the Spring Cloud Function adapter as the entry point
CMD ["-cp", "/var/task/app.jar", "com.example.demo.LambdaHandler"]