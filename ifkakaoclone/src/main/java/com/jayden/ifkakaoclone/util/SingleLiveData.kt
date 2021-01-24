package com.jayden.ifkakaoclone.util

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveData<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasActiveObservers()) {
            Log.d("SingleLiveData", "Multiple observers registered but only one will be notified of changes.")
        }
        val wrapper = ObserverWrapper(observer, pending)

        super.observe(owner, wrapper)
    }

    @MainThread
    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
    }

    private class ObserverWrapper<T>(
        private val observer: Observer<T>,
        private val pending: AtomicBoolean
    ) : Observer<T> {

        override fun onChanged(t: T) {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }
}