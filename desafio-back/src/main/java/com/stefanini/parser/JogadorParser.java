package com.stefanini.parser;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;

public class JogadorParser {

    public static Jogador dtoToEntity(JogadorDTO jogadorDTO){
        return new Jogador(
                jogadorDTO.getId(),
                jogadorDTO.getNickname(),
                jogadorDTO.getPassword(),
                jogadorDTO.getSaldo(),
                jogadorDTO.getStefamon()
        );
    }
    public static JogadorDTO jogadorEntity(Jogador jogador) {
        return new JogadorDTO(
                jogador.getId(),
                jogador.getNickname(),
                jogador.getPassword(),
                jogador.getSaldo(),
                jogador.getStefamons()
        );
   }
}
