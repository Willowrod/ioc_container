package com.willowrod.ioccontainerexample.examples

class NumberGenerator (private val numberGenerator: SimpleInterface?){

    fun returnNumberFromGenerator(): Int?{
        return numberGenerator?.returnANumber()
    }

}