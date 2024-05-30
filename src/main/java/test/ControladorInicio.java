package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
@Slf4j
public class ControladorInicio {
    
    
    @Value("${index.variable}")
    private String variable;
    
    
    @GetMapping("/") 
    public String inicio (Model model){ 
        var mensaje= "Personal information list with Spring MVC";
        
        var persona = new Persona();
        persona.setNombre("Ignacio");
        persona.setApellido("Sironi");
        persona.setEmail("mail@domain.com");
        persona.setTelefono("54-9-11-1234-5678");
        
        //List<Persona> personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona);
        
        //var personas = Arrays.asList(persona, persona2);
        var personas = Arrays.asList(persona);
        
        log.info("ejecutando el controlador spring MVC");
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("variable",variable);
        model.addAttribute("personas",personas);
        
        return "index";
    }
}
