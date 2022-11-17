package br.com.olisaude.services;


import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.exceptions.RequiredObjectIsNullException;
import br.com.olisaude.model.User;
import br.com.olisaude.repositories.UserRepository;
import br.com.olisaude.unittests.mapper.mocks.MockHealthProblem;
import br.com.olisaude.unittests.mapper.mocks.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServicesTest {


    MockUser input;

    @InjectMocks
    UserServices service;

    @Mock
    UserRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception{
        input = new MockUser();
        MockitoAnnotations.openMocks(this );
    }


    @Test
    void testFindById(){
        User entity = input.mockEntity(1);
        entity.setId(1L);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals("First Name Test1", result.getName());
        assertNotNull(result.getBirth_day());
        assertEquals("Female", result.getGender());
        assertNotNull(result.getCreated_at());
    }

    @Test
    void findAll(){

        List<User> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var people = service.findAll();
        assertNotNull(people);
        assertEquals(14, people.size());

        var personOne = people.get(0);
        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertEquals("First Name Test0", personOne.getName());
        assertNotNull(personOne.getBirth_day());
        assertEquals("Male", personOne.getGender());
        assertNotNull(personOne.getCreated_at());

        var personFour = people.get(4);
        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertEquals("First Name Test4", personFour.getName());
        assertNotNull(personFour.getBirth_day());
        assertEquals("Male", personFour.getGender());
        assertNotNull(personFour.getCreated_at());

        var personSeven = people.get(7);
        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertEquals("First Name Test7", personSeven.getName());
        assertNotNull(personSeven.getBirth_day());
        assertEquals("Female", personSeven.getGender());
        assertNotNull(personSeven.getCreated_at());
    }

    @Test
    void testUpdate() {
        User entity = input.mockEntity(1);

        User persisted = entity;
        entity.setId(1L);

        UserVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals("First Name Test1", result.getName());
        assertNotNull(result.getBirth_day());
        assertEquals("Female", result.getGender());
        assertNotNull(result.getCreated_at());
    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, ()-> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreate() {
        User entity = input.mockEntity(1);
        entity.setId(1L);

        User persisted = entity;
        entity.setId(1L);

        UserVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals("First Name Test1", result.getName());
        assertNotNull(result.getBirth_day());
        assertEquals("Female", result.getGender());
        assertNotNull(result.getCreated_at());
    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, ()-> {
            service.create(null);} );

        String expectedMessage = "It is not allowed to persist a null object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        User entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }



}
