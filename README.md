# BSc Software 1 - Homework 7

- Course: BSc Computer Science.

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
