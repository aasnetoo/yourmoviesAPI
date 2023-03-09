package br.com.ada.yourmoviesAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "O email informado já existe.")
public class UserExistException extends Exception{
}
