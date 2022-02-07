package com.willowrod.ioccontainerexample.container

class IOCObject(
    private val kClassImplementation: Any
)
{
    fun <T> retrieveImplementation(): T{
        return kClassImplementation as T
    }
}