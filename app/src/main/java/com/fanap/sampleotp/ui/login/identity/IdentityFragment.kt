package com.fanap.sampleotp.ui.login.identity

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
import org.jetbrains.anko.support.v4.toast


class IdentityFragment : Fragment() {

    companion object {
        fun newInstance() = IdentityFragment()
    }

    private lateinit var viewModel: IdentityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.identity_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IdentityViewModel::class.java)
        viewModel.networkState.observe(this@IdentityFragment, Observer { networkStateObserver(it) })
        submit.setOnClickListener { onSubmitClickListener(it) }
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
                (activity as LoginActivity).setVerifyFrg()
            }
        }
    }

    private fun onSubmitClickListener(view: View?) {
        if (identity_input.text.isNotBlank()){
            viewModel.submitIdentity(identity_input.text.trim().toString())
        } else {
            identity_input.error = getString(R.string.required_text)
        }
    }

}
