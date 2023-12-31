package oauthtest.backend.domain.oauth.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.*;

@Getter
@ToString
@JsonNaming(SnakeCaseStrategy.class)
public class KakaoToken {

    private String tokenType;
    private String accessToken;
    private String idToken;
    private Integer expiresIn;
    private String refreshToken;
    private Integer refreshTokenExpiresIn;
    private String scope;
}
