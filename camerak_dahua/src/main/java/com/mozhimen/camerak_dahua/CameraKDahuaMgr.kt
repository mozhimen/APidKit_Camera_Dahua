package com.mozhimen.camerak_dahua

import com.company.netsdk.common.NetSDKLib
import com.mozhimen.basick.utilk.UtilKDate
import com.mozhimen.basick.utilk.context.UtilKApplication
import com.mozhimen.basick.utilk.file.UtilKFile
import com.mozhimen.camerak_dahua.helpers.IPLoginHelper
import com.mozhimen.camerak_dahua.helpers.LivePreviewHelper


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

    private val _context by lazy { UtilKApplication.instance.get() }
    private val _ipLoginHelper by lazy { IPLoginHelper() }
    private val _livePreviewHelper by lazy { LivePreviewHelper() }
    private val _cameraLogPath by lazy { _context.cacheDir.absolutePath + "/camerak_dahua/${UtilKDate.getNowLong()}.log" }

    fun init() {
        NetSDKLib.getInstance().init()
        UtilKFile.createFile(_cameraLogPath)
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
}