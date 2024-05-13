package se.reky.janaina.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.reky.janaina.model.Player;
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
        return "players";
    }

    @GetMapping("/players/{playerId}")
    public String showPlayer(@PathVariable Long playerId, Model model) {
        Player player = playerService.findPlayerById(playerId);
        model.addAttribute("player", player);
        return "player"; 
    }
}
