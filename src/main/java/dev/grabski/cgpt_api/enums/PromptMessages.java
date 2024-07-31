package dev.grabski.cgpt_api.enums;

import java.util.Arrays;

import static java.lang.String.format;

public enum PromptMessages {
    RECOMMENDATION_PROMPT("""
                Você pode me recomendar alguns(algumas)
                %s de %s para assistir com a minha noiva?
                Me informe somente o nome dos %s sem nenhum texto de resposta adicional,
                apenas a lista e nada mais (também quero a lista ordenada numericamente).
            """);

    private final String message;

    PromptMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedPrompt(String... args) {
        return format(message, args);
    }
}
