package forum.services.user;

import forum.entity.User;

import java.util.List;

public interface UserService {

    void register(User user);
    void deleteUser(long id);
    User login(String userName , String password);
    List<User> getAllUsers();
    void changePassword(String userName,String email,String newPassword);
    void newAdmin(long id);
    void newModeraor(long id);
    void deleteAdmin(long id);
    void deleteModerator(long id);

}
