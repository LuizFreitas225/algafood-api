package com.freitas.luiz.algafoodapi.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.freitas.luiz.algafoodapi.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CozinhasWrapper {
    @NonNull
    private List<Cozinha> cozinhas;
}
