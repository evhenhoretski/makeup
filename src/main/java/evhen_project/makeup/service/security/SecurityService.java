package evhen_project.makeup.service.security;

import evhen_project.makeup.components.JwtUtils;
import evhen_project.makeup.dto.UserRequest;
import evhen_project.makeup.entity.security.Role;
import evhen_project.makeup.entity.security.User;
import evhen_project.makeup.repository.RoleRepository;
import evhen_project.makeup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public User createUser(UserRequest userRequest, Role.ERole role) {
        var roles = new HashSet<Role>();
        var build = Role.builder().name(role).build();
        roles.add(build);
        var user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(roles)
                .build();
        roleRepository.save(build);
        return userRepository.save(user);
    }

    public String createToken(UserRequest request) {
        var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        return jwtUtils.generateJwtToken(authenticate);
    }
}