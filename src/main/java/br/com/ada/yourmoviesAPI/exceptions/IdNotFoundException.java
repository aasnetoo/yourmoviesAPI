package br.com.ada.yourmoviesAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "O ID informado não foi encontrado na nossa base de dados.")
public class IdNotFoundException extends Exception{
}
