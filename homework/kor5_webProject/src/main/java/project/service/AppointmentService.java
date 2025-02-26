package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired private AppointmentRepository appointmentRepository;
}
