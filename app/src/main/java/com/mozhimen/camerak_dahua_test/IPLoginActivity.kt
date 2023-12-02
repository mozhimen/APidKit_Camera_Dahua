package com.mozhimen.camerak_dahua_test

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.mozhimen.basick.cachek.sharedpreferences.CacheKSP
import com.mozhimen.basick.elemk.androidx.appcompat.bases.BaseActivityVB
import com.mozhimen.basick.utilk.android.content.startContext
import com.mozhimen.basick.utilk.android.widget.showToast
import com.mozhimen.camerak_dahua.CameraKDahuaMgr
import com.mozhimen.camerak_dahua_test.databinding.ActivityIpLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IPLoginActivity : BaseActivityVB<ActivityIpLoginBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        vb.cbIsSave.isChecked = IPLoginSP.isSave
        if (IPLoginSP.isSave) {
            vb.etAddress.setText(IPLoginSP.address)
            vb.etPort.setText(IPLoginSP.port)
            vb.etAdmin.setText(IPLoginSP.admin)
            vb.etPwd.setText(IPLoginSP.pwd)
        }
        vb.btnLogin.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                login(
                    vb.etAddress.text.toString(),
                    vb.etPort.text.toString(),
                    vb.etAdmin.text.toString(),
                    vb.etPwd.text.toString()
                )
            }
        }
        vb.eyeButtonIp.bindEditText(vb.etPwd)
    }

    override fun onResume() {
        super.onResume()
        CameraKDahuaMgr.instance.getIPLogin().logout()
    }

    override fun onDestroy() {
        CameraKDahuaMgr.instance.getIPLogin().logout()
        super.onDestroy()
    }

    private fun checkEdit(address: String, port: String, admin: String, pwd: String): Boolean {
        return address.isNotEmpty() && port.isNotEmpty() && admin.isNotEmpty() && pwd.isNotEmpty()
    }

    private suspend fun login(address: String, port: String, admin: String, pwd: String) {
        if (!checkEdit(address, port, admin, pwd)) return
        var result: Boolean
        withContext(Dispatchers.IO) {
            result = CameraKDahuaMgr.instance.getIPLogin().login(address, port, admin, pwd)
        }
        if (result) {
            saveInfo(vb.cbIsSave.isChecked, address, port, admin, pwd)
            delay(200)
            startContext<FunctionListActivity>()
        } else {
            CameraKDahuaMgr.instance.getIPLogin().getErrorMsg().showToast()
        }
    }

    private fun saveInfo(isSave: Boolean, address: String, port: String, admin: String, pwd: String) {
        if (isSave) {
            IPLoginSP.apply {
                IPLoginSP.isSave = isSave
                IPLoginSP.address = address
                IPLoginSP.port = port
                IPLoginSP.admin = admin
                IPLoginSP.pwd = pwd
            }
        }
    }

    private object IPLoginSP {
        private val _loginInfoSP = CacheKSP.instance.with("ip_login")

        var isSave: Boolean
            set(value) {
                _loginInfoSP.putBoolean("isSave", value)
            }
            get() {
                return _loginInfoSP.getBoolean("isSave", false)
            }
        var address: String
            set(value) {
                _loginInfoSP.putString("address", value)
            }
            get() {
                return _loginInfoSP.getString("address")!!
            }

        var port: String
            set(value) {
                _loginInfoSP.putString("port", value)
            }
            get() {
                return _loginInfoSP.getString("port")!!
            }

        var admin: String
            set(value) {
                _loginInfoSP.putString("admin", value)
            }
            get() {
                return _loginInfoSP.getString("admin")!!
            }

        var pwd: String
            set(value) {
                _loginInfoSP.putString("pwd", value)
            }
            get() {
                return _loginInfoSP.getString("pwd")!!
            }
    }
}