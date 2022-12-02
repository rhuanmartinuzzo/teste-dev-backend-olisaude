package br.com.olisaude.model;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserProblem implements Serializable {

    @Id
    private Long id;

    private String name;

    private String problems;

    public UserProblem(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof UserProblem that)) return false;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(problems, that.problems);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (problems != null ? problems.hashCode() : 0);
        return result;
    }
}
