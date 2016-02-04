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

## Setup

I'll show how to setup project in the fastest way I know. Sorry linux-lovers, I'm going to achieve this on Windows. Sorry Windows-lovers, I'm going to use `cmd` for most of the time.

First open your `command line` as Administrator user. 
Download  [chocolatey](https://chocolatey.org/) packet manager (just copy-paste&enter the first script on that page).
Install git, Java SDK, JRE, Maven, NodeJS, MongoDB.

```bash
cinst git jdk8 jre8 maven nodejs mongodb -y
```
You can do this all manually (it means, with mouse) too, but why shouldn't we make it faster and simpler?

The installation may take several minutes. Go make yourself a cup of coffee. Afterall, we develop in Java!

When it's done, install one more thing from `npm`. Unless you don't use IIS or any other HTTP server.

```
npm install local-web-server
```

When it's done, run MongoDB server. Just type `mongod` inside `cmd` and you should see something like this.

```
...
2016-02-04T13:49:03.859+0100 I CONTROL  [initandlisten] MongoDB starting : pid=10180 port=27017 dbpath=C:\data\db\ 64-bit host=DAYSTATE-PC
...
```
> Note that `C:\data\db\` is default path where MongoDB instance files are stored.

Then, open new `cmd` window and clone this repository onto your disk. When it's done, change to `api` directory.

```
git clone https://github.com/pizycki/RememberMe 
cd RememberMe/api/
```

To compile source code and run Tomcat instance with working API, simply type `mvn spring-boot:run -X` (paramter `-X` is optional but gives us more info what's going on).

It should explode with _a lot of_ text, but in the end you should see those two lines. They mean that your API enpoint is up and running.

```
2016-02-04 13:55:47.363  INFO 9828 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2016-02-04 13:55:47.368  INFO 9828 --- [           main] izzy.sggw.RememberMeApplication          : Started RememberMeApplication in 4.018 seconds (JVM running for 7.989)
```

The last, but not least, is to host your SPA. Open new `cmd` (yup, that's already the third) and go to `client` directory. You can find it the root of the project.

When you're there, type `ws --spa .\index.html`. You should see short output

```
serving at http://DAYSTATE-PC:8000, http://192.168.0.15:8000, http://192.168.94.1:8000, http://192.168.154.1:8000, http://127.0.0.1:8000
```

And you're done!

Open your browser and navigate to one of the `URL` visible in the 3rd `cmd`. Here is `http://DAYSTATE-PC:8000`.

There you go, your Remember Me! app

Congratulations.

## Screens
![Browsing catalog](/screens/catalog.png)
![Creating film](/screens/create.png)
![Film with basic details](/screens/film_full_details.png)
![Rating film](/screens/edit_rating.png)
![Listing all films to watch](/screens/list_Already_watched.png)
![Deleting film](/screens/delete.png)
