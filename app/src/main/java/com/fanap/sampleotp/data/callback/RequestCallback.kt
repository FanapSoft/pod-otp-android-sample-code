package com.fanap.sampleotp.data.callback

interface RequestCallback<T> {
    fun onRequestSuccess(result: T?)
    fun onRequestFailed(message: String?)
}