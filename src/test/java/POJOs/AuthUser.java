package POJOs;


import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
    public class AuthUser {

        private String password;
        private String userName;


}
