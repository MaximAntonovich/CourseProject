package dto;

import entity.User;

/**
 * Created by maxim on 14.9.21.
 */
public interface UserDTO {
    User buildNewUser(User user, String role);
}