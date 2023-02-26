package com.stefanini.entity;

import com.stefanini.dto.JogadorDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(schema = "tb_jogador")
public class Jogador {

    @Id
    @Column(name = "idJogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Não pode ser nulo")
    private String nickname;

    @Column(nullable = false, length = 10)
    @Size(min = 4, max = 10, message = "A senha deve ter entre 4 e 10 caracteres")
    @NotBlank(message = "Não pode ser nulo")
    private String password;

    @Column(nullable = false, columnDefinition = "decimal(19,2) default '20'" )
    private BigDecimal saldo;


    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "idJogador")},
            inverseJoinColumns = {@JoinColumn(name = "idStefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

    public Jogador() {
    }

    public Jogador(JogadorDTO jogadorDTO) {
        this.id = jogadorDTO.getId();
        this.nickname = jogadorDTO.getNickname();
        this.password = jogadorDTO.getPassword();
        this.saldo = jogadorDTO.getSaldo();
        this.stefamons = jogadorDTO.getStefamon();
    }

    public Jogador(Long id, String nickname, String password, BigDecimal saldo, List<Stefamon> stefamons) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.saldo = saldo;
        this.stefamons = stefamons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Stefamon> getStefamons() {
        return stefamons;
    }

    public void setStefamons(List<Stefamon> stefamons) {
        this.stefamons = stefamons;
    }
}
