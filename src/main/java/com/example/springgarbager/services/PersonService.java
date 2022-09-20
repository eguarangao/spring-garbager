package com.example.springgarbager.services;

import com.example.springgarbager.model.Person;
import com.example.springgarbager.repositories.PersonRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private JavaMailSender mailSender;

    //Este metodo permite listar los contenedores
    public List<Person> findAll() throws Exception {
        try {
            return personRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Person findById(Integer id) throws Exception {
        try {
            Optional<Person> entityOptional = personRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void email(Person person) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("ebertguaranga@gmail.com");
        helper.setTo(person.getEmail());
        helper.setSubject("ACCOUNT VERIFICATION");
        String content = "Hi " + person.getLastName() + " welcome to Smart Garbaget Collector." +
                " To verify your account enter the following code in the application." +
                "   CODE: " + person.getVerificationCode();
        helper.setText(content);

        mailSender.send(message);
    }

    //Este metodo permite guardar
    public Person save(Person entity) throws Exception {
        try {
            String codeRandom = RandomString.make(8);
            entity.setVerificationCode(codeRandom.toUpperCase());
            entity.setPassword(entity.getPassword());
            entity = personRepository.save(entity);
            email(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite Actualizar mediante ID
    public Person update(Integer id, Person entity) throws Exception {
        try {
            Optional<Person> entityOptional = personRepository.findById(id);
            Person person = entityOptional.get();
            person = personRepository.save(entity);
            return person;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean delete(Integer id) throws Exception {
        try {
            if (personRepository.existsById(id)) {
                personRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //Validar login


}
