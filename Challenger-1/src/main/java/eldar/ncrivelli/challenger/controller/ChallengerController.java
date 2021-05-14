package eldar.ncrivelli.challenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import eldar.ncrivelli.challenger.Tarjeta;

@Controller
public class ChallengerController {

	@GetMapping("/")
	public String index () {
		return "index";
	}
	
	@PostMapping("/consultarTasa")
	public String consultarTasa(Model modelo, Tarjeta tarjeta) {
		
		double tasa = tarjeta.getTasa(tarjeta.getMarca());
		double total = tarjeta.getMontoConTasa(tarjeta.getMonto(), tasa);
		
		modelo.addAttribute("tasa", tasa);
		modelo.addAttribute("total", total);
		
		return "consulta";
	}
}
