package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.dto.UserDTO;
import com.br.gov.ms.campogrande.apiemha.service.UserService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Operações relacionadas à autenticação e gerenciamento de usuários")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Buscar usuário por login e senha", description = "Retorna os dados do usuário a partir do login e senha informados. Usado para autenticação.")
    public ResponseEntity<Object> findUser(
            @RequestBody
            @Parameter(description = "DTO contendo login e senha do usuário") UserDTO userDTO
    ) {
        return ResponseUtil.generateResponse(userService.findUserByLoginAndPassword(userDTO), HttpStatus.OK, "Usuário encontrado com sucesso!");
    }
}