package com.doubtnut.awesomeai.data.remote.retrofit.interceptor

import android.content.Context
import androidx.core.content.edit
import com.doubtnut.awesomeai.shared.AppConstant
import com.doubtnut.awesomeai.util.extension.common.AppUtil
import com.doubtnut.awesomeai.util.extension.defaultPrefs
import com.doubtnut.awesomeai.util.extension.preference.AuthConstants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.HttpURLConnection

class RefreshTokenInterceptor(
    private val mContext: Context
) : Interceptor {

    companion object {
        private const val TAG = "RefreshTokenInterceptor"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = defaultPrefs(mContext)
            .getString(AuthConstants.XAUTH_HEADER_TOKEN, "")
        val request = chain
            .request()
            .newBuilder()
            .apply {
                if (!token.isNullOrBlank()) {
                    removeHeader(AuthConstants.XAUTH_HEADER_TOKEN)
                    addHeader(
                        AuthConstants.XAUTH_HEADER_TOKEN,
                        token
                    )
                }
            }
            .addHeader(AppConstant.VERSION_CODE, AppUtil.getVersionCode())
            .addHeader(AppConstant.DEVICE_MODEL, AppUtil.getDeviceModel())
            .build()

        var response = chain.proceed(request)
        if (!response.isSuccessful && response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
            synchronized(this) {
                if (!token.isNullOrBlank()) {
                    val refreshToken =
                        defaultPrefs().getString(AuthConstants.XAUTH_HEADER_REFRESH_TOKEN, "")
                            .orEmpty()
                    val builder = request.newBuilder()
                    builder.header(AuthConstants.XAUTH_HEADER_TOKEN, token)
                    builder.header(AuthConstants.XAUTH_HEADER_REFRESH_TOKEN, refreshToken)
                    builder.removeHeader(AuthConstants.XAUTH_HEADER_TOKEN)
                    response = chain.proceed(builder.build())

                    if (!response.isSuccessful && response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
                        // ToDo - logout user
                    } else {
                        updateToken(
                            response.header(AuthConstants.RESPONSE_XAUTH_HEADER_TOKEN),
                            response.header(AuthConstants.RESPONSE_XAUTH_HEADER_REFRESH_TOKEN)
                        )
                        return response
                    }
                }
            }
        }

        updateToken(
            response.header(AuthConstants.RESPONSE_XAUTH_HEADER_TOKEN),
            response.header(AuthConstants.RESPONSE_XAUTH_HEADER_REFRESH_TOKEN)
        )
        return response
    }

    private fun updateToken(token: String?, refreshToken: String?) {
        if (!token.isNullOrBlank()) {
            defaultPrefs().edit(true) {
                putString(AuthConstants.XAUTH_HEADER_TOKEN, token)
            }
        }

        if (!refreshToken.isNullOrBlank()) {
            defaultPrefs().edit(true) {
                putString(AuthConstants.XAUTH_HEADER_REFRESH_TOKEN, refreshToken)
            }
        }
    }
}
