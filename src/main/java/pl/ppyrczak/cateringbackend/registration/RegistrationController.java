package pl.ppyrczak.cateringbackend.registration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ppyrczak.cateringbackend.model.User;
import pl.ppyrczak.cateringbackend.registration.RegistrationRequest;
import pl.ppyrczak.cateringbackend.registration.RegistrationService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping(path = "/signup")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    Map<String, String> errors;

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody RegistrationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            errors = new HashMap<>();
            for (FieldError error: bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            System.out.println(errors);
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(registrationService.register(request), HttpStatus.CREATED);
    }


}
