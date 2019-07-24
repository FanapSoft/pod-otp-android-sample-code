package com.fanap.sampleotp.ui.login.verify

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.fanap.sampleotp.R
import com.fanap.sampleotp.data.model.NetworkState
import com.fanap.sampleotp.ui.login.LoginActivity
import kotlinx.android.synthetic.main.identity_fragment.*
import kotlinx.android.synthetic.main.identity_fragment.submit
import kotlinx.android.synthetic.main.verify_fragment.*
import org.jetbrains.anko.support.v4.toast

class VerifyFragment : Fragment() {

    companion object {
        fun newInstance() = VerifyFragment()
    }

    private lateinit var viewModel: VerifyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.verify_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VerifyViewModel::class.java)
        viewModel.networkState.observe(this@VerifyFragment, Observer { networkStateObserver(it) })
        submit.setOnClickListener { onSubmitClickListener(it) }
    }

    private fun onSubmitClickListener(view: View?) {
        if (identity_input.text.isNotBlank()){
            viewModel.submitVerify(verify_input.text.trim().toString())
        } else {
            verify_input.error = getString(R.string.required_text)
        }
    }

    private fun networkStateObserver(state: NetworkState) {
        when(state.state){
            NetworkState.NetworkState.LOADING -> {
                toast(state.message)
            }
            NetworkState.NetworkState.FAILED -> {
                toast(state.message)
            }
            NetworkState.NetworkState.SUCCESS -> {
                //TODO: you can get credential from ViewModel.data.value and save it!
                (activity as LoginActivity).startMainActivity()
            }
        }
    }

}
