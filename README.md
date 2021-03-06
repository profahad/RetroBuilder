# RetroBuilder
RetroBuilder is an helper module for retrofit with added new features like authentication interceptor, enabled logging interceptor, and gson interceptor. Now migrated to kotlin.

[ ![Download](https://api.bintray.com/packages/profahad/maven/site.business.appslandz.retrobuilder/images/download.svg) ](https://bintray.com/profahad/maven/site.business.appslandz.retrobuilder/_latestVersion)

# Installation

## Add the jCenter repository to your build file

```gradle
repositories {
    jcenter()
}
```
## Add the dependency
```gradle
dependencies {
    implementation 'site.business.appslandz:retrobuilder:X.X.X'
}
```

## Add Compatibility version tag
```gradle
android {
    ...
    ....
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

## Usage

## i. Retrofit api service interface
```java 
public interface ApiInterface {

    @GET("/api/users")
    Call<ApiResponse<List<User>>> getAllUsers();

}
```

## ii. Create auth call with bearer

```java
 
Call<ApiResponse<List<User>>> call = ApiClient.getInstance(this)
        .setBaseUrl("https://reqres.in")
        .getAuthClient(new AuthInitializer() {
            @Override
            public String getBearerToken() {
                 return "Bearer 129318309809843589350938509893540832945";
            }}).create(ApiInterface.class)
               .getAllUsers();
```

## Or create simple call

```java
 
Call<ApiResponse<List<User>>> call = ApiClient.getInstance(this)
                .setBaseUrl("https://reqres.in")
                .getClient().create(ApiInterface.class)
                .getAllUsers();

```

## iii. Enqueue call to request queue

```java
call.enqueue(new Callback<ApiResponse<List<User>>>() {
     @Override
     public void onResponse(Call<ApiResponse<List<User>>> call, Response<ApiResponse<List<User>>> respons
            Timber.i(response.body().toString());
     }
     
     @Override
     public void onFailure(Call<ApiResponse<List<User>>> call, Throwable t) {
        call.cancel();
     }});
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


## License
[Apache 2.0](http://www.opensource.org/licenses/apache2.0.php)
