# notification-service
a case study[https://github.com/perseusEngineering/candidate-coding-challenges/tree/master/backend-challenges/multi-api-notification-service]

## code structure
There are three parts of the code.
* user-service, combined with user-common(provide entities and pojo beans) and userservice-api(a public api interface for RPC use).
* template-service, combined with template-common(provide entities and pojo beans) and templateservice-api(a public api interface for RPC use).
* notification-service, RPC consumer, using RPC methods to get users and templates and send emails.

## Frameworks Related
* using spring boot as basic microservice structure.
* using dubbo as rpc framework
* using jpa & h2 as db solution
* using spring mvc for web apis
* using quartz as cron scheduler

## meet requirements
* provide two test case in notification-service (success only user-service and template-service are running)
* provide web apis in (user-service & template-service)
* provide docker run for two services(user-service & template-service, how to start is in each service's README file)
* provide data db operation for two services.

## how to start
* start user-service, go to project path
  * run mvn clean install in each moudle (user-common, userservice-api, user-service)
  * docker build -f Dockerfile -t userservice .
  * docker run -p 8090:8090 -p 20770:20770 userservice
  * test user-service, access http://localhost:8090/user/id/1, shoule return user json string.
* start template-service, go to project path
  * run mvn clean install in each moudle (template-common, templateservice-api, template-service)
  * docker build -f Dockerfile -t templateservice . 
  * docker run -p 8080:8080 -p 20880:20880 templateservice 
  * test template-service, access http://localhost:8080/template/id/, shoule return template json string.
* test notification service case
  * run TestNotificationService.testSendWelcome, will get userId(1) from IUserService RPC and get welcome template from ITemplateService, then send email.
  * run TestNotificationService.testSendNewsletters, will get all the subscribe news user from IUserService.findAll() and get the newsletter template from ITemplateService, then put into the CACHE.
  * the CACHE in notificationService will run every 5 seconds and if the size over 10 and switch is on will send the emails.

## Things to improve
* write test about the CACHE cron job service
* write all the web api logic (only finish the code structure) and tests.
* write apis for notification service, passing any newsletter template key to send newsletter or any userId to send welcome letter.
* documentation.
* Dockerize notification service.
...
