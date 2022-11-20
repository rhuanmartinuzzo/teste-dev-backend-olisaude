package br.com.olisaude.services;


import br.com.olisaude.data.vo.v1.HealthProblemVO;
import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.exceptions.RequiredObjectIsNullException;
import br.com.olisaude.model.HealthProblem;
import br.com.olisaude.model.User;
import br.com.olisaude.repositories.HealthProblemRepository;
import br.com.olisaude.unittests.mapper.mocks.MockHealthProblem;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class HealthProblemServicesTest {

    MockHealthProblem input;

    @InjectMocks
    HealthProblemServices service;

    @Mock
    HealthProblemRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception{
        input = new MockHealthProblem();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById(){
        HealthProblem entity = input.mockEntity(1);
        entity.setId(1L);

        Mockito.lenient().when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals("ProblemName Test1", result.getName());
        assertNotNull(result.getTier());
        assertNotNull(result.getUser_id());
    }

    @Test
    void findAll(){

        List<HealthProblem> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var people = service.findAllSI();
        assertNotNull(people);
        assertEquals(14, people.size());

        var personOne = people.get(0);
        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertEquals("ProblemName Test0", personOne.getName());
        assertNotNull(personOne.getTier());
        assertNotNull(personOne.getUser_id());

        var personFour = people.get(4);
        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertEquals("ProblemName Test4", personFour.getName());
        assertNotNull(personFour.getTier());
        assertNotNull(personFour.getUser_id());

        var personSeven = people.get(7);
        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertEquals("ProblemName Test7", personSeven.getName());
        assertNotNull(personSeven.getTier());
        assertNotNull(personSeven.getUser_id());
    }

    @Test
    void testUpdate() {
        HealthProblem entity = input.mockEntity(1);

        HealthProblem persisted = entity;
        entity.setId(1L);

        HealthProblemVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals("ProblemName Test1", result.getName());
        assertNotNull(result.getTier());
        assertNotNull(result.getUser_id());
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
        HealthProblem entity = input.mockEntity(1);
        entity.setId(1L);

        HealthProblem persisted = entity;
        entity.setId(1L);

        HealthProblemVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertEquals("ProblemName Test1", result.getName());
        assertNotNull(result.getTier());
        assertNotNull(result.getUser_id());
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
        HealthProblem entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }




}
