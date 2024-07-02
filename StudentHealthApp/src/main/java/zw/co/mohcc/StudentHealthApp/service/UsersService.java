package zw.co.mohcc.StudentHealthApp.service;

import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.mohcc.StudentHealthApp.model.Users;
import zw.co.mohcc.StudentHealthApp.repository.UsersRepository;

import java.util.Date;
import java.util.List;

@Data
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public static Users save(Users user) {
        return user;
    }

    public Users register(String Firstname, String Lastname, String Username,
                          String gender, Date Age, String password, String email) {
        if (Firstname != null || password != null || email != null || Username != null || gender != null ||
                Age != null) {
            Users user = new Users();
            user.setFirstName(Firstname);
            user.setLastName(Lastname);
            user.setUsername(Username);
            user.setGender(gender);
            user.setAge(Age);
            user.setPassword(password);
            user.setEmail(email);

            return usersRepository.save(user);
        } else {
            return null;
        }
    }


    public ResponseEntity<List<Users>> getUsers() {
        return null;
    }

    public void deleteUser(Long userId) {
      boolean exists =  usersRepository.existsById(userId);
      if (!exists) {
          throw new IllegalArgumentException("User with id" + userId + " does not exist");
      }else {
          usersRepository.deleteById(userId);
      }
    }
}
