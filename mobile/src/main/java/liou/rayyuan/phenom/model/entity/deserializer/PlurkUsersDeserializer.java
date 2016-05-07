package liou.rayyuan.phenom.model.entity.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import liou.rayyuan.phenom.model.domain.PlurkUsersDetail;
import liou.rayyuan.phenom.model.entity.PlurkUser;

/**
 * Created by louis383 on 16/5/7.
 */
public class PlurkUsersDeserializer implements JsonDeserializer<PlurkUser> {

    @Override
    public PlurkUser deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PlurkUser plurkUser = new PlurkUser();

        JsonObject jsonObject = json.getAsJsonObject();
        String plurkUsers = jsonObject.toString();

        Map<String, PlurkUsersDetail> plurkUsersMap = gson.fromJson(plurkUsers, new TypeToken<Map<String, PlurkUsersDetail>>(){}.getType());
        plurkUser.setResultMap(plurkUsersMap);

        return plurkUser;
    }
}
