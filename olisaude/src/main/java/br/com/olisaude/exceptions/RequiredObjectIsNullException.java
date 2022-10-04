package br.com.olisaude.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

    private static final long serialVersionUID = -6668403005236090507L;

    public RequiredObjectIsNullException(String test){super(test);}

    public RequiredObjectIsNullException(){ super("It is not allowed to persist a null object");}
}
