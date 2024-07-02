package zw.co.mohcc.StudentHealthApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotEmpty(message = "First name cannot be empty")

    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")

    private String LastName;
    @NotEmpty(message = "username cannot be empty")
    private String Username;
    @Email(message = "Invalid email. Please enter a valid email address")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    private String Gender;
    private Date Age;


}

