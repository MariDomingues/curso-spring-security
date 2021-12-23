# Spring Security Course Using OAuth2

Required settings:

- Display the token:
  POST --> localhost:8080/oauth/token
    grant_type:password
    username:admin
    password:456
    
    Auth: username=client
          password=123
  
- Displays registered users: 
  GET --> localhost:8080/user-auth
    Bearer "Token"
