package gsc.healingmeal.member.dto;

import gsc.healingmeal.member.domain.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {

    private String loginId;
    private String password;

}
