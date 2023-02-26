package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    public Jogador login(Jogador jogador) {
        return createQuery("SELECT * FROM Jogador WHERE nickname =: nickname AND password =: password")
                .setParameter("nickname", jogador.getNickname())
                .setParameter("password", jogador.getPassword())
                .getSingleResult();
    }

    public Jogador listarNickname(String nickname){
        try {
            return createQuery("SELECT * FROM Jogador WHERE nickname =: nickname")
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }
}
