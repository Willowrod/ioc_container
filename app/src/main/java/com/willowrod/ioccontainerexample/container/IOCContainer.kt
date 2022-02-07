package com.willowrod.ioccontainerexample.container

class IOCContainer {
    var iocContainer: MutableMap<String, IOCObject> = mutableMapOf()

    inline fun <reified I> storeDependency(concreteObject: Any){
        I::class.simpleName?.let {dependencyIdentifier ->
            iocContainer[dependencyIdentifier] = IOCObject(concreteObject)
        }
    }

    inline fun <reified T> retrieveDependency(): T? {
        T::class.simpleName?.let { dependencyIdentifier ->
            iocContainer[dependencyIdentifier]?.let { resolvedObject ->
                return resolvedObject.retrieveImplementation()
            }
        }
        return null
    }


}