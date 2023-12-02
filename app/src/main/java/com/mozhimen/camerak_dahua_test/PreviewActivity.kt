package com.mozhimen.camerak_dahua_test

import android.os.Bundle
import android.view.SurfaceHolder
import com.mozhimen.basick.elemk.androidx.appcompat.bases.BaseActivityVB
import com.mozhimen.camerak_dahua.CameraKDahuaMgr
import com.mozhimen.camerak_dahua_test.databinding.ActivityPreviewBinding


/**
 * @ClassName PreviewActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/9 11:14
 * @Version 1.0
 */
class PreviewActivity : BaseActivityVB<ActivityPreviewBinding>() {
    private val _surfaceView by lazy { vb.previewSurface }
    private val _surfaceCallback by lazy {
        object : SurfaceHolder.Callback {
            override fun surfaceCreated(p0: SurfaceHolder) {
                CameraKDahuaMgr.instance.getLivePreview().initSurfaceView(_surfaceView)
            }

            override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
            }

            override fun surfaceDestroyed(p0: SurfaceHolder) {
            }
        }
    }
    private var _isStartPreview = false

    override fun initView(savedInstanceState: Bundle?) {
        _surfaceView.holder.addCallback(_surfaceCallback)
        vb.previewBtnStart.setOnClickListener {
            if (_isStartPreview) return@setOnClickListener
            CameraKDahuaMgr.instance.getLivePreview().startPlay(CameraKDahuaMgr.instance.getIPLogin().getLoginHandle(), 0, 0, _surfaceView)
            _isStartPreview = true
        }

        vb.previewBtnEnd.setOnClickListener {
            if (!_isStartPreview) return@setOnClickListener
            CameraKDahuaMgr.instance.getLivePreview().stopPlay()
            _isStartPreview = false
        }
    }

    override fun onDestroy() {
        CameraKDahuaMgr.instance.getLivePreview().stopPlay()
        super.onDestroy()
    }
}