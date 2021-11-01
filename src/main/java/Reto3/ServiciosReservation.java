
package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservation {
    
     @Autowired
     
   private RepositorioReservation  metodoscrudr;
     
      public List<Reservation > getAll(){
        return metodoscrudr.getAll();
    }

    public Optional<Reservation > getReservation(int id){
        return metodoscrudr.getReservation(id);
    }
    
    
        public Reservation save(Reservation reserv){
        if(reserv.getIdReservation()==null){
            return metodoscrudr.save(reserv);
        }else{
            Optional<Reservation> evt=metodoscrudr.getReservation(reserv.getIdReservation());
            if(evt.isEmpty()){
                return metodoscrudr.save(reserv);
            }else{
                return reserv;
            }
        }
    }
}
