package br.com.olisaude.data.vo.v1;


import com.github.dozermapper.core.Mapping;

import java.io.Serializable;
import java.util.Objects;


public class HealthProblemTopVO implements Serializable {


    @Mapping("id")
    private Long key;
    private String name;
    private Float score;

    public HealthProblemTopVO(){}

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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthProblemTopVO that)) return false;

        if (!Objects.equals(key, that.key)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
