package gsc.healingmeal.member.service;

import gsc.healingmeal.member.dto.JoinRequestDto;
import gsc.healingmeal.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserLoginService {
    private final UserRepository userRepository;


    // loginId 중복 체크.
    public boolean checkLoginId(String loginId){
        return userRepository.existsByLoginId(loginId);
    }

    // nickname 중복 체크.
    public boolean checkNickname(String nickname){
        return userRepository.existsByLoginId(nickname);
    }

    // 회원 가입
    @Transactional
    public void join(JoinRequestDto joinRequestDto){
        userRepository.save(joinRequestDto.toEntity());
    }

}
