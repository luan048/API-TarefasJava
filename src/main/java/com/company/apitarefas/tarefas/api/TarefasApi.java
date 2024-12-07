package com.company.apitarefas.tarefas.api;

import com.company.apitarefas.tarefas.dto.TarefaDTO;
import com.company.apitarefas.tarefas.facade.TarefasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Define as rotas, e o que cada uma vai fazer

@RestController
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasApi {
    @Autowired
    private TarefasFacade tarefasFacade;

    // Metodo para criar
    @PostMapping
    @ResponseBody // Resposta vai ser no body
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
        return tarefasFacade.criar(tarefaDTO);
    }

    // Metodo para atualizar
    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaDTO tarefaDTO) {
        return tarefasFacade.atualizar(tarefaDTO, tarefaId);
    }

    @GetMapping("/{tarefaId}")
    public TarefaDTO getById(@PathVariable("tarefaId") Long tarefaId) {
        return tarefasFacade.getById(tarefaId);
    }

    // Metodo para listar tudo
    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAllTarefas() {
        return tarefasFacade.getAllTarefas();
    }

    // Metodo para deletar elemento pelo id
    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String remover(@PathVariable("tarefaId") Long tarefaId) {
        return tarefasFacade.remove(tarefaId);
    }
}
