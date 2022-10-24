package br.com.olisaude.unittests.mapper.mocks;


import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockUser {


    public User mockEntity(){ return mockEntity(0);}

    public UserVO mockVO(){return mockVO(0);}

    public List<User> mockEntityList(){
        List<User> users = new ArrayList<>();

        for (int i =0;i<14;i++){
            users.add(mockEntity(i));
        }
        return users;
    }

    public User mockEntity(Integer number){
        User user = new User();
        user.setId(number.longValue());
        user.setName("First Name Test" + number);
        user.setBirth_day(new Date());
        user.setGender(((number % 2) == 0) ? "Male" : "Female");
        user.setCreated_at(new Date());
        return user;
    }

    public UserVO mockVO(Integer number){
        UserVO user = new UserVO();
        user.setKey(number.longValue());
        user.setName("First Name Test" + number);
        user.setBirth_day(new Date());
        user.setGender(((number % 2) == 0) ? "Male" : "Female");
        user.setCreated_at(new Date());
        return user;
    }


}
