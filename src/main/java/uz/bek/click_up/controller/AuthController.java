package uz.bek.click_up.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uz.bek.click_up.entity.User;
import uz.bek.click_up.payload.ApiResponse;
import uz.bek.click_up.payload.LoginDto;
import uz.bek.click_up.payload.RegisterDto;
import uz.bek.click_up.security.JwtProvider;
import uz.bek.click_up.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public HttpEntity<?> registerUser( @RequestBody RegisterDto registerDto){
        ApiResponse apiResponse = authService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody LoginDto loginDto){
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(),
                    loginDto.getPassword()
            ));
            User user = (User) authenticate.getPrincipal();
            String token = jwtProvider.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        }
        catch (Exception e){
            return ResponseEntity.ok(new ApiResponse("Password or Email is wrong", false));
        }
    }

    @PutMapping("/verifyEmail")
    public HttpEntity<?> verifyEmail(@RequestParam String email, @RequestParam String emailCode){
        ApiResponse apiResponse = authService.verifyEmail(email, emailCode);

    }
}
