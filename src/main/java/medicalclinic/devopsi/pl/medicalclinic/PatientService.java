package medicalclinic.devopsi.pl.medicalclinic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PatientService {

    private final HashMap<String, Patient> patients;

    public PatientService() {
        this.patients = new HashMap<>();
    }

    public void registerPatient(Patient patient) {
        if (!this.patients.containsKey(patient.getPesel())) {
            this.patients.put(patient.getPesel(), patient);
        }
    }

    public void deletePatient(String pesel) {
        this.patients.remove(pesel);
    }

    public void updatePatient(String pesel, Patient patient) {
        if (this.patients.containsKey(pesel)) {
            this.patients.put(pesel, patient);
        }
    }

    public List<Patient> getPatients() {
        List<Patient> tmpPatients = new ArrayList<>(patients.values());
        return tmpPatients;
    }
}
