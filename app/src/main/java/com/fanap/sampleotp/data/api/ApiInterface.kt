package com.fanap.sampleotp.data.api

import com.fanap.sampleotp.data.model.Credential
import com.fanap.sampleotp.data.model.srv.IdentitySrv
import com.fanap.sampleotp.data.model.srv.VerifySrv
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *
 * Created by A.Rokni
 * on Tue, 22 January 2019 at 1:14 PM.
 */
interface ApiInterface {

    @POST("/otp/identity")
    fun submitIdentity(@Body identity: IdentitySrv): Call<Boolean>

    @POST("/otp/verify")
    fun verifyIdentity(@Body verify: VerifySrv): Call<Credential>
}