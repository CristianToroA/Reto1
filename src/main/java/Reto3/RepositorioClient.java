
package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient {
    
     @Autowired
    
     
      private InterfaceClient crud;

    public List<Client> getAll() {
        return (List < Client >) crud.findAll();
    }

    public Optional<Client> getClient(int id) {
        return crud.findById(id);
    }
    
     public Client save(Client Client){
        return crud.save(Client);
    }
    
}
