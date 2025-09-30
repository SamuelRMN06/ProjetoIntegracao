package com.example.ProjetoIntegracao.controller;

import com.example.ProjetoIntegracao.mapper.LojaMapper;
import com.example.ProjetoIntegracao.model.LojaModel;
import com.example.ProjetoIntegracao.request.LojaRequest;
import com.example.ProjetoIntegracao.response.LojaResponse;
import com.example.ProjetoIntegracao.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lojas")
public class LojaController {

   @Autowired
   private LojaService lojaService;

   @PostMapping
   public ResponseEntity<LojaResponse> salvarLoja(@RequestBody LojaRequest lojaRequest) {
      LojaModel novaLoja = LojaMapper.toLoja(lojaRequest);
      LojaModel lojaSalva = lojaService.salvarLoja(novaLoja);
      return ResponseEntity.status(HttpStatus.CREATED).body(LojaMapper.toLojaResponse(lojaSalva));
   }

   @GetMapping
   public ResponseEntity<List<LojaResponse>> findAll() {
      List<LojaResponse> lojas = lojaService.listarTodos()
              .stream()
              .map(LojaMapper::toLojaResponse)
              .toList();
      return ResponseEntity.ok(lojas);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deletarLoja(@PathVariable Long id) {
      lojaService.deletarLoja(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

   @PatchMapping("/{id}")
   public ResponseEntity<LojaResponse> atualizarParcialmente(@PathVariable Long id, @RequestBody LojaRequest lojaRequest) {
      LojaModel lojaExistente = lojaService.buscarPorId(id);
      if (lojaRequest.nome() != null) {
         lojaExistente.setNome(lojaRequest.nome());
      }
      if (lojaRequest.endereco() != null) {
         lojaExistente.setEndereco(lojaRequest.endereco());
      }
      LojaModel lojaAtualizada = lojaService.salvarLoja(lojaExistente);
      return ResponseEntity.ok(LojaMapper.toLojaResponse(lojaAtualizada));
   }

}