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
@RequestMapping("/api/Category")
public class CategoryWeb {
    
    
      @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
      
    @Autowired
    private ServiciosCategory servicios;
    @GetMapping("/all")
    
    
    public List <Category >getCategory (){
        return servicios.getAll();
    }
    
       @GetMapping("/{id}")
    public Optional<Category > getCategory (@PathVariable("id") int idcate){
        return servicios.getCategory (idcate);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category  save(@RequestBody Category  cate){
        return servicios.save(cate);
    }
}
