# Zeph Marcus Individual Project

//TODO One-line description here

### Problem Statement

Cats will occasionally display odd behavioral patterns that can 
entertain, mystify, or cause concern. 
When it comes to attaining answers about these 
behaviors, pet owners have several options: 
1. Consult existing user forums, whether specialized or general in nature, in hopes of finding the correct audience for their query.
2. Bug their veterinarian.
3. Post to, or search on, YouTube or other video-enabled social media sites in hopes of finding matching cat-tivities.

(_Additionally, current trends suggest that internet users have an 
insatiable lust for cat videos in general._)


This application aims to provide a useful and user-friendly
solution to the two problems outlined above by
offering a platform upon which users can:
* Author videos of their cat exhibiting unusual behavior and request
answers or advice from other users
* Search efficiently within application and on other social media platforms utilizing media tags and keywords
* Comment on user videos
* (Stretch) View 'expert' comments. {Implement user role with elevated 'rank' (badge next to username?)}



#### Project Technologies/Techniques

* Security/Authentication
    + Tomcat's Realm Authentication
    + Administrator role: full CRUD of all data
    + User role: add video, add description, comment on other posted videos, edit previous posts
    + All: view posted videos and comments (no login required)

* Database
    + MySQL
    + Store users and roles
    + Store data for user video/postings, including comments from others

* ORM Framework
    + Hibernate 5

* Dependency Management
    + Maven

* Web Services consumed using Java
    + YouTube API
    + Amazon Rekognition (image/video analysis & identification service)
    + (tentative) Twitter API
    + (tentative) Instagram API
    + (tentative) Facebook API

* CSS
    + Bootstrap 4

* Data Validation
    * Front-end: Bootstrap validator
    * Back-end: (tentative) Hibernate's validation
    
* Logging
    + Log4J

* Hosting
    + AWS

* Independent Research Topic(s)
    + [Amazon Rekognition](https://aws.amazon.com/rekognition/)
    + Social media APIs: YouTube, FB, Twitter, IG
    + (tentative) [Hibernate Validator](https://hibernate.org/validator/)
    + (tentative) [Hibernate Search](https://hibernate.org/search/)
    + [Project Lombok](https://projectlombok.org/) for eliminating boilerplate code
    
* Unit Testing
    + JUnit tests

* IDE: IntelliJ IDEA

#### Design

+ [User Stories](UserStories.md)
+ [Screen Design](ScreenDesign.md)
+ [Application Flow](link to application flow)
+ [Database Design](link to database design)

#### [Project Plan](ProjectPlan.md)

#### [Weekly Reflections](WeeklyReflections.md)  