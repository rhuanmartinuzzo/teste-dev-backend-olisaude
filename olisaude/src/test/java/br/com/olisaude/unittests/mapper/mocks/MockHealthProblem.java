package br.com.olisaude.unittests.mapper.mocks;

import br.com.olisaude.data.vo.v1.HealthProblemVO;
import br.com.olisaude.model.HealthProblem;

import java.util.ArrayList;
import java.util.List;

public class MockHealthProblem {

    public HealthProblem mockEntity() {
        return mockEntity(0);
    }

        public HealthProblemVO mockVO() {
        return mockVO(0);
    }

    public List<HealthProblem> mockEntityList() {
        List<HealthProblem> healthProblems = new ArrayList<HealthProblem>();
        for (int i = 0; i < 14; i++) {
            healthProblems.add(mockEntity(i));
        }
        return healthProblems;
    }

    public List<HealthProblemVO> mockVOList() {
        List<HealthProblemVO> healthProblem = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            healthProblem.add(mockVO(i));
        }
        return healthProblem;
    }

    public HealthProblem mockEntity(Integer number) {
        HealthProblem healthProblem = new HealthProblem();
        healthProblem.setId(number.longValue());
        healthProblem.setName("ProblemName Test" + number);
        healthProblem.setTier(number.longValue());
        healthProblem.setUser_id(number.longValue());
        return healthProblem;
    }

    public HealthProblemVO mockVO(Integer number) {
        HealthProblemVO healthProblem = new HealthProblemVO();
        healthProblem.setKey(number.longValue());
        healthProblem.setName("ProblemName Test" + number);
        healthProblem.setTier(number.longValue());
        healthProblem.setUser_id(number.longValue());
        return healthProblem;
    }


}
