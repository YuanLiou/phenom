package liou.rayyuan.phenom.model;

import liou.rayyuan.phenom.model.domain.Me;
import liou.rayyuan.phenom.model.domain.Page;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by louis383 on 16/4/17.
 */
public interface PlurkService {

    @GET("Timeline/getPlurks")
    Observable<Response<Page>> fetchTimelinePlurks(@Query("offset") String offset, @Query("limit") int limit, @Query("minimal_data") boolean isMinimal);

    @GET("Users/me")
    Observable<Response<Me>> fetchMe();

    @POST("/APP/expireToken")
    Call<Void> expireToken();

}
