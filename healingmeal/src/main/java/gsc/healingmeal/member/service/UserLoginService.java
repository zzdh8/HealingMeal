package gsc.healingmeal.member.service;

import gsc.healingmeal.member.domain.User;
import gsc.healingmeal.member.dto.LoginRequestDto;
import gsc.healingmeal.member.dto.SessionDto;
import gsc.healingmeal.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public SessionDto login(String loginId, String password){
        Optional<User> optionalUser = userRepository.findByLoginId(loginId);
        //회원정보를 DB에서 조회했을 때 회원정보가 있다면
        //Optional user 객체를 get하여 user 타입의 객체에 대입.
        if (optionalUser.isEmpty()) {
            return null;
        }
        else {
            User user = optionalUser.get();
            if (!passwordEncoder.matches(password, user.getPassword())){
               return null;
            }
            return new SessionDto(user.getLoginId(), user.getPassword());
        }
    }
}
