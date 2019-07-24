package com.fanap.sampleotp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fanap.sampleotp.R
import com.fanap.sampleotp.ui.main.MainActivity
import com.fanap.sampleotp.ui.login.identity.IdentityFragment
import com.fanap.sampleotp.ui.login.verify.VerifyFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var frg: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setIdentityFrg()
    }

    fun setIdentityFrg(){
        frg = IdentityFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, frg, frg.tag)
            .commit()
    }

    fun setVerifyFrg(){
        frg = VerifyFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame, frg, frg.tag)
            .addToBackStack(frg.tag)
            .commit()
    }

    fun startMainActivity(){
        startActivity(Intent(this@LoginActivity, MainActivity::class.java)
            .apply { flags = Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_NEW_TASK })
        finish()
    }
}
