package com.company.apitarefas.tarefas.facade;

import com.company.apitarefas.tarefas.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFacade {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

    public TarefaDTO criar(TarefaDTO tarefaDTO) {
        Long proximoId = tarefas.keySet().size() + 1L; // Definindo Id, total de tarefas + 1
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO atualizar(TarefaDTO tarefaDTO, Long tarefaId) {
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO getById(Long tarefaId) {
        return tarefas.get(tarefaId);
    }

    public List<TarefaDTO> getAllTarefas() {
        return new ArrayList<>(tarefas.values());
    }

    public String remove(Long tarefaId) {
        tarefas.remove(tarefaId);
        return "Tarefa removida com sucesso!";
    }
}
