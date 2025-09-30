package com.example.ProjetoIntegracao.response;

import lombok.Builder;

@Builder
public record LojaResponse(Long id, String nome, String endereco) {
}
