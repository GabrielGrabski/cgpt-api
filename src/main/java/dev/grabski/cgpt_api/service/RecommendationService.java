package dev.grabski.cgpt_api.service;

import dev.grabski.cgpt_api.dto.PromptRequest;
import dev.grabski.cgpt_api.dto.RecommendationResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import static dev.grabski.cgpt_api.enums.PromptMessages.RECOMMENDATION_PROMPT;

@Service
public class RecommendationService {

    private final ChatClient chatClient;

    public RecommendationService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public RecommendationResponse generateResponse(PromptRequest request) {
        String formattedPrompt = RECOMMENDATION_PROMPT.getFormattedPrompt(
                request.category(), request.gender(), request.category());
        var content = getCallContent(formattedPrompt);
        return new RecommendationResponse(content);
    }

    private String getCallContent(String formattedPrompt) {
        return chatClient.prompt(new PromptTemplate(formattedPrompt).create())
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getContent();
    }
}
