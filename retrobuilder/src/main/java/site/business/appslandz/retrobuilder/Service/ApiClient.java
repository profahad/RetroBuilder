package site.business.appslandz.retrobuilder.Service;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import site.business.appslandz.retrobuilder.Interceptors.AuthInterceptor;
import site.business.appslandz.retrobuilder.Interfaces.AuthInitializer;
import timber.log.Timber;

public class ApiClient {

    private final String TAG = ApiClient.class.getSimpleName();

    private static ApiClient ourInstance = null;

    private Context context = null;

    private String baseUrl;

    public static ApiClient getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new ApiClient(context);
        return ourInstance;
    }

    private ApiClient(Context context) {
        this.context = context;
    }

    public ApiClient setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public Retrofit getClient() {

        Timber.plant(new Timber.DebugTree());

        // HttpLoggingInterceptor
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.i(message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    public Retrofit getAuthClient(AuthInitializer authInitializer) {

        Timber.plant(new Timber.DebugTree());

        // HttpLoggingInterceptor
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.i(message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        AuthInterceptor authInterceptor = new AuthInterceptor(authInitializer);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}