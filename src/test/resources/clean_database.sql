DELETE from user;
INSERT INTO user (id, user_name, password, email, last_name, first_name)
                 VALUES (1,'jpublic','secretpw1','jpublic@wisc.edu','Public', 'John'),
                        (2,'kmalone','secretpw2','kmalone@jazz.com','Malone', 'Karl'),
                        (3,'dduany','secretpw3','dduany@wisc.edu','Duany', 'Duany'),
                        (4,'hcoulson','secretpw4','hcoulson@hotmail.com','Coulson', 'Hannah'),
                        (5,'szawistowski','secretpw5','sz01@wisc.edu','Zawistowski', 'Samantha'),
                        (6,'bcurry','secretpw6','bcurry@hotmail.com','Curry', 'Barney');