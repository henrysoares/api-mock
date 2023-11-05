# Mock App
This project is a simple configurable mock API that runs on a Tomcat server. This project is still in development, and up to the current moment, it's possible to create mocks for the GET, POST, and PUT methods and configure hardcoded payloads. However, in the near future, this mock can be configured to perform other actions and change the payload to adapt to each request

##How to build and run the project

This project is a Java 17 project using the Spring Boot framework. To run it with minimal requirements, you need a PostgreSQL database and Java 11. The database requires the following connections:

DATABASE = mock
USERNAME = mock-root
PASSWORD = mock123
PORT     = 5432

After that, you can run the API by typing: ```./gradlew :mock-api:bootRun.```

###Other alternative

The project is containerized with Docker and is already properly configured, so you can generate the Docker image of the API using the following command: ```sudo docker build -t mock-app:latest .``` in the folder 'mock-api'.
After that, go to the 'docker' folder and use the following command: 'sudo docker-compose up'.

###Running using makefile (Easiest way)

If you have installed 'make', simply type: ```make run```

If you don't have make installed you can type: ```sudo apt-get install make``` to install.

##How to use

To register a mock, it is necessary to first register it at the 'api/mock' endpoint with the following payload:
```
{
    "mock_name": "first mock", // mock name
    "mock_method_type": "POST", // the request method
    "path": "/test/post", // the path that will be mapped (There's no need to insert the /mock path in the beginning)
    "payload": { // the payload that will be returned
        "test": "TEST POST"
    },
    "status": 201, // the response status
    "workflow_type": "MOCK_NATIVE", // this is for future implementations
    "metadata": { // this is for future implementations
        "test": "test"
    }
}
```

###Curl:
```

curl --location 'http://localhost:8080/api/mock' \
--header 'Content-Type: application/json' \
--data '{
    "mock_name": "test",
    "mock_method_type": "POST",
    "path": "/test/post",
    "payload": {
        "test": "TEST POST"
    },
    "status": 201,
    "workflow_type": "MOCK_NATIVE",
    "metadata": {
        "teste": "test"
    }
}'
```

After registering your mock, simply hit the API with the registered method + the beginning of the path with '/mock' + the registered path.

###Exemple:
```curl --location --request POST 'http://localhost:8080/mock/test/post'```
