package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
