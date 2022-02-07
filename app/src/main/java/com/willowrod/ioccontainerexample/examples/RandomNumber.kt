package com.willowrod.ioccontainerexample.examples

import kotlin.random.Random

class RandomNumber: SimpleInterface {
    private var pickedNumbers: ArrayList<Int> = ArrayList()
    override fun returnANumber(): Int {
        if (pickedNumbers.count() >= 2){
            return -1
        }
        var newNumber = -1
        do {
             newNumber = Random.nextInt(0, 1000)
        } while (pickedNumbers.contains(newNumber))
        pickedNumbers.add(newNumber)
        return newNumber
    }
}