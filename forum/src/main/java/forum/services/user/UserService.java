package forum.services.user;

import forum.entity.User;

import java.util.List;

public interface UserService {

    void register(User user);
    void deleteUser(Long id);
    User login(String userName , String password);
    List<User> getAllUsers();
    void changePassword(String userName,String email,String newPassword);
    void newAdmin(Long id);
    void newModeraor(Long id);

}
