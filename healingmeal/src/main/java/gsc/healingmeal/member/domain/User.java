package gsc.healingmeal.member.domain;

import gsc.healingmeal.member.execption.InvalidEmailAddressException;
import gsc.healingmeal.member.execption.InvalidUserException;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Getter
public class User implements Serializable {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@gmail\\.com$");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String loginId;

    private String password;

    private String name;

    private String email;

    private String birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Disease disease;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Builder
    private User(String loginId, String password, String name, String email, String birthDate, Gender gender, Disease disease, String phoneNumber, Role role) {

        validateEmail(email);
        validateBirthDate(birthDate);
        validatePhoneNumber(phoneNumber);

        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.disease = disease;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User() {

    }

    private void validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidEmailAddressException();
        }
    }

    private void validateBirthDate(String birthDate) {
        if (birthDate.length() != 6) {
            throw new InvalidUserException(String.format("Date of birth must be 6 characters"));
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            throw new InvalidUserException(String.format("Number must be 11 characters"));
        }
    }

}
