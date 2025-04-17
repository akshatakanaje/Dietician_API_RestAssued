package pojoclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResp {

    String type;
    String token;
    String userId;
    String roles;
}
