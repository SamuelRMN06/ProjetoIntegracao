package com.example.ProjetoIntegracao.mapper;

import com.example.ProjetoIntegracao.model.LojaModel;
import com.example.ProjetoIntegracao.request.LojaRequest;
import com.example.ProjetoIntegracao.response.LojaResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LojaMapper {
    public static LojaModel toLoja(LojaRequest lojaRequest){
        return LojaModel
                .builder()
                .nome(lojaRequest.nome())
                .endereco(lojaRequest.endereco())
                .build();
    }

    public static LojaResponse toLojaResponse(LojaModel lojaModel){
        return LojaResponse
                .builder()
                .id(lojaModel.getId())
                .nome(lojaModel.getNome())
                .endereco(lojaModel.getEndereco())
                .build();
    }
}
