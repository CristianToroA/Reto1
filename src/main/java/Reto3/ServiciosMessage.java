
package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {
   
    @Autowired
     
   private RepositorioMessage  metodoscrudm;
     
      public List<Message > getAll(){
        return metodoscrudm.getAll();
    }

    public Optional<Message > getMessage(int idmessa){
        return metodoscrudm.getMessage(idmessa);
    }
    
    
        public Message save(Message mesa){
        if(mesa.getIdMessage()==null){
            return metodoscrudm.save(mesa);
        }else{
            Optional<Message> evt=metodoscrudm.getMessage(mesa.getIdMessage());
            if(evt.isEmpty()){
                return metodoscrudm.save(mesa);
            }else{
                return mesa;
            }
        }
    }
    
    
}
