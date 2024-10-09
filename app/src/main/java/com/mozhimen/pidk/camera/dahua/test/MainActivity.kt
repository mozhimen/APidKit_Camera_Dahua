package com.mozhimen.pidk.camera.dahua.test

import android.Manifest
import android.os.Bundle
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.basick.manifestk.permission.ManifestKPermission
import com.mozhimen.basick.manifestk.permission.annors.APermissionCheck
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.pidk.camera.dahua.CameraKDahuaMgr
import com.mozhimen.pidk.camera.dahua.test.databinding.ActivityMainBinding

@APermissionCheck(
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.ACCESS_COARSE_LOCATION
)
class MainActivity : BaseActivityVDB<ActivityMainBinding>() {

    override fun initData(savedInstanceState: Bundle?) {
        ManifestKPermission.requestPermissions(this) {
            super.initData(savedInstanceState)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        CameraKDahuaMgr.instance.init { _, _, _ -> }

        vdb.btnIPLogin.setOnClickListener {
            startContext<IPLoginActivity>()
        }
    }

    override fun onDestroy() {
        CameraKDahuaMgr.instance.destroy()
        super.onDestroy()
    }
}


