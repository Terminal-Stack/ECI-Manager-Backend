package edu.eci.ieti.ecimanager.service;

import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.model.Student;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(s).orElseThrow(() -> new StudentNotFoundException(s));
        return new UserDetailsImpl(student);
    }

}
