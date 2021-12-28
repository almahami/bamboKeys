package io.rest.BambooKeys.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Questions;

import io.rest.BambooKeys.exception.QuestionNotfoundException;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.QuestionsRepository;

@Service
public class QuestionsService {
    
    private Logger log;
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private UserService userService;


    public QuestionsService (Logger log){
        this.log= log;
    }

    public Questions AddRequest(Long userFK, Questions question){
        boolean userExisist = userService.isUserExisist(userFK);
        if(userExisist){
            question.questionsWitUser(userService.getUser(userFK));
            return questionsRepository.save(question);
        }else{
            log.error("user does not exist");
            throw new UserNotfoundException("user Not found ");
        }
    }

    public Questions updateReuest(Questions nQuestions, Long requestId){
        return questionsRepository.findById(requestId)
        .map(question -> {
            log.info("old User" + questionsRepository.findById(requestId).get());
            question.setCategory(nQuestions.getCategory());
            question.setDescrpetion(nQuestions.getDescrpetion());
            question.setSubject(nQuestions.getSubject());

            log.info("new question" + question.toString());
            return questionsRepository.save(question);
    })
    
    .orElseThrow( () -> new QuestionNotfoundException(requestId));
    }
    
    public List<Questions> getAllRequestFromUser(Long userFK){
        boolean userExisist = userService.isUserExisist(userFK);
        if(userExisist){
            log.info("getALLRequestFromUser" + questionsRepository.findAllReqByUserFK(userFK));
            return questionsRepository.findAllReqByUserFK(userFK);
        }
        else{
            log.error("user does not exist");
            throw new UserNotfoundException("user Not found ");
        }
    }

    public Optional<Questions> getRequestfromUser(Long userFK, Long requestId){
        boolean userExisist = userService.isUserExisist(userFK);
        if(userExisist && existingRequest(requestId) ){
            log.info("getRequestfromUser" + questionsRepository.findById(requestId) );
            return questionsRepository.findById(requestId);
        }
        else{
            log.error("user id or request id is false ");
            throw new UserNotfoundException("user id or request id is false");
        }
    }
    
    public void deleteAllUserRequest(Long userFK){
        boolean userExisist = userService.isUserExisist(userFK);
        if(userExisist){
            log.warn("Delete aLL Reuest From user" + userFK);
            questionsRepository.deleteAll();
        }
        else{
            log.error("user does not exist");
            throw new UserNotfoundException("user Not found ");
        }
    }

    public void deleteARequestFromUSer(Long requestId, Long userFK){
        boolean userExisist = userService.isUserExisist(userFK);
        if(userExisist && existingRequest(requestId)){
            log.warn("Delete the Rquest with id " + requestId + "From the user with" +userFK);
            questionsRepository.deleteById(requestId);
        }
        else{
            log.error("user id or request id is false ");
            throw new UserNotfoundException("user id or request id is false");
        }
    }

    public boolean existingRequest(Long requestId){
        Optional<Questions> res = questionsRepository.findById(requestId);
        if(res.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
