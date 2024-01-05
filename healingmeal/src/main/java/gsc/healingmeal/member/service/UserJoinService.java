package gsc.healingmeal.member.service;

import gsc.healingmeal.member.domain.Role;
import gsc.healingmeal.member.domain.User;
import gsc.healingmeal.member.dto.JoinRequestDto;
import gsc.healingmeal.member.execption.InvalidUserException;
import gsc.healingmeal.member.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserJoinService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserJoinService(PasswordEncoder passwordEncoder,UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;}


    @Transactional
    public void join(JoinRequestDto joinRequestDto) {
        // 비밀번호를 암호화
        String encodedPassword = passwordEncoder.encode(joinRequestDto.getPassword());

        User user = User.builder()
                .loginId(joinRequestDto.getLoginId())
                .password(encodedPassword)
                .name(joinRequestDto.getName())
                .email(joinRequestDto.getEmail())
                .gender(joinRequestDto.getGender())
                .birthDate(joinRequestDto.getBirthDate())
                .phoneNumber(joinRequestDto.getPhoneNumber())
                .role(Role.ROLE_USER)
                .build();
        validateDuplicateLoginId(user);
        validateDuplicatePhoneNumber(user);
        // 회원 정보 저장
        userRepository.save(user);
    }

    private void validateDuplicateLoginId(User user){
        if(userRepository.existsByLoginId(user.getLoginId())){
            throw new InvalidUserException("This ID is already taken.");
        }
    }

    private void validateDuplicatePhoneNumber(User user){
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())){
            throw new InvalidUserException("This phone number is already in use.");
        }
    }

}