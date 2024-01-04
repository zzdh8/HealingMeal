package gsc.healingmeal.member.service;

import gsc.healingmeal.member.domain.User;
import gsc.healingmeal.member.dto.PwdChangeDto;
import gsc.healingmeal.member.dto.UserSearchDto;
import gsc.healingmeal.member.execption.InvalidEmailAddressException;
import gsc.healingmeal.member.execption.InvalidUserException;
import gsc.healingmeal.member.execption.InvalidUserNameException;
import gsc.healingmeal.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    /*
    //이름, 이메일로 아이디 찾기
     */
    public UserSearchDto searchId(String name, String email) {
        if (userRepository.existsByName(name)){
            if (userRepository.existsByEmail(email)){
                Optional<User> optionalUser = userRepository.findByEmailAndName(email, name);
                User user = optionalUser.get();
                return UserSearchDto.builder()
                        .loginId(user.getLoginId()).build();
            } else{
                throw new InvalidEmailAddressException("email not found");
            }
        } else {
            throw new InvalidUserNameException("user name not found");

        }
    }

    //이름, 이메일, 아이디로 비밀번호 찾기
    /*
    임시 비밀번호를 발급해준 뒤 user의 password를 임시비밀번호로 변경.
    향후 user가 자신의 password를 원하는대로 변경하도록 함.
     */
    public String searchPassword(UserSearchDto userSearchDto){
        if (!userRepository.existsByEmail(userSearchDto.getEmail())) {
            throw new InvalidEmailAddressException("User email not Found");
        }
        if (!userRepository.existsByName(userSearchDto.getName())){
            throw new InvalidUserNameException("User name not Found");
        }
        if (!userRepository.existsByLoginId(userSearchDto.getLoginId())){
            throw new InvalidUserException("Not Found ID");
        }
        String temPwd = generateTemPwd(8);
        String encoded = passwordEncoder.encode(temPwd);
        User user = userRepository.findByEmail(userSearchDto.getEmail());
        user.setPassword(encoded);
        userRepository.save(user);
        return temPwd;
    }

    //비밀번호 변경
    public void changePwd(PwdChangeDto pwdChangeDto, String loginId){
        if (validatePwd(pwdChangeDto.getChangePwd())){
            Optional<User> optionalUser = userRepository.findByLoginId(loginId);
            User user = optionalUser.get();
            if (passwordEncoder.matches(pwdChangeDto.getNowPwd(),user.getPassword())){

            }

        }
    }
    //-비밀번호 변경 전 유효성 검사
    boolean validatePwd(String changePwd){
        String REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d~!@#$%^&*()+|=]{6,12}";
        return Pattern.matches(REGEX, changePwd);
    }

    //임시 비밀번호 발행
    private String generateTemPwd(int length){

        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, length)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }
}
