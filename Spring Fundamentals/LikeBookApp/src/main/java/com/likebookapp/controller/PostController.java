package com.likebookapp.controller;

import com.likebookapp.model.dto.AddPostDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("post")
public class PostController {


    @ModelAttribute("addPost")
    public AddPostDTO addPostDTO() {
        return new AddPostDTO();
    }
    @GetMapping("/add")
    public String add() {
        return "post-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddPostDTO addPostDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addPost", addPostDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPost",
                    bindingResult);
            return "redirect:/post/add";
        }

        return "redirect:/home";
    }
}
