# Answers to Design Questions :
## 1/ Suppose we put all the functions inside the same service. Is this the recommended approach? Please explain.

no it's not a recommended approach since it doesnt respect the single responsability principle and it become harder to debug and maintain on large scale projects. it's better to separate responsibilities such as creating userservice and roomservice and bookingservice will make it easier to read the code , to add features and also debugging 


## 2/ In this design, we chose to have a function setRoom(..) that should not impact the previous bookings. What is another way ? What is your recommendation ? Please explain and justify.

The other way would be to let setRoom() update room details and update all related bookings too , but it will not behave as expected wich we call it semantic error, where the real life case would be : a user made a reservation at a price but when we access the bookings history we find that the bookings details were updated with the updates of room details . 

So I agree with the current approach , If something about the room changes, it should not change past bookings. That is how most real world systems work.
