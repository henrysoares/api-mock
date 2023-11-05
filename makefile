SHELL := /bin/bash

build:
	./gradlew clean build --parallel

build-docker:
	cd mock-api && sudo docker build -t mock-app:latest .

run-compose:
	cd docker && sudo docker-compose up -d

show-logs:
	cd docker && sudo docker-compose logs -f

run: build build-docker run-compose show-logs