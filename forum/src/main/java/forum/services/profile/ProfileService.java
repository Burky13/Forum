package forum.services.profile;

import forum.entity.Profile;
import forum.entity.User;

public interface ProfileService {
    public void addOrEditProfile(Profile profile,User user );
    public Profile showProfile(User user);
    Profile getProfile(User user);
}
