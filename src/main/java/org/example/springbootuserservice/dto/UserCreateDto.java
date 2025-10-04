package org.example.springbootuserservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(?!null$)(?=.{2,50}$)[A-Z][a-z]+ [A-Z][a-z]+$", message = "{validation.user.name}")
    private String name;

    @NotBlank(message = "{validation.user.emailNotBlank}")
    @Email(regexp = "^[a-zA-Z][\\w.-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "{validation.user.email}")
    private String email;

}
