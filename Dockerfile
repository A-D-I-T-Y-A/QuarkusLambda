FROM  public.ecr.aws/lambda/java:21

ADD target/QuarkusLambda-1.0-SNAPSHOT-runner.jar /var/task/lib/my-service.jar
ADD target/lib/  /var/task/lib/

CMD ["io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest"]