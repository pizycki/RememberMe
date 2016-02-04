# RememberMe
Aurelia + Spring web app to track watched films

_Project created for course "JSP development" @ SGGW_

## What does it do?
* It helps user to track films he wants to watch and leaving notes to films that he already watched.

* For quick film look up, there is simple film catalog avaible. 

* For every film saved in user repository, there is an option to download basic details about the film (there is even a poster!).

## Architecture
The whole application is based on "client-server" pattern, where client is a Single Page Application (SPA in short)
and the backend is REST-like API.

Client was build with use of [Aurelia framework](http://aurelia.io/), which is JavaScript library for creating SPA applications. 
It's somehow similiar to announced Angular2 framework. To serve static resource requests we used simple tool
[local-web-server](https://www.npmjs.com/package/local-web-server).

The API is hosted with [Spring MVC framework](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
(altough, we don't use V in here). To make development even more simple, I choosed Spring Boot framework with
[Maven](https://maven.apache.org/) type project. It made resolving all dependancies painless.

For gathering and browsing film catalog I've used open source data provider [OMDb API](http://www.omdbapi.com/).
The requests are made on the server-side with [RestTemplate](https://spring.io/guides/gs/consuming-rest/) from one of 
Spring components and parsed manually with [JSON.Simple library](https://code.google.com/archive/p/json-simple/).

As a data storage (a.k.a database) I used NoSQL, document database [MongoDB](https://www.mongodb.org/).
Quick tutorial how to use Spring MongoDB adapter can be found [here](https://spring.io/guides/gs/accessing-data-mongodb/#use-maven). 
