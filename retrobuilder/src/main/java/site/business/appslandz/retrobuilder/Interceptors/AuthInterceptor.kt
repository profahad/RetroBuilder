package site.business.appslandz.retrobuilder.Interceptors

import okhttp3.Interceptor
import okhttp3.Response
import site.business.appslandz.retrobuilder.Interfaces.AuthInitializer
import timber.log.Timber
import java.io.IOException

class AuthInterceptor(val authInitializer: AuthInitializer) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        Timber.e("%s", authInitializer.bearerToken)
        val request = authInitializer.bearerToken?.let {
            chain.request()
                .newBuilder()
                .addHeader("Authorization", it)
                .build()
        } ?:run {
            chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "")
                    .build()
        }
        return chain.proceed(request)
    }

}