
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
@RequestMapping("/api/Quadbike")

public class QuadbikeWeb {
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    
    @Autowired
    private ServiciosQuadbike servicios;
    @GetMapping("/all")
    
    
    public List <Quadbike>getQuadbike(){
        return servicios.getAll();
    }
    
       @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int idQuad){
        return servicios.getQuadbike(idQuad);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike Quad){
        return servicios.save(Quad);
    }
  
}
