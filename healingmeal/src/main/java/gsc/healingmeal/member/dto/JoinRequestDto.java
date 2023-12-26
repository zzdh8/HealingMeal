package gsc.healingmeal.member.dto;

import gsc.healingmeal.member.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequestDto {
    private String loginId;

    private String password;
    private String passwordCheck;

    private String nickname;

    // 암호화 사용 x
    public User toEntity(){
        return User.builder()
                .loginId(this.loginId)
                .password(this.password)
                .nickname(this.nickname)
                .build();
    }

    // 암호화 사용 o
    public User toEntity(String encodedPassword){
        return User.builder()
                .loginId(this.loginId)
                .password(encodedPassword)
                .nickname(this.nickname)
                .build();
    }
}
