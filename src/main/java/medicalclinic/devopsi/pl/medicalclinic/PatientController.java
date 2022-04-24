package medicalclinic.devopsi.pl.medicalclinic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor

public class PatientController {

    private final PatientService patientService;


    @PostMapping("/patients")
    public ResponseEntity<Void> registerPatient(@RequestBody @Valid Patient patient) {
        this.patientService.registerPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/patients/{pesel}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String pesel, @RequestBody @Valid Patient patient) {
        this.patientService.updatePatient(pesel, patient);
        return ResponseEntity.status(HttpStatus.OK)
                .body(patient);
    }

    @DeleteMapping("/patients/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable String pesel) {
        this.patientService.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = this.patientService.getPatients();
        return ResponseEntity.status(HttpStatus.OK)
                .body(patients);
    }
}
