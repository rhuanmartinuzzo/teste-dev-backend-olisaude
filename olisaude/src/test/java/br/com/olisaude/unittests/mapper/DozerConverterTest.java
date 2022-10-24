package br.com.olisaude.unittests.mapper;

import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.mapper.DozerMapper;
import br.com.olisaude.model.User;
import br.com.olisaude.unittests.mapper.mocks.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DozerConverterTest {

    MockUser inputObject;

    @BeforeEach
    public void setUp(){inputObject = new MockUser();}


    @Test
    public void parseEntityToVOTest(){
        UserVO output = DozerMapper.parseObject(inputObject.mockEntity(), UserVO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("First Name Test0", output.getName());
        assertNotNull(output.getBirth_day());
        assertEquals("Male", output.getGender());
        assertNotNull(output.getCreated_at());
    }

    @Test
    public void parseEntityListToVOListTest(){
        List<UserVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), UserVO.class);
        UserVO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("First Name Test0", outputZero.getName());
        assertNotNull(outputZero.getBirth_day());
        assertEquals("Male", outputZero.getGender());
        assertNotNull(outputZero.getCreated_at());

        UserVO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("First Name Test7", outputSeven.getName());
        assertNotNull(outputSeven.getBirth_day());
        assertEquals("Female", outputSeven.getGender());
        assertNotNull(outputSeven.getCreated_at());

        UserVO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertNotNull(outputTwelve.getBirth_day());
        assertEquals("Male", outputTwelve.getGender());
        assertNotNull(outputTwelve.getCreated_at());
    }

    @Test
    public void parseVOToEntityTest(){
        User output = DozerMapper.parseObject(inputObject.mockVO(), User.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertNotNull(output.getBirth_day());
        assertEquals("Male", output.getGender());
        assertNotNull(output.getCreated_at());
    }

    @Test
    public void parseVOListToEntityListTest() {
        List<User> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), User.class);
        User outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertNotNull(outputZero.getBirth_day());
        assertEquals("Male", outputZero.getGender());
        assertNotNull(outputZero.getCreated_at());

        User outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertNotNull(outputSeven.getBirth_day());
        assertEquals("Female", outputSeven.getGender());
        assertNotNull(outputSeven.getCreated_at());

        User outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertNotNull(outputTwelve.getBirth_day());
        assertEquals("Male", outputTwelve.getGender());
        assertNotNull(outputTwelve.getCreated_at());
    }


    //TODO create MockHealthProblem in DozerConverter
    //TODO services User and HealthProblem

}
