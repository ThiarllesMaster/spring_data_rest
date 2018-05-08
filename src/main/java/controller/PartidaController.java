/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PartidaRepository;
import entidades.Jogador;
import entidades.Partida;
import entidades.Status;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author thiarlles.gomes
 */
@CrossOrigin(origins = "http://localhost:9080")
@RestController
public class PartidaController {
    
    @Autowired
    PartidaRepository partidaRepository;
    
    @RequestMapping(path = "/cadastrarPartida/{local}/{totalVagas}")
    public String cadastrarPartida(@PathVariable String local, @PathVariable Integer totalVagas) {
        Partida partida = new Partida();
        partida.setData(new Date());
        partida.setLocal(local);
        partida.setStatus(Status.AGENDADO);
        partida.setTotalVagas(totalVagas);
        
        partidaRepository.save(partida);
        
        return "Cadastrado com Sucesso";
    }
    
    @RequestMapping(value = "/buscarPartidas", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Iterable<Partida>buscarPartidas() {
      return partidaRepository.findAll();
    }
    
    
}
