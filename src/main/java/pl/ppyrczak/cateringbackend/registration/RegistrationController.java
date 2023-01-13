package pl.ppyrczak.cateringbackend.registration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ppyrczak.cateringbackend.model.User;
import pl.ppyrczak.cateringbackend.registration.RegistrationRequest;
import pl.ppyrczak.cateringbackend.registration.RegistrationService;

@RestController
@RequestMapping(path = "/signup")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody RegistrationRequest request) {
        return new ResponseEntity<>(registrationService.register(request), HttpStatus.CREATED);
    }


}
