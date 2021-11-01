
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
@RequestMapping("/api/Client")
public class ClientWeb {
    
      @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    @Autowired
    private ServiciosClient servicios;
    @GetMapping("/all")
    
    
    public List <Client >getClient (){
        return servicios.getAll();
    }
    
       @GetMapping("/{id}")
    public Optional<Client > getClient (@PathVariable("id") int idclient){
        return servicios.getClient (idclient);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client  save(@RequestBody Client  client){
        return servicios.save(client);
    }
}
