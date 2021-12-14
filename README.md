# Software Developer Tutoring

This repository contains all sources and steps to replay the Session *How to Secure your Web Application*.

## How to Secure your Web Application

This repository consists of three parts (individual Maven projects):

* Unsecured Spring MVC Application (*unsecured*)
* Simple Spring Security Authentication (*springsecurity*)
* Keycloak OAuth2 Integration (*oauth2integration*)

## Prerequisites

To replay the demo, the following applications must be available locally:

* Unrestricted Internet Access for Maven usage
* Local IDE installation, eg. IntelliJ or Eclipse (optional). You can download IntelliJ CE here: https://www.jetbrains.com/idea/download/
* Java 11+ (might be included in IDE)
* Maven 3+ (might be included in IDE)

## Setup

* In your IDE, import from VCS, ie. the service or the client repository URLs
* Add the subprojects (*unsecured*, *springsecurity*, *oauth2integration*) as Maven projects

## Run Demo

Start the Application classes in the projects in your IDE or with `mvn spring-boot:run` and 
open `http://localhost:8080` in your browser.

### User login data

```
"User",  Role USER,  username: user,  password: user
"Admin", Role ADMIN, username: admin, password: admin
```