MOBALIB = ../../../lib
MOBABIN = ../../../bin
MOBASRC = ../../../src
PACKAGE = moba/server
SUBDIR  = communicator/
FILE    = Main.java SimpleLogic.java
CLASS_PATH = $(MOBABIN)/:$(MOBALIB)/
vpath %.java $(MOBASRC)
vpath %.class  $(MOBABIN)

define make_subdir
	@for subdir in $(SUBDIR);do (cd $$subdir && pwd && make all);done;
endef

define rm_subdir
	@for subdir in $(SUBDIR);do (cd $$subdir && make rm); done;
endef

.PHONY : all rm

all:
	$(make_subdir)
	javac $(FILE) -d $(MOBABIN) -classpath $(CLASS_PATH)

rm: 
	$(rm_subdir)
	-rm -r $(MOBABIN)/$(PACKAGE)


