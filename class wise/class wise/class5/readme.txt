# Circuit breaker is one of the pattern used by developer while developing microservices
- Circuit breaker is one of the patern which helps to manage downstream service failure in a proper manner


# What is Circuit breaker pattern?
this pattern comes into the picture while communicating between the services
for example we have two services: ServiceA and ServiceB
ServiceA is calling ServiceB, if the serviceB is down due to some infrastructure outrage. ServiceA is not getting a result and it will hang by throwing an exception and then another request comes and it also faces the same situtation

Life cycle of pattern state
there are 3 main state in circuit breaker pattern
1. closed
2. open
3. half open



CLOSED state
when both service which are interacting are up and running, circuit breaker is closed
circuit breaker is counting the number of remote api calls continously


OPEN state
as soon as the percentage of failing remote api calls is exceding the given threshold limit, circuit breaker changes its state to OPEN state, calling microservices will fail immerdiately and an exception will be returned that means the flow is interupted


HALF open
after staying at OPEN state for a given period of time, breaker automatically turns its state into HALF open state
in this state only limited number of API call are allowed to pass through, if the failing call count is greather then the limited number, breaker turn again into OPEN state otherwise it is CLOSED



# Resilience4J
- it is lightweight, easy to use fault tolerant library insipred by netwflix hystrix



it provide varuious features
- circuit breaker - fault tolerance
- rate limiter - block too many request
- time limiter - limit the time while calling remote opeartion
- retry mechanism - automatically retyr for failed opeartion
- cache - store result of costly remote opeartion



