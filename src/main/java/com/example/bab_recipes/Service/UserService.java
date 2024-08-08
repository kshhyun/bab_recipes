package com.example.bab_recipes.Service;

import com.example.bab_recipes.Domain.User;
import com.example.bab_recipes.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor // lombok
@Service
public class UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 서비스 구분을 위한 작업 (ex - 구글, 네이버)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        String userEmail;
        Map<String, Object> response = oAuth2User.getAttributes();

        if(registrationId.equals("naver")) {
            Map<String, Object> hash = (Map<String, Object>) response.get("response");
            userEmail = (String) hash.get("email");
        } else {
            throw new OAuth2AuthenticationException("인증 실패");
        }

        User user;
        Optional<User> optionalUser = userRepository.findByUserEmail(userEmail);

        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            user = new User();
            user.setUserEmail(userEmail);
            user.setUserName(userNameAttributeName);
            userRepository.save(user);
        }
        httpSession.setAttribute("user", user);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getUserName().toString()))
                , OAuth2User.getAttributes()
                , userNameAttributeName);

        );
    }
}