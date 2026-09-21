# BSc Software 1 - Homework 7

- Course: BSc Computer Science.
- Available copy: May 2018.
- Assignment brief: The matching Homework 7 handout was not found.
- Maintenance changes: the current version normalizes source encoding and adds a local test harness, fixes the buffered writer implementation, makes IP representations compare consistently, and replaces the recovered buffered-I/O demo text with synthetic sample text.

## Contents

This homework contains three Java exercises:

- `il.ac.tau.cs.software1.predicate` - generic products, predicates, actions, store transformations, and default/static interface methods.
- `il.ac.tau.cs.software1.ip` - one IPv4 abstraction backed by string, integer, and short-array representations.
- `il.ac.tau.cs.software1.bufferedIO` - a small buffered writer wrapper over `FileWriter` plus a write-counting file writer.

## Tech Stack

- Java 8 language features, validated with Java 11 or newer.
- Plain `javac` and `java`; no external dependencies.
- `make` for repeatable compile, test, and cleanup commands.

## Run

```bash
make test
```

To remove generated files:

```bash
make clean
```
