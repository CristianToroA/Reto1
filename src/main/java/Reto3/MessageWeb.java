
package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/Message")
public class MessageWeb {
  
    
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    
    @Autowired
    private ServiciosMessage serviciosmessage;
    @GetMapping("/all")
    
    
    public List <Message>getMessage(){
        return serviciosmessage.getAll();
    }
    
       @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int idmessa){
        return serviciosmessage.getMessage(idmessa);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message messa){
        return serviciosmessage.save(messa);
    }
    
    
}
