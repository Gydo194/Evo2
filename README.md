# Evo2
Evo2 Java web server

Evo2 is a lightweight native Java web server.

It can easily be called as a Thread since it's main class implements the Runnable interface.

To start a server, assuming you've imported all classes:
	```java
	Evo2 evoServer = new Evo2(8080); //constructor method accepts one argument which is the port you want it to listen on (integer value).
	Thread serverThread = new Thread(evoServer);
	serverThread.start();
	```
To add URLs to it, create a HttpResponse object:
	HttpResponse resp = new HttpResponse(String URL, String returnData, int StatusCode);
and add them to the server:
	evoServer.addResponse(resp);
	
	For example:
		```java
		HttpResponse resp = new HttpResponse("/helloworld","<h1>Hello World</h1>",200);
		evoServer.addResponse(resp);
		```
If you require more logic to run on request time, providing a dynamic response(ex. using query string parameters or HTTP header values, extend the HttpResponse class and override the getResponse() method. More information on a wiki later.