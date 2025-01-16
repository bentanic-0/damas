package ec.com.sofka.commands.usecases;
/*
import ec.com.sofka.gateway.IUserRepository;
import ec.com.sofka.utils.JWTUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

public class LoginUserUseCase {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public LoginUserUseCase(IUserRepository userRepository, PasswordEncoder passwordEncoder, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Mono<String> execute(String email, String password) {
        return userRepository.findByEmail(email)
                .flatMap(user -> {
                    if (passwordEncoder.matches(password, user.getPassword())) {
                        String token = jwtUtil.generateToken(user.getId(), user.getRole().toString());
                        return Mono.just(token);
                    } else {
                        return Mono.error(new IllegalArgumentException("Invalid credentials"));
                    }
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("User not found")));
    }
}

 */
