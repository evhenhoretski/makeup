package evhen_project.makeup.controller;

import evhen_project.makeup.dto.UserRequest;
import evhen_project.makeup.entity.security.Role;
import evhen_project.makeup.entity.security.User;
import evhen_project.makeup.service.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController {
    private final SecurityService service;
//    @PostConstruct
    public void createUser() {
//        var userRequest = new UserRequest();
//        userRequest.setUsername("user");
//        userRequest.setPassword("user");
//        service.createUser(userRequest, Role.ERole.ROLE_USER);
        var adminRequest = new UserRequest();
        adminRequest.setUsername("admin");
        adminRequest.setPassword("admin");
        service.createUser(adminRequest, Role.ERole.ROLE_ADMIN);
    }

    @PostMapping("/createUser")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<User> registerUser(UserRequest userDto) {
        return ResponseEntity.ok(service.createUser(userDto, Role.ERole.ROLE_USER));
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<User> registerAdmin(UserRequest userDto) {
        return ResponseEntity.ok(service.createUser(userDto, Role.ERole.ROLE_ADMIN));
    }

    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<String> login(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(service.createToken(userRequest));
    }
}
