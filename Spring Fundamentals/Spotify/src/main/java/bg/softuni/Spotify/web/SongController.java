package bg.softuni.Spotify.web;

import bg.softuni.Spotify.model.dto.AddSongDTO;
import bg.softuni.Spotify.repository.UserRepository;
import bg.softuni.Spotify.service.SongService;
import bg.softuni.Spotify.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    private final SongService songService;
    private final UserService userService;

    public SongController(SongService songService,
                          UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @ModelAttribute("addSong")
    public AddSongDTO addSongDTO() {
        return new AddSongDTO();
    }

    @GetMapping("/add")
    public String add() {

        if (!this.userService.isUserLogged()) {
            return "redirect:/login";
        }

        return "/song-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddSongDTO addSongDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (!this.userService.isUserLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSong", addSongDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSong",
                    bindingResult);
            return "redirect:/song/add";
        }

        this.songService.add(addSongDTO);

        return "redirect:/home";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable Long id) {

        if (!this.userService.isUserLogged()) {
            return "redirect:/login";
        }

        this.songService.add(id);

        return "redirect:/home";
    }

    @GetMapping("/remove-all")
    public String remove() {

        if (!this.userService.isUserLogged()) {
            return "redirect:/login";
        }

        this.songService.removeAll();

        return "redirect:/home";
    }
}
