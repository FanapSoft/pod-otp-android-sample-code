package com.fanap.sampleotp.data.model

data class NetworkState(var state: NetworkState, var message: String) {

    enum class NetworkState{
        LOADING, FAILED, SUCCESS
    }

    companion object{
        fun loading(message: String? = null) = NetworkState(NetworkState.LOADING, message ?: "LOADING")
        fun success(message: String? = null) = NetworkState(NetworkState.SUCCESS, message ?: "SUCCESS")
        fun faied(message: String? = null) = NetworkState(NetworkState.FAILED, message ?: "FAILED")
    }

}