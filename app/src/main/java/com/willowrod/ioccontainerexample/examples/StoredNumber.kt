package com.willowrod.ioccontainerexample.examples

import kotlin.random.Random

class StoredNumber: SimpleInterface {
    private var storedNumber: Int? = null
    override fun returnANumber(): Int {
        storedNumber?.let { return it }
        storedNumber = Random.nextInt(0, 1000)
        return storedNumber ?: -1
    }
}