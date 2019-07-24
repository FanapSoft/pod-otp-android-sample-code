package com.fanap.sampleotp.data.model

/**
 *
 * Created by A.Rokni
 * on Sun, 17 February 2019 at 6:45 PM.
 */
data class Credential(
    var access_token: String,
    var id_token: String,
    var refresh_token: String,
    var expires_in: Int,
    var token_type: String,
    var scope: String
)