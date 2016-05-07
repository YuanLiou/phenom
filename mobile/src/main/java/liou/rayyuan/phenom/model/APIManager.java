package liou.rayyuan.phenom.model;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import liou.rayyuan.phenom.BuildConfig;
import liou.rayyuan.phenom.model.domain.Page;
import liou.rayyuan.phenom.model.entity.PlurkUser;
import liou.rayyuan.phenom.model.entity.deserializer.PlurkUsersDeserializer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by louis383 on 16/4/17.
 */
public class APIManager {

    private APIEndpoint endpoint;

    private String baseUrl = "http://www.plurk.com/APP/";

    public APIManager(String token, String tokenSecret) {
        setAPIManager(token, tokenSecret);
    }

    private void setAPIManager(String accessToken, String accessSecret) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(BuildConfig.PLURK_APPKEY, BuildConfig.PLURK_APPSECRET);
        consumer.setTokenWithSecret(accessToken, accessSecret);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .addInterceptor(logging)
                .readTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PlurkUser.class, new PlurkUsersDeserializer());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(client)
                .build();

        endpoint = retrofit.create(APIEndpoint.class);
    }

    public Observable<Response<Page>> getTimelimePlurks(String offset) {
        return endpoint.fetchTimelinePlurks(offset, 20, true)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
