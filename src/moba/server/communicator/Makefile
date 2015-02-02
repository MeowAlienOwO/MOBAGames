MOBALIB = ../../../../lib
MOBABIN = ../../../../bin
MOBASRC = ../../../../src
PACKAGE = moba/server/communicator
vpath %.java $(MOBASRC)
vpath %.class  $(MOBABIN)


.PHONY : rm all

all : $(MOBABIN)/$(PACKAGE)/*.class
	@pwd
$(MOBABIN)/$(PACKAGE)/*.class : $(MOBASRC)/$(PACKAGE)/*.java
	javac -d $(MOBABIN) $(MOBASRC)/$(PACKAGE)/*.java

rm : 
	-rm -r $(MOBABIN)/$(PACKAGE)/

# %.class: %.java
# 	javac -d $(MOBABIN) *.java 
# Communicator.class : Communicator.java SocketListener.class Client.class
# 	javac -d $(MOBABIN) Communicator.java

# SocketListener.class : SocketListener.java Client.class 
# 	javac -d $(MOBABIN) SocketListener.java
# Client.class : Client.java ClientReader.class ClientWriter.class
# 	javac -d $(MOBABIN) Client.java
# ClientReader.class : ClientReader.java
# 	javac -d $(MOBABIN) ClientReader.java
# ClientWriter.class : ClientWriter.java
# 	javac -d $(MOBABIN) ClientWriter.java

# clean:
# 	-rm -r $(MOBABIN)/$(PACKAGE)/ 
