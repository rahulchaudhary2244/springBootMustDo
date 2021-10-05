package com.example.root;

import com.example.root.entities.Student;
import com.example.root.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@SpringBootTest
class RootApplicationTests {

    @Value("${studentrestapi.services.url}")
    private String baseUrl;

    @Autowired
    StudentRepository repository;

    @Test
    public void testStudentRepository() {
        assertNotNull(repository);
    }

    @Test
    public void testGetStudent() {
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(baseUrl+"/2", Student.class);
        assertNotNull(student);
        assertEquals("Rahul", student.getName());
    }

    @Test
    public void testPostStudent() {
        RestTemplate restTemplate = new RestTemplate();
        Student testObj = new Student("Raj", 100);
        Student student = restTemplate.postForObject(baseUrl+"", testObj, Student.class);
        assertNotNull(student);
        assertNotNull(student.getId());
        assertEquals("Raj", student.getName());
        assertEquals(100, student.gettestscore(), 0);
    }

    @Test
    public void testPutStudent() {
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(baseUrl+"/2", Student.class);
        assertNotNull(student);
        student.settestscore(student.gettestscore() + 20);
        restTemplate.put(baseUrl+"", student);
        // checking after update
        Student testObj = restTemplate.getForObject(baseUrl+"/2", Student.class);
        assertNotNull(testObj);
        assertEquals(testObj.gettestscore(), student.gettestscore(), 0);
    }

    @Test
    public void testDeleteStudent(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(baseUrl+"/3");
    }


}
