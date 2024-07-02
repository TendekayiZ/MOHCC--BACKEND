package zw.co.mohcc.StudentHealthApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.mohcc.StudentHealthApp.model.Users;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {



}
