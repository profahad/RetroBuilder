package site.business.appslandz.retrobuilder.Service

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.business.appslandz.retrobuilder.Interceptors.AuthInterceptor
import site.business.appslandz.retrobuilder.Interfaces.AuthInitializer
import timber.log.Timber
import timber.log.Timber.DebugTree

class ApiClient private constructor(context: Context) {

    private val TAG = ApiClient::class.java.simpleName
    private var context: Context? = null
    private var baseUrl: String = ""

    init {
        this.context = context
    }

    // HttpLoggingInterceptor
    val client: Retrofit
        get() {
            Timber.plant(DebugTree())
            // HttpLoggingInterceptor
            val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Timber.i(message)
                }
            })
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(this.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
        }

    fun getAuthClient(authInitializer: AuthInitializer?): Retrofit {
        Timber.plant(DebugTree())
        // HttpLoggingInterceptor
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.i(message)
            }
        })
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val authInterceptor = AuthInterceptor(authInitializer!!)
        val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authInterceptor)
                .build()
        return Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    companion object {

        private var ourInstance: ApiClient? = null

        @kotlin.jvm.JvmStatic
        fun getInstance(context: Context): ApiClient {
            if (ourInstance != null) {
                return ourInstance as ApiClient
            }
            ourInstance = ApiClient(context)
            return ourInstance as ApiClient
        }
    }

    fun setBaseUrl(baseUrl: String): ApiClient {
        this.baseUrl = baseUrl
        return this
    }


}