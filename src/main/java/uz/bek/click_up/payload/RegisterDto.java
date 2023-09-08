package uz.bek.click_up.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDto {

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
