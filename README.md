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

Authorization (access for everybody):

curl -i -X POST -d username=user -d password=password   http://localhost:8080/v1/auth/

Attention! Project uses tokens!

Votation (access for the person which has role: 'ROLE_USER'):

curl -i -X POST -d rate=3.0 http://localhost:8080/api/v1/users/vote/restaurantId
