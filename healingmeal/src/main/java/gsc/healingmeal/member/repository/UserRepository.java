package gsc.healingmeal.member.repository;

import gsc.healingmeal.member.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(String loginId);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByLoginId(String loginId);
}
