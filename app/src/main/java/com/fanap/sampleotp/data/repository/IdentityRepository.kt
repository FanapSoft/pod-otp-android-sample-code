package com.fanap.sampleotp.data.repository

import androidx.lifecycle.MutableLiveData
import com.fanap.sampleotp.data.callback.SimpleCallback
import com.fanap.sampleotp.data.model.NetworkState
import com.fanap.sampleotp.data.repository.abs.GeneralRepository

class IdentityRepository(state: MutableLiveData<NetworkState>, data: MutableLiveData<Boolean>) :
    GeneralRepository<Boolean>(SimpleCallback(state, data))