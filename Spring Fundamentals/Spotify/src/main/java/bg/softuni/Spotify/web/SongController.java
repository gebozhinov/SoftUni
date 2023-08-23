package bg.softuni.Spotify.web;

import bg.softuni.Spotify.model.dto.AddSongDTO;
import bg.softuni.Spotify.service.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @ModelAttribute("addSong")
    public AddSongDTO addSongDTO() {
        return new AddSongDTO();
    }

    @GetMapping("/add")
    public String add() {
        return "/song-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddSongDTO addSongDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSong", addSongDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSong",
                    bindingResult);
            return "redirect:/song/add";
        }

        this.songService.add(addSongDTO);

        return "redirect:/home";
    }
}
