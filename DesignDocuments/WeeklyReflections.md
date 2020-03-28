## Weekly Reflections

#### Week 0  (*Week of 01/13/2020*)

###### Individual Project
    No tangible work done on the individual project this week. Began brainstorming for topics
    at various times during the week when I had some idle time on my hands (e.g. stuck in traffic). - (1.5 Hrs)

###### Enterprise Java work
    [01/15/2020]: In order to jump back into the fray feeling somewhat prepared, I made sure to get my dev
    environment set up and tested this week. - (1.5 hrs)
    
    [01/19/2020]: Took my time working through Week 1 exercise, being sure to poke around in Maven to get a better
    feel for dependency management, goals, etc. - (1.5 hrs)

#### Week 1 (*Week of 01/20/2020*)

###### Individual Project
    
    [01/21/2020; 01/25/2020; 01/27/2020]: Spent several days tossing around different variations on a concept
    for the indie project. I was nearly set on creating an app which would allow student developers to 
    craft personal profile pages on which they could link to current project in GitHub, detail current
    courses and independent learning ventures, connect with other students and collaborate, and ultimately
    create a simple but effective portfolio supplement to add to their resumes. However, a day before
    our evening class on 1/28/2020, I tossed that idea out the window and decided to make an application
    centered around the sharing of videos containing strange cat behaviors. At first glance, this new concept 
    may come off as silly and kind of trivial, if not overdone in the current age of the internet, but I
    believe it has something unique to offer a number of pet owners and internet users. I developed the
    idea to the extent that I could share a feasible MVP during my elevator pitch during this week's class. - (1.5 hrs)
    

###### Enterprise Java work

    [01/22/2020]: Pulled down Week 2 exercise and got the application working. Added code to UserData allowing
    for user searches based on first name, last name and username. - (1.5 hrs)
    
    [01/23/2020]: Brushed up on git commands and completed Activity 2, which offered
    additional practice with git.
    
    [01/26/2020]: Completed Week 2 exercise - (1 hr) 
    

#### Week 2 (*Week of 01/27/2020*)

###### Individual Project

    [01/28/2020]: Created git repo for project and completed some initial project set up. - (0.5 hrs)

    [01/29/2020]: Added README, Weekly Reflections (this document), and 
    Project Plan to project. Added journal entries documenting work done up until
    this point.
    
###### Enterprise Java Work

    [01/29/2020]: Completed Activity 3 by initiating planning phase and adding
    link to project to IndividualProjects document in student repo. (1 hr)
    
    [02/02/2020]: Began Week 3 exercise, which offers some solid practice with unit testing (JUnit 5) 
    and logging (Log4J2).
    
#### Week 3 (*Week of 02/03/2020*)

###### Individual Project

    [02/04/2020]: Created partial Project Plan. Laid out tasks to complete for this week, including
    all parts Checkpoint 1. Having done little more than create project structure last week, this week
    will be all about crafting a concrete, detailed design and gameplan for the coming weeks.
    
    [02/05/2020]: Added User Stories to cover all intended functionality for project MVP.
    
    [02/09/2020]: Created first screen design wireframe - a basic template upon which to base wireframes 
    for most other pages.
###### Enterprise Java Work

    [02/04/2020]: Completed Week 3 exercise. Feel much more comfortable writing unit tests and
    utilizing those tests to create higher-quality code. Learned at least one or two ways to test
    for exceptions in a method.
    
#### Week 4 (*Week of 02/10/2020*)

###### Individual Project

    [02/10/2020; 02/11/2020]: Finished screen design wireframes for five pages: New user sign-up dialog, 
    Log in dialog, Search, View video, Upload new video.
    
    [2/10/2020]: Did some research on YouTube Data API and Facebook Login API. 
    
    Implementing video search on an external platform such as YouTube would allow 
    filtered access to giant collection of videos. However, Amazon Rekognition would not
    work on videos already on YouTube. 
    
    Implementing Facebook Login would allow users to quickly log in without having to create
    yet another new user account. Uses OAuth, which is a token-based authentication standard.
    
#### Week 5 (*Week of 02/17/2020*)

###### Individual Project
    Expanded database with one-to-many relationship between Users and User Roles.
    Added entities and DAOs to handle queries on User and User Role data.
    Created unit tests for full CRUD functionality - achieved 85%+ code coverage.
    Created sections of Administrator CRUD functionality, including ability
    to query users with associated roles. 
    Tried to pinpoint the reason for Log4J2 not correctly outputting log files as specified
    in properties file. More troubleshooting to follow...

###### Enterprise Java Work
    Helped troubleshoot some classmate issues including testing for equality between
    returned query objects in unit tests and exporting SQL data for re-use in rebuilding databases.
    

#### Week 6 (*Week of 02/24/2020*)

###### Individual Project
    Successfully deployed web app to AWS.
    Finished with creation of database design.
    Added video post entity.
    
###### Enterprise Java Work
    Created and set up AWS account. Configured IP and security groups
    for access to deployed web app and database. Solved issue with Log4J outputting
    correctly to terminal but not creating log files. The solution was to simply fix a filename typo:
    "log4j.properties" should have been named log4j2.properties all along. Log files all being output correctly 

#### Week 7 (*Week of 03/02/2020*)

###### Individual Project
    Added simple custom 404 error page. Added form-based authentication, requiring users to
    log in order to reach secured resources (e.g.: If logged in user has admin role, reveal "Maintenance Page" link in navbar.)
    Added Sign-up page for new users.

###### Enterprise Java Work
    Learned about Tomcat security, JDBC Realm and how to use form-based authentication
    based on User-UserRole relationship.


#### Week 8 (*Week of 03/09/2020*)

###### Individual Project
    Got part of Google Sign-in working (front-end implementation). "Sign-in With Google" button added to Login page. However, I still need to save user ID token to 
    my app's database in order to associate with posts, tags, comments. 
###### Enterprise Java Work
    Read into capabilities of Google Calendar API for potential use in team project. Unsure if it would be worthwhile
    to make a new web service based on Google Calendar when the existing API already offers a great number of capabilities.


#### SPRING BREAK (*Week of 03/16/2020*)

###### Individual Project
    As COVID-19 response has turned most all of our lives upside-down, I've found little time to 
    finalize implementation of Google Signin (w/ the back end) or look ahead at starting work with the Youtube Data API.
    I did manage to incrementally flesh out the rest of my entities and a good amount of basic unit tests, but I have
    not had enough time to put into the project.
    
###### Enterprise Java Work
    More leraning about consuming APIs. Getting a better grasp on processing JSON response
    data using Jackson and the handy RoboPOJOGenerator, which allows for rapid generation of POJOs from JSON.

#### Week 9 (*Week of 03/23/2020*)

###### Individual Project
    Fully integrating Google Sign-in with the back-end proved to be quite frustrating, so I have removed
    it from the project. Perhaps I will implement in V2, but for now, it is not vital to the success of the application.
    Returning focus to implementing the YouTube Data API, which is key to application functionality.
    
###### Enterprise Java Work
    Formed a group for a team project, which will offer a web service aimed at assiting Slack workspace owners with
    templating and creating new workspaces from existing ones. Helped with initial setup tasks including: initiation of a project
    git repo, creation of a test Slack workspace, and collecting of user research data.