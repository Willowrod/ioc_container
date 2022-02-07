package com.willowrod.ioccontainerexample

import com.willowrod.ioccontainerexample.container.IOCContainer
import com.willowrod.ioccontainerexample.examples.NumberGenerator
import com.willowrod.ioccontainerexample.examples.RandomNumber
import com.willowrod.ioccontainerexample.examples.SimpleInterface
import com.willowrod.ioccontainerexample.examples.StoredNumber
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun checkStoredNumber() {
        // Tests container stores a concrete implementation of an interface
        val container = IOCContainer()
        container.storeDependency<SimpleInterface>(StoredNumber())
        val storedNumber = container.retrieveDependency<SimpleInterface>()
        val secondStoredNumber = container.retrieveDependency<SimpleInterface>()
        assertNotEquals(-1,storedNumber?.returnANumber())
        assertEquals(secondStoredNumber?.returnANumber(),storedNumber?.returnANumber())
    }

    @Test
    fun checkRandomNumber() {
        // Tests container stores a different concrete implementation of an interface
        val container = IOCContainer()
        container.storeDependency<SimpleInterface>(RandomNumber())
        val randomNumber = container.retrieveDependency<SimpleInterface>()
        assertNotEquals(-1,randomNumber?.returnANumber())
        val secondRandomNumber = container.retrieveDependency<SimpleInterface>()
        assertNotEquals(secondRandomNumber?.returnANumber(),randomNumber?.returnANumber())
        val thirdRandomNumber = container.retrieveDependency<SimpleInterface>()
        assertEquals(-1,thirdRandomNumber?.returnANumber())
    }

    @Test
    fun checkStoredNumberFromInjectedClass() {
        // Tests container stores a concrete implementation of an interface and a transient object that depends on the implementation
        val container = IOCContainer()
        container.storeDependency<SimpleInterface>(StoredNumber())
        val storedNumber = container.retrieveDependency<SimpleInterface>()
        val numberGenerator = NumberGenerator(storedNumber)
        val secondStoredNumber = container.retrieveDependency<SimpleInterface>()
        assertNotEquals(-1,numberGenerator.returnNumberFromGenerator())
        assertEquals(numberGenerator.returnNumberFromGenerator(),numberGenerator.returnNumberFromGenerator())
        assertEquals(secondStoredNumber?.returnANumber(),storedNumber?.returnANumber())
    }

    @Test
    fun checkRandomNumberFromInjectedClass() {
        // Tests container stores a different concrete implementation of an interface and a transient object that depends on the implementation
        val container = IOCContainer()
        container.storeDependency<SimpleInterface>(RandomNumber())
        val storedNumber = container.retrieveDependency<SimpleInterface>()
        val numberGenerator = NumberGenerator(storedNumber)
        val secondStoredNumber = container.retrieveDependency<SimpleInterface>()
        assertNotEquals(-1,numberGenerator.returnNumberFromGenerator())
        assertNotEquals(numberGenerator.returnNumberFromGenerator(),numberGenerator.returnNumberFromGenerator())
        assertEquals(-1,storedNumber?.returnANumber())
    }
}