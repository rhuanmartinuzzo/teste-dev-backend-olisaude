package br.com.olisaude.util;


import org.springframework.stereotype.Component;

@Component
public class HealthProblemUtils {

    public double scoreRisk(Integer calc){
        return (1 / (1 + Math.pow(Math.E, -(calc - 2.8)))) * 100;
    }


}
