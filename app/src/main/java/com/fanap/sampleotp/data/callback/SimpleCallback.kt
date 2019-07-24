package com.fanap.sampleotp.data.callback

import androidx.lifecycle.MutableLiveData
import com.fanap.sampleotp.data.model.NetworkState

class SimpleCallback<T>(var liveObject: MutableLiveData<NetworkState>, var data: MutableLiveData<T>) :
    RequestCallback<T> {

    override fun onRequestSuccess(result: T?) {
        data.value = result
        liveObject.value =  NetworkState.success()
    }

    override fun onRequestFailed(message: String?) {
        liveObject.value = NetworkState.faied(message)
    }
}