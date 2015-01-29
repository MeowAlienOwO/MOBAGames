SRC = src/moba/*.java src/moba/server/*.java src/moba/client/*.java

CLASSPATH = bin:/lib/:test-lib/*.jar

.PHONY: test run runtest push pull

all:
	@for subdir in SRC; do\
		javac -cp $(CLASSPATH) -d bin/ $(subdir)/*.java \ 
	done;
	
	
test:

run:

runtest:

push:
	git add -A
	git commit -a
	git push origin master

pull: 
	git pull origin master

