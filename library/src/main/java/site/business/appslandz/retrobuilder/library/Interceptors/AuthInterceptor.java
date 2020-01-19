package site.business.appslandz.retrobuilder.library.Interceptors;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import site.business.appslandz.retrobuilder.library.Interfaces.AuthInitializer;
import timber.log.Timber;

public class AuthInterceptor implements Interceptor {

    private AuthInitializer authInitializer;

    public AuthInterceptor(AuthInitializer authInitializer) {
        this.authInitializer = authInitializer;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Timber.e("%s",authInitializer.getBearerToken());
        Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", authInitializer.getBearerToken())
                .build();
        return chain.proceed(request);
    }
}
