# notification-service
a case study[https://github.com/perseusEngineering/candidate-coding-challenges/tree/master/backend-challenges/multi-api-notification-service]

## code structure
There are three parts of the code.
* user-service, combined with user-common(provide entities and pojo beans) and userservice-api(a public api interface for RPC use).
* template-service, combined with template-common(provide entities and pojo beans) and templateservice-api(a public api interface for RPC use).
* notification-service, RPC consumer, using RPC methods to get users and templates to send emails.

## Frameworks Choose
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

