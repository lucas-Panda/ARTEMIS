package com.artemis.Service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryDecisionService {

    private final OpenAiService cliente;

    public MemoryDecisionService(){
        this.cliente = new OpenAiService(System.getenv("OPENAI_API_KEY"));
    }

    public String decideType(String message){
        String prompt = """
                Você é um sistema de memória de uma IA pessoal.
                        Classifique a frase abaixo em apenas UMA opção:
                
                        FACT        -> fato sobre o usuário
                        PREFERENCE  -> gosto ou preferência
                        NOTE        -> instrução ou comando futuro
                        NONE        -> conversa comum, não salvar
                
                        Responda SOMENTE com uma dessas palavras.
                
                        Frase: "%s\"
                        """.formatted(message);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(
                        new ChatMessage("user", prompt)
                ))
                .temperature(0.0)
                .build();

        var response = cliente.createChatCompletion(request);

        return response
                .getChoices()
                .get(0)
                .getMessage()
                .getContent()
                .trim();

    }

    public boolean deveSalvar(String message){
        String type = decideType(message);
        return !type.equals("NONE");
    }
}
