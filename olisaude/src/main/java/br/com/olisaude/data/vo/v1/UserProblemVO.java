package br.com.olisaude.data.vo.v1;


import com.github.dozermapper.core.Mapping;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;



public class UserProblemVO implements Serializable {

    @Mapping("id")
    private Long key;

    private String name;

    private String problems;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProblemVO that)) return false;

        if (!Objects.equals(key, that.key)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(problems, that.problems);
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (problems != null ? problems.hashCode() : 0);
        return result;
    }
}
