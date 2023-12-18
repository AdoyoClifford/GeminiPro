package com.adoyo.geminipro.util

import com.adoyo.geminipro.BuildConfig

sealed class Resource<T>(val data: T?, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String,data: T?) : Resource<T>(message = message, data = data)
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>(null)
}

