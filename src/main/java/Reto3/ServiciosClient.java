
package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosClient {
    
    @Autowired
     
    private RepositorioClient  crud;
     
    public List<Client > getAll(){
        return crud.getAll();
    }

    public Optional<Client > getClient(int id){
        return crud.getClient(id);
    }
    
    
        public Client save(Client Client){
        if(Client.getIdClient()==null){
            return crud.save(Client);
        }else{
            Optional<Client> evt=crud.getClient(Client.getIdClient());
            if(evt.isEmpty()){
                return crud.save(Client);
            }else{
                return Client;
            }
        }
    }
    
    
}
