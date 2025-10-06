package org.example.springbootuserservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotBlank(message = "{validation.user.nameNotBlank}")
    @Size(min = 2, max = 50, message = "{validation.user.nameSize}")
    private String name;

    @NotBlank(message = "{validation.user.emailNotBlank}")
    @Email(message = "{validation.user.email}")
    private String email;

}
