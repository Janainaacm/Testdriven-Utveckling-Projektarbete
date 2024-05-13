package se.reky.janaina.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.reky.janaina.service.PlayerService;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAllPlayersSortedByExperience());
        return "players"; // Name of the Thymeleaf template
    }
}
