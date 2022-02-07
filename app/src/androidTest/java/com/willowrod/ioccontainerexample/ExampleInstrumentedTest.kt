package com.willowrod.ioccontainerexample

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.willowrod.ioccontainerexample.container.IOCContainer
import com.willowrod.ioccontainerexample.examples.SimpleInterface
import com.willowrod.ioccontainerexample.examples.StoredNumber

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.willowrod.ioccontainerexample", appContext.packageName)
    }

    @Test
    fun checkStoredNumber() {
        val container = IOCContainer()
        container.storeDependency<SimpleInterface>(StoredNumber())
        val storedNumber = container.retrieveDependency<SimpleInterface>(SimpleInterface::class)
        assertEquals(-1,storedNumber?.returnANumber())
    }
}