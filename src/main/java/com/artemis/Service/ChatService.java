package com.artemis.Service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final MemoryService memoryService;

    private final MemoryDecisionService decisionService;

    public ChatService(
            MemoryService memoryService,
            MemoryDecisionService decisionService
    ){
        this.memoryService = memoryService;
        this.decisionService = decisionService;
    }

    public String processMessage(String username, String message){

        String type = decisionService.decideType(message);
        if (!type.equals("NONE")){
            memoryService.saveMemory(username,message, type);
        }

        return "Entendi (Memória analisada)";
    }

}
