package com.example.ProjetoIntegracao.request;

import lombok.*;

@Builder
public record LojaRequest(Long id, String nome, String endereco) {
}
