# CoinmarketcapRestApiConsumer
An example of how to consume a restfull web service with Spring RestTemplate .
The project is constructed with gradle . All Spring,Springboot and jackson dependencies are handled by gradle.
There are two application classes ,one of which has a simple main method where you can initialize and see the results of what you consumed. The other app class is based on spring boot and we managed all lifecycle with spring boot.

By 28 Dec 2017 ==> The controller and Service layers added in order to serve as a rest api. The Coinmarketcap api is consumed via service layer by using spring rest template . There are two controllers , one of which is a rest controller for consuming coinmarketcap api via service layer. The other one is home controller which is just for redirecting the get request to index html.

The index.html contains an angular app object which is making a rest call to  http:localhost/ and gets the json string and shows it in an html table. 
