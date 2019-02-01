##User-Service
provides apis and services for all the user operation in notification system.

##How to start
1. run com.chenzhe.UserServiceApplication directly   
2. using docker
    * build your local image:
        *  go the project path
        *  run: mvn clean install // after that, the user-service
        *  run: docker build -f Dockerfile -t userservice .  // build docker image
    * run docker image:
        docker run -p 8090:8090 -p 20770:20770 userservice 


##How to test
1. using NotificationService unit test 
2. using brower to test api, like: [http://localhost:8090/user/id/1]  
response:  
```json
{"id":1,"name":"test","email":"test@gmail.com","salutation":"Mr","identifier":"test001"}
```
    