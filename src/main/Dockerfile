FROM openjdk:17.0.2 as setup
RUN microdnf update && install -y findutils
WORKDIR /workspace
COPY . ./
RUN ./gradlew --no-deamon assemble
RUN find /workspace/build/libs/ -maxdepth 1 -type -iname "*jar" |  | xargs -I{} cp {} /workspace/app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /workspace/app.jar ${0} ${@}"]