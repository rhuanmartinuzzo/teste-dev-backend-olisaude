package br.com.olisaude.data.vo.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "name", "tier", "user_id"})
public class HealthProblemVO implements Serializable {

    private static final long serialVersionUID = -3837205909309820434L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    @NotBlank
    @Size(min = 4, max =200 )
    @Column(name = "name")
    private String name;
    @NotBlank
    @Size(max = 1)
    @Column(name = "tier")
    private Long tier;
    @NotBlank
    @Size(min = 1, max =20 )
    @Column(name = "user_id")
    private Long user_id;

    public HealthProblemVO(){}

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

    public Long getTier() {
        return tier;
    }

    public void setTier(Long tier) {
        this.tier = tier;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthProblemVO that)) return false;

        if (!Objects.equals(key, that.key)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(tier, that.tier)) return false;
        return Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tier != null ? tier.hashCode() : 0);
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        return result;
    }
}
