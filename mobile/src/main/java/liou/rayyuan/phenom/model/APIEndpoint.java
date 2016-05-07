package liou.rayyuan.phenom.model;

import liou.rayyuan.phenom.model.domain.Page;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by louis383 on 16/4/17.
 */
public interface APIEndpoint {

    @GET("Timeline/getPlurks")
    Observable<Response<Page>> fetchTimelinePlurks(@Query("offset") String offset, @Query("limit") int limit, @Query("minimal_data") boolean isMinimal);

}
