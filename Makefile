JAVAC ?= javac
JAVA ?= java
BUILD_DIR := build
SOURCES := $(shell find src tests -name '*.java')

.PHONY: compile test clean

compile:
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -encoding UTF-8 -Xlint:all -Werror -d $(BUILD_DIR) $(SOURCES)

test: compile
	$(JAVA) -cp $(BUILD_DIR) RunHw7Checks
	$(JAVA) -cp $(BUILD_DIR) il.ac.tau.cs.software1.predicate.Tester
	$(JAVA) -cp $(BUILD_DIR) il.ac.tau.cs.software1.ip.TestIPAddress >/tmp/bsc-software-1-hw07-ip-smoke.txt
	$(JAVA) -cp $(BUILD_DIR) il.ac.tau.cs.software1.bufferedIO.BufferedIOTester

clean:
	rm -rf $(BUILD_DIR) resources/hw7/out
