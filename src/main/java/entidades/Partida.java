/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luciara Abreu
 */
@Entity
public class Partida implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column
    private String local;
    
    @Column
    private Integer totalVagas;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @ManyToMany
    @JoinTable(name = "PARTIDA_JOGADOR", 
      joinColumns=@JoinColumn(name="PARTIDA_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="JOGADOR_ID", referencedColumnName="ID"))
    private List<Jogador>jogadores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(Integer totalVagas) {
        this.totalVagas = totalVagas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    
    
    
    
}
