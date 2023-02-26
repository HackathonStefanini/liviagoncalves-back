package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    public Jogador login(String nickname, String password) {
        return createQuery("SELECT * FROM Jogador WHERE nickname =: nickname AND password =: password")
                .setParameter("nickname", nickname)
                .setParameter("password", password)
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
