package io.rest.BambooKeys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rest.BambooKeys.entity.Questions;
import io.rest.BambooKeys.service.QuestionsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class QuestionsController {
    
    @Autowired
    private QuestionsService questionsService;

    //!!:@RequestBody is getting null values
    //!!!!  Error: Could not write JSON:
    @PostMapping("/addQuestion/{userFK}")
    public Questions greatQuestion(@RequestBody Questions question,@PathVariable Long userFK ){
        return questionsService.AddRequest(userFK, question);
    }

    @GetMapping("/requestes/{userFK}")
    public List<Questions> getALLReuestsFromUser(@PathVariable Long userFK){
        return questionsService.getAllRequestFromUser(userFK);
    }

    @GetMapping("/requestes/{userFK}/{requestId}")
    public Optional<Questions> getAReuestsFromUser(@PathVariable Long userFK, @PathVariable Long requestId){
        return questionsService.getRequestfromUser(userFK, requestId);
    }
    //!!!!!!!!!!!!!! RequestBody is getting null values
    @PutMapping("/updateRequest/{requestId}")
    public Questions updateRequest(@PathVariable long requestId, @RequestBody Questions nQuestion){
        return questionsService.updateReuest(nQuestion, requestId);
    }

    @DeleteMapping("/deleteAllRquestFromU/{userFK}")
    public void deleteAllRquestFromUser(@PathVariable Long userFK){
        questionsService.deleteAllUserRequest(userFK);
    }

    @DeleteMapping("/deleteARquestFromU/{userFK}/{requestId}")
    public void deleteARequestFromUser(@PathVariable Long userFK , @PathVariable Long requestId){
        questionsService.deleteARequestFromUSer(requestId, userFK);
    }
}
