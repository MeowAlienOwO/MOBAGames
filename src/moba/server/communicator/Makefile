MOBALIB = ../../../../lib
MOBABIN = ../../../../bin
MOBASRC = ../../../../src
PACKAGE = moba/server/communicator
vpath %.java $(MOBASRC)
vpath %.class  $(MOBABIN)


.PHONY: all clean check

%.class: %.java
	javac -d $(MOBABIN) *.java 
Communicator.class : Communicator.java SocketListener.class Client.class
	javac -d $(MOBABIN) Communicator.java

SocketListener.class : SocketListener.java Client.class 
	javac -d $(MOBABIN) SocketListener.java
# Client.class : Client.java ClientReader.class ClientWriter.class
# 	javac -d $(MOBABIN) Client.java
# ClientReader.class : ClientReader.java
# 	javac -d $(MOBABIN) ClientReader.java
# ClientWriter.class : ClientWriter.java
# 	javac -d $(MOBABIN) ClientWriter.java
Client.class ClientReader.class ClientWriter.class : Client.java \
        ClientReader.java \
        ClientWriter.java
	javac -d $(MOBABIN) ClientReader.java ClientWriter.java Client.java
clean:
	rm -r $(MOBABIN)/$(PACKAGE)/ 
