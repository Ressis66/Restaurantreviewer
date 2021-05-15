Graduation project 'Voting system'

Description

2 types of users: admin and simple users

Admin can input a restaurant and it's dishes of the day.
Menu changes each day (admins do the updates).
Users can vote on which restaurant they want to have lunch at.

Only one vote counted per user.

If user votes again the same day:
If it is before 11:00 we asume that he changed his mind.
If it is after 11:00 then it is too late, vote can't be changed
Each restaurant provides new menu each day.

REST API

Authorization (access for everybody). Attention! Project uses tokens(Bearer_token)! 

curl -i -X POST -d username=RETA -d password=12alta   http://localhost:8080/v1/auth/ (dont forget to insert given token with prefix 'Bearer_' !!!!!!!)

Votation (access for the person which has role: 'ROLE_USER'):

curl -i -X POST {rate=5.0}  http://localhost:8080/api/v1/users/vote/{restaurantId}?rate=5.0

GET all restaurants (access for the person which has role: 'ROLE_USER','ROLE_ADMIN')

curl -i -X GET http://localhost:8080/api/v1/users/restaurants

GET one restaurant (according to id) (access for the person which has role: 'ROLE_USER', 'ROLE_ADMIN')

curl -i -X GET http://localhost:8080/api/v1/users/restaurants{id}
