package com.fanap.sampleotp.data.repository.abs

import com.fanap.sampleotp.data.callback.RequestCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class GeneralRepository<T>(val requestCallBack: RequestCallback<T>) {

    fun request(
        call: Call<T>
    ) {

        call.enqueue(object : Callback<T> {

            override fun onFailure(call: Call<T>, t: Throwable) {
                requestCallBack.onRequestFailed(t.message)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (!response.isSuccessful) {
                    requestCallBack.onRequestFailed(response.message() ?: response.errorBody().toString())
                    return
                }

                val body = response.body()
                if (body == null) {
                    requestCallBack.onRequestFailed("null body")
                    return
                }

                requestCallBack.onRequestSuccess(body)
            }

        })
    }
}