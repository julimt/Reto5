package com.ciclo3.reto.reto5.servicio;

import com.ciclo3.reto.reto5.entidad.Message;
import com.ciclo3.reto.reto5.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    //GET
    public List<Message> getMessages(){
        return repository.findAll();
    }

    public Message getMessage(long idMessage) {return repository.findById(idMessage).orElse(null);}

    //POST
    public Message saveMessage(Message message){
        return repository.save(message);
    }

    //PUT=UPDATE
    public Message updateMessage(Message messageUpd) {
        Message messageOld = getMessage(messageUpd.getIdMessage());
        messageOld.setMessageText(messageUpd.getMessageText());
        return repository.save(messageOld);
    }

    //DELETE
    public void deleteMessage(long idMessage){
        repository.deleteById(idMessage);
    }
}
