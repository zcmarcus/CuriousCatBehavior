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
    + Store: users, user roles, video posts, video post comments, searchable tag/keyword data

* ORM Framework
    + Hibernate 5

* Dependency Management
    + Maven

* Web Services consumed using Java
    + (MVP) YouTube API - for searching, sorting and presenting youtube videos (with metadata)
    + (MVP) Google Sign-in - for allowing users to log into app using existing Google account
    + (stretch goal) Facebook API - for inclusion of videos

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
    + YouTube Data API 
    + Google Sign-In
    + [Hibernate Validator](https://hibernate.org/validator/)
    + (tentative) [Hibernate Search](https://hibernate.org/search/)
    + (tentative) [Project Lombok](https://projectlombok.org/) for eliminating boilerplate code
    + (stretch goal) [Amazon Rekognition](https://aws.amazon.com/rekognition/) for recognition of animals and objects in videos. This will require user uploads to S3 bucket. 

    
* Unit Testing
    + JUnit tests

* IDE: IntelliJ IDEA

#### Design

+ [User Stories](DesignDocuments/UserStories.md)
+ [Screen Design](DesignDocuments/ScreenDesign.md)
+ [Application Flow](link to application flow)
+ [Database Design](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Database_ERD.drawio#R7V1dc5s6EP01fkyGL2PnMXaT9DZJb9rktr1PGcXINg1GrpCbOL%2B%2BEggDliAmARt11Ml00CKEpD06knYXuWePF88XGCzn18iDQc8yvOee%2FaFnWQN3SP9ngnUicAw7Ecyw7yUiMxPc%2Bi%2BQCw0uXfkejAoZCUIB8ZdF4QSFIZyQggxgjJ6K2aYoKL51CWZQENxOQCBKv%2FsemSfSoTXI5B%2BhP5unbzbdk%2BTOAqSZeUuiOfDQU05kn%2FXsMUaIJFeL5zEMWN%2Bl%2FfL9n%2FX34OrRvfj0JfoF%2Fhtd3n3%2BdpQUdl7nkU0TMAzJm4t%2BeZyef%2Fzm%2FPyxvDn%2F8mRcnD58Ojrq87J%2Fg2DFO2wVQRzxFpN12o3Rk78IQEhToykKyS2%2FY9L0ZO4H3hVYoxWrXETA5DFNjeYI%2By80Pwh4ZnobE44Syy3kuGVPUrFBpRhGNM9N2mJzI7oCEeF5JigIwDLyHzY1WQA888MRIgQt0oLQKvSgx1MbFcYJgtHjBhTs%2BR37Oe0ziAl8zqGM9%2FsFRAtI8JpmSe8aHEJ8DJkswdJPGSJNl%2BeZ59C4wR7go2C2KXvzuq901IBwRjth8z6r%2BLqhsePb3OLLQEAgDgGBI9aJUR5d9CLX0EwUY64O%2FiwBfzS%2FAL45WLJLqhnigyBrsT0iaMnVGcBpigzM28SuH1I0MAWDwJ%2BF9DrJO2Ia9ClVnHJxXNho6gfBGAUIU0mIYshHSzDxw9lV8grHyERf%2BascKkK0vGkQ42vuex4MY%2FwRQEACUfbYEvkhifu3P6J%2FVAtj47jf69NmjmnazNL0j2XHZIxCClXgx5iEFP9PkI2BkYfR8o4iHm6aXQfr%2BVHsiMCvZovXkb8uQqou9PI4L2CuNsBsAWA3l%2B8G2EOeYiR42QlnW6BqClOvwYa1sZTvqgfptto3szavTGFiLMAhp3%2FbbUf9MOifX677Z%2Fbg%2BubO%2BOksx6vPR%2BZAUH9vbPVODTbL3YdgAdshG6MxsrEbA0azZBPzRzKPm1YNLNWmkP6uc2VrGBqKGNIEkk0ilSCoHpXqEYolLpgTQlmCKHpCuKXFi%2BaTxvhkMDwwn6T0ofmkKT6xykDQfT4xT0r4BC6AH2gy6TiZmIZzaDYxNJs0vDo5KUFB99nEEne7CZsEtIP0dkcJRrHfaK1rDkSOZpSG1yd2CQoUYJR%2BCaNMfawpRRFK6e%2FRCitHkasppWFK6ZegoFOUIgdwC%2FNLyxTyV3h82uOX4Y4mWnvYFqQks5Tml1pad0q03hif2MNjI%2F%2FPbAsL4lwTO3swCqCOa%2BDKaCauwXlrXMPGbFIzrsFVJ7BBdDzqwIbuBja4O0O%2FM4ENoldSBzbUnfSU8EPKqy76DZQJafgraKY1ZtlnvIO0yq7oUTi%2FNDW11NO7Ek4Euf7FEAe2dtbUojy17DP0QQ4tS4CW5pVaSneVCHWQV13inNxWPvRmMF28036boxkKQXCWSUcw9E7ZZyE0w9lXquE7dA3CdboDz24tQOj9mzBE9WijBfJ9%2B3BrHz9M7p77rJ3x06KSqjbSEVrhCawawbwDSEoVry1UWfdUDvT8yDakG28uxDAAxP8NCwiq2I3fMFxnO3HbLO7E7ZOtDxWStvOnMuAIBTlbBVnbBSV9IxREFQ3WuWx83JVX2N4yVfCBVFYvIT%2Bf0LMBkNTgrUYDqVFftFxN0GIBecO03aoxu5XpFJTruDsakhqyW1mDThiupBjUdqtu2q0qCaOTZitpjbXVqs4SsHKEdnoFKK25aLNaoojct0Uwelv5ymzaDKcc%2FgMdbbB6P6soYa%2BSq1%2B0Vz0gb605RWFOOfhHOqa2VL2TUEwlLFXOxbdfqw9nn8bGzQMcXl7Ofiymmy8%2BaxmmiuMmy3OFYiywnvsJCVnzzTZYEcS222SRbsXhs09%2BsMePbdfm6f%2FZvWPTtnj6wzMvP06s00TeJvYCMdoYxTLzVfqGG4h92ksQ99oxafGty6smLZdnfNWkVc9SVdcuZG5tzW1nsAWfFuw8VtlHXxMMaVtReO%2FRPX7XJzB146rbOdXFNt5o1Wls0rLFhbCetN4XZq3Eslg6iVniDmivk1g%2FP4U1Mn01PFW5kqlK2pN20zPV%2B9xoYvg8s6JoF0Gj5D4scvvOHgLLNsr1rpyHQA5AMdheuwi64CKopotO%2BgjkVRb9oNpJUL77rh6knV64yKsuuiDj0FbtJuhS9Fl9Xjl8YKvofNR%2BgtrEooT7UV510exCfBJ03tCiaaUrrgJplQfa6vJeTlHCyiI3uZWdB0hlKngh1TXiNkQfhz%2FBy9auxoattrbCrsdyOvntexDdr7A%2BFbDznLLPM7zkxn9NKW%2BmlMpxqR6jGILm9%2BgGSq%2BZEyhzCZW5gWhzE9%2BR03dTAXvyyDg2zFSQPRynCk9vBzccyLMkC4Koiovav2dJPm2WnR5JZQvk%2BVMfejoyQYHIhC3nleuYh17i6iMlm17iKnGkZJU7PW%2BFAzPtvm6TAQa7npRkmhVHtFW4r7t4LpMUfCIRad91F3zXlUzRSde1tMZiaIT2XJcbgytHqHoTm%2BSQ23T5rMh3buounJvhj326qKU1FkMfzjV%2F7LxSrhyV6vGJKRIKXSnrc5gO57JuhmV29Vg7FaGk7wOW5FcRNcnU0bnZOqs4RuPHJctbUvYtEmuK%2FhxJXaOf2T%2FwWkb%2FMlXTSxk1fplKDgZR9513Q%2FVyLij%2BVKUD6jBfMXFMvOprSr%2FHbt3ZRJMYIZK322GwnF8jD7IcfwA%3D)

#### [Project Plan](DesignDocuments/ProjectPlan.md)

#### [Weekly Reflections](DesignDocuments/WeeklyReflections.md)  