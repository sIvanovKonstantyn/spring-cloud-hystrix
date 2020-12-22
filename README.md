# Hystix using demo:
One client app, that calls a rest-api app using a rest template with hystrix command. 
Rest api generates exception in random cases and client app take answer from circuit breaker.
The same case in another client app with a feign client (**but it always in time-out...didn't resolve yet**).
