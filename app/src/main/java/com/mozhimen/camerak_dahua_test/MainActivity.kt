package com.mozhimen.camerak_dahua_test

import android.Manifest
import android.os.Bundle
import com.company.netsdk.commons.IDisconnectListener
import com.mozhimen.basick.elemk.activity.bases.BaseActivityVB
import com.mozhimen.basick.manifestk.permission.ManifestKPermission
import com.mozhimen.basick.manifestk.permission.annors.APermissionCheck
import com.mozhimen.basick.utilk.exts.start
import com.mozhimen.camerak_dahua.CameraKDahuaMgr
import com.mozhimen.camerak_dahua_test.databinding.ActivityMainBinding

@APermissionCheck(
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.ACCESS_COARSE_LOCATION
)
class MainActivity : BaseActivityVB<ActivityMainBinding>() {

    override fun initData(savedInstanceState: Bundle?) {
        ManifestKPermission.initPermissions(this) {
            super.initData(savedInstanceState)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        CameraKDahuaMgr.instance.init { _, _, _ -> }

        vb.btnIPLogin.setOnClickListener {
            start<IPLoginActivity>()
        }
    }

    override fun onDestroy() {
        CameraKDahuaMgr.instance.destroy()
        super.onDestroy()
    }
}


