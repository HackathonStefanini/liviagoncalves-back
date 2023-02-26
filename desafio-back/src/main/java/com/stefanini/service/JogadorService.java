package com.stefanini.service;

import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.JogadorParser;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {

    @Inject
    JogadorRepository jogadorRepository;

    public void salvar(Jogador jogador) {
        if (!Objects.nonNull(jogador.getId())){
            throw new RegraDeNegocioException("Erro ao cadastra usuario");
        }
        if (!jogador.getPassword().isEmpty()) {
            String password = Base64.getEncoder().encodeToString(jogador.getPassword().getBytes());
            jogador.setPassword(password);
        }
        jogadorRepository.save(jogador);
    }

    public Jogador login(String nickname, String password){
        Jogador jogador = jogadorRepository.login(nickname, password);
        if (Objects.isNull(jogador)){
            throw new RegraDeNegocioException("Erro na busca do jogardor ", Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(Jogador jogador) {
        if (!Objects.nonNull(jogador.getId())){
            throw new RegraDeNegocioException("Erro ao Alterar usuario");
        }
        if (!jogador.getPassword().isEmpty()) {
            String password = Base64.getEncoder().encodeToString(jogador.getPassword().getBytes());
            jogador.setPassword(password);
        }
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }

}
