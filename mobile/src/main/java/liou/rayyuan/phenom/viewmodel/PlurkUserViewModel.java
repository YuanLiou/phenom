package liou.rayyuan.phenom.viewmodel;

import android.net.Uri;

import liou.rayyuan.phenom.model.AvatarService;
import liou.rayyuan.phenom.model.domain.PlurkUsersDetail;

/**
 * Created by louis383 on 2016/6/6.
 */

public class PlurkUserViewModel {

    private PlurkUsersDetail plurkUsers;
    private AvatarService avatarService;

    public PlurkUserViewModel(PlurkUsersDetail plurkUsers) {
        this.plurkUsers = plurkUsers;

        avatarService = new AvatarService(plurkUsers.getId(), plurkUsers);
    }

    public String getUserDisplayName() {
        return plurkUsers.getDisplayName();
    }

    public String getUserId() {
        return plurkUsers.getId();
    }

    public Uri getUserAvatar(AvatarService.ImageSize imageSize) {
        return avatarService.getAvatarUri(imageSize);
    }
}
