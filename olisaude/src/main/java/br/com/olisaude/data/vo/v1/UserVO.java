package br.com.olisaude.data.vo.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@JsonPropertyOrder({"id", "name", "birth_day", "gender", "created_at", "updated_at"})
public class UserVO implements Serializable {


    private static final long serialVersionUID = -9035881742863629448L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    @NotBlank
    @Size(min = 10, max = 200)
    private String name;
    @NotBlank
    private Date birth_day;
    @NotBlank
    @Size(min = 4, max = 8)
    private String gender;
    private Date created_at;
    private Date updated_at;

    public UserVO(){};

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

    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVO userVO)) return false;
        if (!super.equals(o)) return false;

        if (!Objects.equals(key, userVO.key)) return false;
        if (!Objects.equals(name, userVO.name)) return false;
        if (!Objects.equals(birth_day, userVO.birth_day)) return false;
        if (!Objects.equals(gender, userVO.gender)) return false;
        if (!Objects.equals(created_at, userVO.created_at)) return false;
        return Objects.equals(updated_at, userVO.updated_at);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birth_day != null ? birth_day.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);
        return result;
    }
}
