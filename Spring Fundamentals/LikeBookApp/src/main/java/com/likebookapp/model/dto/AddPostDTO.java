package com.likebookapp.model.dto;

import com.likebookapp.model.enums.MoodName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddPostDTO {

    @NotBlank(message = "Content can't be blank.")
    @Size(min = 2, max = 150, message = "Content must be between 2 and 150 characters.")
    private String content;

    @NotNull
    private MoodName moodName;
    public MoodName getMoodName() {
        return moodName;
    }

    public AddPostDTO setMoodName(MoodName moodName) {
        this.moodName = moodName;
        return this;
    }

    public AddPostDTO() {
    }

    public String getContent() {
        return content;
    }

    public AddPostDTO setContent(String content) {
        this.content = content;
        return this;
    }

}
