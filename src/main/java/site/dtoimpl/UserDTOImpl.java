package site.dtoimpl;

import site.dto.UserDTO;
import site.entity.User;
import site.entity.UserRole;
import org.springframework.stereotype.Service;

/**
 * Created by maxim on 14.9.21.
 */
@Service("UserDTO")
public class UserDTOImpl implements UserDTO{

    @Override
    public User buildNewUser(User user, String role) {
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        user.setRole(userRole);
        return user;
    }

}
