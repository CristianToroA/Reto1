
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
@RequestMapping("/api/Reservation")
public class ReservationWeb {
    
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    @Autowired
    private ServiciosReservation servicioreserv;
    @GetMapping("/all")
    
    
    public List <Reservation>getReservation(){
        return servicioreserv.getAll();
    }
    
       @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idreserv){
        return servicioreserv.getReservation(idreserv);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserv){
        return servicioreserv.save(reserv);
    }
    
}
