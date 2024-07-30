FROM bellsoft/liberica-openjdk-alpine:17-cds

# Install curl jq
RUN apk add curl jq

# workspace
WORKDIR /home/selenium-docker

# Add the required files
ADD target/docker-resources     ./
ADD runner.sh                   runner.sh

# Fix for windows
RUN dos2unix runner.sh

ENTRYPOINT sh runner.sh
