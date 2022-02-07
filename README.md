# Kotlin IoC container

This repository contains a (very) simple Inversion of Control container, dealing specifically with dependency injection of both Interface implementations and Transient Objects.

The container should be created once and accessed where needed, in an Android application, this might be in your custom Application class or your Activity, in a single Activity application

To create the container, simply call it's constructor:

``` Kotlin
   val container = IOCContainer()
```

## Registering components

To register a component in the container, the following method is used:

inline fun <reified I> storeDependency(concreteObject: Any)

For example:
``` Kotlin
    container.storeDependency<SimpleInterface>(SimpleInterfaceImpl())
```

or:
``` Kotlin
    container.storeDependency<MyClass>(MyClass())
```

## Retrieving components

To retrieve a component, use the following method:

inline fun <reified T> retrieveDependency(): T?

For example:

``` Kotlin
val storedImplementation = container.retrieveDependency<SimpleInterface>()
```

## Unit tests

The repository contains unit tests that test storing and retrieving components in the container, it also contains a simple interface and 2 separate implementations of that interface, plus an example transient class, all of which are used in the unit tests
