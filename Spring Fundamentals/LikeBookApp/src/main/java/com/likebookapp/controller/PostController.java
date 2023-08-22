package com.likebookapp.controller;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute("addPost")
    public AddPostDTO addPostDTO() {
        return new AddPostDTO();
    }


    @GetMapping("/post/add")
    public String add() {
        return "post-add";
    }

    @PostMapping("/post/add")
    public String add(@Valid AddPostDTO addPostDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addPost", addPostDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPost",
                    bindingResult);
            return "redirect:/post/add";
        }

        this.postService.addPost(addPostDTO);

        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable Long id) {

        this.postService.likePost(id);

        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {

        this.postService.removePost(id);

        return "redirect:/home";
    }

}
