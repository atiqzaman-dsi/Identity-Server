package org.freeshr.identity.service;

import org.freeshr.identity.model.UserCredentials;
import org.freeshr.identity.model.UserInfo;
import org.freeshr.identity.repository.IdentityRepository;
import org.freeshr.identity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdentityService {
    private IdentityRepository identityRepository;
    private UserInfoRepository userInfoRepository;

    @Autowired
    public IdentityService(IdentityRepository identityRepository, UserInfoRepository userInfoRepository) {
        this.identityRepository = identityRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Deprecated
    public java.util.UUID login(UserCredentials userCredentials) {
        return identityRepository.login(userCredentials);
    }

    public String signin(UserCredentials userCredentials) {
        return identityRepository.signin(userCredentials);
    }

    @Deprecated
    public UserInfo userInfo(UUID token) {
        UserCredentials userCredentials = identityRepository.getUserByToken(token.toString());
        return userCredentials == null ? null : userInfoRepository.getUserInfo(userCredentials.getEmail());
    }

    public UserInfo userDetail(UserCredentials credentials, String token) {
        if(identityRepository.checkClientIdAndAuthToken(credentials)) {
            UserCredentials userCredentialsOfToken = identityRepository.getUserByToken(token);
            return userCredentialsOfToken == null ? null : identityRepository.getUserInfo(userCredentialsOfToken.getEmail());
        }
        return null;
    }
}
