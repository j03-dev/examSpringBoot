package com.app.ekaly.service;

import com.app.ekaly.model.Command;
import com.app.ekaly.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommadService {
    @Autowired
    private CommandRepository commandRepository;

    public List<Command> ListAllCommand(){
        return commandRepository.findAll();
    }

    public void saveCommand(Command command){
        commandRepository.save(command);
    }

    public void deleteCommand(Long id){
        commandRepository.deleteById(id);
    }
}
