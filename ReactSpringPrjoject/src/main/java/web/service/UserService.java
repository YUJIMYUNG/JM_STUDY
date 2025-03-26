package web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.dto.AuthDto;
import web.model.dto.UserDto;
import web.model.entity.UserEntity;
import web.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService, OAuth2UserService<OAuth2UserRequest, OAuth2UserService> {
    @Autowired
    private UserRepository userRepository;

    // 1. 회원가입
    @Transactional
    public boolean signup(UserDto userDto){
        // 1. 저장할 dto를 entity로 변환
        UserEntity userEntity = userDto.toEntity();
        // 2. 변환된 entity를 save하고 그 엔티티를 반환 받음
        UserEntity saveEntity = userRepository.save(userEntity);
        // 3. 영속된 엔티티 회원번호가 0보다 크면 회원가입 성공, 아니면 회원가입 실패
        if(saveEntity.getUindex() > 0) {
            return true;
        } else {
            return false;
        }// if-else end
    } // signup f end

    // 2. 시큐리티를 이용한 로그인
    //  - loadUserByUsername 재정의
    @Override
    public UserDetails loadUserByUsername(String loginid) throws UsernameNotFoundException {
        System.out.println("loginid" + loginid);
        System.out.println("UserService.loadUserByUsername");

        // 1. loginid를 이용하여 데이터베이스에 저장된 암호화 패스와드 가져오기
        UserEntity userEntity = userRepository.findByEmail(loginid);
        if(userEntity == null) { // 입력받은 아이디(이메일)의 엔티티가 없으면
            throw  new UsernameNotFoundException("존재하지 않는 아이디입니다.");
        } // if end

        // 2. 입력받은 아이디(이메일)의 엔티티가 존재하면 암호화된 패스워드 확인
        String password = userEntity.getPassword();
        System.out.println("password" + password);

        // 3. 권한 부여
        // SimpleCratedAuthority : 시큐리티 사용자의 권한 클래스(구현체)
        List< GrantedAuthority > authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER")); // 권한명 규칙 : ROLE_권한명(대문자)

        // 4. 권한목록을 넣어줌
        AuthDto authDto = AuthDto.builder()
                .loginid(loginid)
                .loginpwd(password)
                .loginList(authorityList)
                .build();

        return authDto;
    }

    // 시큐리티 loadUser 재정의
    @Override
    public OAuth2UserService loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return null;
    }
}
