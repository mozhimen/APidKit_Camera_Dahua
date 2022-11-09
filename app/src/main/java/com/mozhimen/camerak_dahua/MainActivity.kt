package com.mozhimen.camerak_dahua

import android.Manifest
import android.os.Bundle
import com.mozhimen.basick.basek.BaseKActivityVB
import com.mozhimen.basick.extsk.start
import com.mozhimen.camerak_dahua.databinding.ActivityMainBinding
import com.mozhimen.componentk.permissionk.PermissionK
import com.mozhimen.componentk.permissionk.annors.APermissionK

@APermissionK(
    permissions = [
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ]
)
class MainActivity : BaseKActivityVB<ActivityMainBinding>() {

    override fun initData(savedInstanceState: Bundle?) {
        PermissionK.initPermissions(this) {
            initView(savedInstanceState)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        CameraKDahuaMgr.instance.init()

        vb.btnIPLogin.setOnClickListener {
            start<IPLoginActivity>()
        }
    }

    override fun onDestroy() {
        CameraKDahuaMgr.instance.destroy()
        super.onDestroy()
    }
}


