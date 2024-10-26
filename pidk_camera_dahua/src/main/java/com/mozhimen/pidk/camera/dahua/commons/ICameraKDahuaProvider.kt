package com.mozhimen.pidk.camera.dahua.commons

import com.company.netsdk.commons.ICameraKDisconnectListener
import com.mozhimen.pidk.camera.dahua.helpers.CapturePictureHelper
import com.mozhimen.pidk.camera.dahua.helpers.IPLoginHelper
import com.mozhimen.pidk.camera.dahua.helpers.LivePreviewHelper

/**
 * @ClassName ICameraKDahuaProvider
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/24 23:09
 * @Version 1.0
 */
interface ICameraKDahuaProvider {
    fun init(listener: ICameraKDisconnectListener)
    fun getIPLogin(): IPLoginHelper
    fun getLivePreview(): LivePreviewHelper
    fun getCapturePicture(): CapturePictureHelper
    fun destroy()
}