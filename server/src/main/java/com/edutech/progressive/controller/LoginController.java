package com.edutech.progressive.controller;

import com.edutech.progressive.dto.LoginRequest;
import com.edutech.progressive.dto.LoginResponse;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.jwt.JwtUtil;
import com.edutech.progressive.service.LoginService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class LoginController {
    private final LoginService loginService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(LoginService loginService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.loginService = loginService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<Supplier> registerUser(@RequestBody Supplier user) {
        return ResponseEntity.ok(loginService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest) {
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password", e);
        }
        final UserDetails userDetails = loginService.loadUserByUsername(loginRequest.getUsername());
        Supplier foundUser = loginService.getSupplierByName(loginRequest.getUsername());
        final String token = jwtUtil.generateToken(loginRequest.getUsername());
        String role = foundUser.getRole();
        Integer userId = foundUser.getSupplierId();
        System.out.println("User Roles: " + role);
        return ResponseEntity.ok(new LoginResponse(token, role, userId));
    }
}

// @RestController
// @RequestMapping("/user")
// public class LoginController {
// private final LoginService loginService;

// private final AuthenticationManager authenticationManager;

// private final JwtUtil jwtUtil;

// @Autowired
// public LoginController(LoginService loginService, JwtUtil jwtUtil,
// AuthenticationManager authenticationManager) {
// this.loginService = loginService;
// this.authenticationManager = authenticationManager;
// this.jwtUtil = jwtUtil;
// }

// @PostMapping("/register")
// public ResponseEntity<Supplier> registerUser(@RequestBody Supplier user) {
// return ResponseEntity.ok(loginService.createUser(user));
// }

// @PostMapping("/login")
// public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest) {
// try {

// authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
// loginRequest.getPassword())
// );
// } catch (AuthenticationException e) {
// throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username
// or password", e);
// }
// final UserDetails userDetails =
// loginService.loadUserByUsername(loginRequest.getUsername());
// Supplier foundUser =
// loginService.getSupplierByName(loginRequest.getUsername());
// final String token = jwtUtil.generateToken(loginRequest.getUsername());
// String role = foundUser.getRole();
// Integer userId = foundUser.getSupplierId();
// System.out.println("User Roles: " + role);
// return ResponseEntity.ok(new LoginResponse(token, role, userId));
// }
// }

// package com.edutech.progressive.controller;

// import com.edutech.progressive.dto.LoginRequest;
// import com.edutech.progressive.dto.LoginResponse;
// import com.edutech.progressive.entity.Supplier;
// import com.edutech.progressive.service.LoginService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/user")
// public class LoginController {

// private final LoginService loginService;

// @Autowired
// public LoginController(LoginService loginService) {
// this.loginService = loginService;
// }

// @PostMapping("/register")
// public ResponseEntity<Supplier> registerUser(@RequestBody Supplier user) {
// return ResponseEntity.ok(loginService.createUser(user));
// }

// @PostMapping("/login")
// public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {

// // ✅ Fetch user directly (NO Spring Security)
// Supplier foundUser =
// loginService.getSupplierByName(loginRequest.getUsername());

// if (foundUser == null) {
// return ResponseEntity
// .status(HttpStatus.UNAUTHORIZED)
// .body("Invalid username or password");
// }

// // ✅ Plain password check (TEMPORARY, no security)
// if (!foundUser.getPassword().equals(loginRequest.getPassword())) {
// return ResponseEntity
// .status(HttpStatus.UNAUTHORIZED)
// .body("Invalid username or password");
// }

// // ✅ Successful login (NO JWT)
// LoginResponse response = new LoginResponse(
// null, // token removed
// foundUser.getRole(),
// foundUser.getSupplierId()
// );

// return ResponseEntity.ok(response);
// }
// }