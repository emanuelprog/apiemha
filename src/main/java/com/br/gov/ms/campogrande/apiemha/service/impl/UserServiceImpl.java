package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.UserDTO;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.repository.acessos.UserRepository;
import com.br.gov.ms.campogrande.apiemha.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Boolean findUserByLoginAndPassword(UserDTO userDTO) {
        userRepository.findByLoginAndPassword(
                userDTO.getLogin(),
                md5(userDTO.getPassword())
        ).orElseThrow(() -> new NotFoundException("Usuário ou senha inválidos"));

        return true;
    }

    private String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger number = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder(number.toString(16));

            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }

            return hashText.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash MD5", e);
        }
    }
}
