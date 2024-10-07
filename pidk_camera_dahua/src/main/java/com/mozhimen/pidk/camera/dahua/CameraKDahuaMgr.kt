package com.mozhimen.pidk.camera.dahua

import com.company.netsdk.NetSDKLib
import com.company.netsdk.commons.ICameraKDisconnectListener
import com.mozhimen.kotlin.utilk.android.app.UtilKApplicationWrapper
import com.mozhimen.kotlin.utilk.java.util.UtilKDate
import com.mozhimen.kotlin.utilk.java.util.UtilKDateWrapper
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.pidk.camera.dahua.helpers.CapturePictureHelper
import com.mozhimen.pidk.camera.dahua.helpers.IPLoginHelper
import com.mozhimen.pidk.camera.dahua.helpers.LivePreviewHelper


/**
 * @ClassName CameraKDahuaMgr
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/8 17:12
 * @Version 1.0
 */
class CameraKDahuaMgr {
    companion object {
        @JvmStatic
        val instance = CameraKDahuaProvider.holder
    }

    private object CameraKDahuaProvider {
        val holder = CameraKDahuaMgr()
    }

    private val _context by lazy { UtilKApplicationWrapper.instance.get() }
    private val _ipLoginHelper by lazy { IPLoginHelper() }
    private val _livePreviewHelper by lazy { LivePreviewHelper() }
    private val _capturePictureHelper by lazy { CapturePictureHelper() }
    private val _cameraLogPath by lazy { _context.cacheDir.absolutePath + "/camerak_dahua/${UtilKDateWrapper.getNowLong()}.log" }

    fun init(listener: ICameraKDisconnectListener) {
        NetSDKLib.getInstance().init(listener)
        UtilKStrFile.createFile(_cameraLogPath)
        NetSDKLib.getInstance().openLog(_cameraLogPath)
    }

    fun destroy() {
        NetSDKLib.getInstance().cleanup()
    }

    fun getIPLogin(): IPLoginHelper {
        return _ipLoginHelper
    }

    fun getLivePreview(): LivePreviewHelper {
        return _livePreviewHelper
    }

    fun getCapturePicture(): CapturePictureHelper {
        return _capturePictureHelper
    }
}