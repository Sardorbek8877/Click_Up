package uz.bek.click_up.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDto {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
