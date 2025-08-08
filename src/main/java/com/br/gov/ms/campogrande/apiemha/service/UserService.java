package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.UserDTO;

public interface UserService {

    Boolean findUserByLoginAndPassword(UserDTO userDTO);
}
