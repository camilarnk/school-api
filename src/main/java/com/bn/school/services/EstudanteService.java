package com.bn.school.services;

import com.bn.school.models.EstudanteModel;
import com.bn.school.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // sempre colocar anotaçao service em classes /Service
public class EstudanteService {

    @Autowired // injeçao de dependencia
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> findAll() {
        return estudanteRepository.findAll(); // busca tudo presente no banco
    }

    // optional é necessario para uma busca onde pode ter um resultado ou nao
    public Optional<EstudanteModel> buscarPorId(Long id) {
        return estudanteRepository.findById(id);
    }

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel) { // necessario passar o parametro a ser salvo
        return estudanteRepository.save(estudanteModel); // salvar o model no banco
    }

    // 2 parametros: realizar a busca (id), atualizar (entidade)
    public EstudanteModel atualizarEstudante(Long id, EstudanteModel estudanteModel) {

        // buscando no banco de dados o estudante pelo id e salvando
        EstudanteModel newEstudanteModel = estudanteRepository.findById(id).get();

        newEstudanteModel.setNome(estudanteModel.getNome());
        newEstudanteModel.setEmail(estudanteModel.getEmail());
        newEstudanteModel.setIdade(estudanteModel.getIdade());

        return estudanteRepository.save(newEstudanteModel);
    }

    public void deletarEstudante(Long id) { // receber o id para nao precisar passar a entidade inteira
        estudanteRepository.deleteById(id); // deletar o model do banco
    }

}