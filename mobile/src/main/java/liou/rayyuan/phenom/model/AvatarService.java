package liou.rayyuan.phenom.model;

import android.net.Uri;

import liou.rayyuan.phenom.model.domain.PlurkUsersDetail;

/**
 * Created by louis383 on 2016/6/10.
 */

public class AvatarService {

    public enum ImageSize {
        SMALL,
        MEDIUM,
        BIG
    }

    private static final String avatarHost = "http://avatars.plurk.com/";
    private static final String avatarStaticHost = "http://www.plurk.com/static/";

    private PlurkUsersDetail usersDetail;
    private String userId;

    public AvatarService(String userId, PlurkUsersDetail usersDetail) {
        this.userId = userId;
        this.usersDetail = usersDetail;
    }

    public Uri getAvatarUri(ImageSize size) {
        String imageUrl = "";
        if (usersDetail.getHasProfileImage() == 1 && usersDetail.getAvatar() == 0) {
            switch (size) {
                case SMALL:
                    imageUrl = avatarHost + userId + "-small.gif";
                    break;
                case MEDIUM:
                    imageUrl = avatarHost + userId + "-medium.gif";
                    break;
                case BIG:
                    imageUrl = avatarHost + userId + "-big.jpg";
                    break;
            }
        } else if (usersDetail.getHasProfileImage() == 1 && usersDetail.getAvatar() != 0) {
            switch (size) {
                case SMALL:
                    imageUrl = avatarHost + userId + "-small" + usersDetail.getAvatar() + ".gif";
                    break;
                case MEDIUM:
                    imageUrl = avatarHost + userId + "-medium" + usersDetail.getAvatar() + ".gif";
                    break;
                case BIG:
                    imageUrl = avatarHost + userId + "-big" + usersDetail.getAvatar() + ".jpg";
                    break;
            }
        } else if (usersDetail.getHasProfileImage() == 0) {
            switch (size) {
                case SMALL:
                    imageUrl = avatarStaticHost + "default_small.gif";
                    break;
                case MEDIUM:
                    imageUrl = avatarStaticHost + "default_medium.gif";
                    break;
                case BIG:
                    imageUrl = avatarStaticHost + "default_big.gif";
                    break;
            }
        }

        return Uri.parse(imageUrl);
    }
}
