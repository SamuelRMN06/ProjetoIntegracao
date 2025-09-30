package com.example.ProjetoIntegracao.service;

import com.example.ProjetoIntegracao.model.LojaModel;
import com.example.ProjetoIntegracao.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public LojaModel salvarLoja(LojaModel loja){
        return lojaRepository.save(loja);
    }

    public List<LojaModel> listarTodos(){
        return lojaRepository.findAll();
    }

    public void deletarLoja(Long id){
        lojaRepository.deleteById(id);
    }

    public LojaModel buscarPorId(Long id) {
        return lojaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loja não encontrada"));
    }


}
