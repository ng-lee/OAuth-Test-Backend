package oauthtest.backend.domain.oauth.controller;

import lombok.RequiredArgsConstructor;
import oauthtest.backend.domain.oauth.service.OAuthService;
import oauthtest.backend.domain.oauth.utils.OAuthServerType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/oauth")
@RestController
public class OAuthController {

    private final OAuthService oauthService;

    @GetMapping("/{oauthServerType}")
    public ResponseEntity<?> redirectAuthCodeRequestUrl(@PathVariable OAuthServerType oauthServerType) {
        String redirectUrl = oauthService.getAuthCodeRequestUrl(oauthServerType);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(redirectUrl));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    // 추가
    @GetMapping("/kakao/login")
    ResponseEntity<Long> login(
//            @PathVariable OAuthServerType oauthServerType,
            @RequestParam("code") String code
    ) {
        System.out.println("OAuthController.login");
//        System.out.println(oauthServerType);
        Long login = oauthService.login(OAuthServerType.KAKAO, code);
        return ResponseEntity.ok(login);
    }
}