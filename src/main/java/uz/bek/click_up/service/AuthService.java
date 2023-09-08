package uz.bek.click_up.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bek.click_up.entity.User;
import uz.bek.click_up.entity.enums.SystemRoleName;
import uz.bek.click_up.payload.ApiResponse;
import uz.bek.click_up.payload.LoginDto;
import uz.bek.click_up.payload.RegisterDto;
import uz.bek.click_up.repository.UserRepository;

import java.util.Random;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail()))
            return new ApiResponse("User with this Email already exist", false);

        User user = new User(
                registerDto.getFullName(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                SystemRoleName.SYSTEM_USER
        );
        int code = new Random().nextInt(999999);
        user.setEmailCode(String.valueOf(code).substring(0,4));
        userRepository.save(user);
        sendEmail(user.getEmail(), user.getEmailCode());
        return new ApiResponse("User successfully registered", true);
    }



    public Boolean sendEmail(String sendingEmail, String emailCode) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("sardorbeksafarov8844@gmail.com");
            mailMessage.setTo(sendingEmail);
            mailMessage.setSubject("Akkountni tasdiqlash");
            mailMessage.setText(emailCode);
            javaMailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


//    public ApiResponse verifyEmail(String email, String emailCode) {
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            if (emailCode.equals(user.getEmailCode())) {
//                user.setEnabled(true);
//                userRepository.save(user);
//                return new ApiResponse("Acount aktivlashtirildi", true);
//            }
//            return new ApiResponse("Kod xato", false);
//        }
//        return new ApiResponse("Bunday user mavjud emas", false);
//    }
}
