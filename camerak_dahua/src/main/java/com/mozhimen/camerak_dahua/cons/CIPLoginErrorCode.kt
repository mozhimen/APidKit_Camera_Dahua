package com.mozhimen.camerak_dahua.cons

import com.company.NetSDK.FinalVar
import com.mozhimen.basick.utilk.UtilKRes
import com.mozhimen.camerak_dahua.R


/**
 * @ClassName CIPLoginErrorCode
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/9 10:35
 * @Version 1.0
 */
object CIPLoginErrorCode {
    const val NET_USER_FLASEPWD_TRYTIME = FinalVar.NET_USER_FLASEPWD_TRYTIME
    const val NET_LOGIN_ERROR_PASSWORD = FinalVar.NET_LOGIN_ERROR_PASSWORD
    const val NET_LOGIN_ERROR_USER = FinalVar.NET_LOGIN_ERROR_USER
    const val NET_LOGIN_ERROR_TIMEOUT = FinalVar.NET_LOGIN_ERROR_TIMEOUT
    const val NET_LOGIN_ERROR_RELOGGIN = FinalVar.NET_LOGIN_ERROR_RELOGGIN
    const val NET_LOGIN_ERROR_LOCKED = FinalVar.NET_LOGIN_ERROR_LOCKED
    const  val NET_LOGIN_ERROR_BLACKLIST = FinalVar.NET_LOGIN_ERROR_BLACKLIST
    const val NET_LOGIN_ERROR_BUSY = FinalVar.NET_LOGIN_ERROR_BUSY
    const val NET_LOGIN_ERROR_CONNECT = FinalVar.NET_LOGIN_ERROR_CONNECT
    const val NET_LOGIN_ERROR_NETWORK = FinalVar.NET_LOGIN_ERROR_NETWORK

    fun getErrorCode(errorCode: Int): String {
        return when (errorCode) {
            NET_USER_FLASEPWD_TRYTIME -> UtilKRes.getString(R.string.NET_USER_FLASEPWD_TRYTIME)
            NET_LOGIN_ERROR_PASSWORD -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_PASSWORD)
            NET_LOGIN_ERROR_USER -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_USER)
            NET_LOGIN_ERROR_TIMEOUT -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_TIMEOUT)
            NET_LOGIN_ERROR_RELOGGIN -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_RELOGGIN)
            NET_LOGIN_ERROR_LOCKED -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_LOCKED)
            NET_LOGIN_ERROR_BLACKLIST -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_BLACKLIST)
            NET_LOGIN_ERROR_BUSY -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_BUSY)
            NET_LOGIN_ERROR_CONNECT -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_CONNECT)
            NET_LOGIN_ERROR_NETWORK -> UtilKRes.getString(R.string.NET_LOGIN_ERROR_NETWORK)
            else -> UtilKRes.getString(R.string.NET_ERROR)
        }
    }
}