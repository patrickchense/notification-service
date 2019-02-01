## User-Service
provides apis and services for all the user operation in notification system.

## How to start
1. run com.chenzhe.TemplateServiceApplication directly   
2. using docker
    * build your local image:
        *  go the project path
        *  run: mvn clean install // after that, the template-service
        *  run: docker build -f Dockerfile -t templateservice . // build docker image
    * run docker image:
        docker run -p 8080:8080 -p 20880:20880 templateservice 


## How to test
1. using NotificationService unit test 
2. using brower to test api, like: [http://localhost:8080/template/id/1]  
response:  
```json
{"id":1,"key":"welcome","text":"Hello dear {{user.salutation}} {{user.name}},\n\nwe are very happy to welcome you to our newsletter.\n\nIn case you don't want to receive any further newsletters in the future please unsubscribe here:\nhttps://domain-of-product.de/unsubscribe-newsletter/{{user.identifier}}\n\nBest Regards,\nYour Customer Support Team"}
```
    
