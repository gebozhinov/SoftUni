package bg.softuni.mobilelele.service.user;

import bg.softuni.mobilelele.domain.dto.UserLoginDTO;
import bg.softuni.mobilelele.domain.dto.UserRegisterDTO;

public interface UserService {

    void fillDb();
    boolean isDbFilled();

    void registerUser(UserRegisterDTO userRegisterDTO);

    void loginUser(UserLoginDTO userLoginDTO);

    void logout();
}
