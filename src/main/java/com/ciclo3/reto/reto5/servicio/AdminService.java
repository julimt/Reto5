package com.ciclo3.reto.reto5.servicio;

import com.ciclo3.reto.reto5.entidad.Admin;
import com.ciclo3.reto.reto5.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    // GET
    public List<Admin> getAdmins(){
        return repository.findAll();
    }

    public Admin getAdmin(long idAdmin) {return repository.findById(idAdmin).orElse(null);}

    //Peticion POST
    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }

    //UPDATE
    public Admin updateAdmin(Admin adminUpd) {
        Admin adminOld = getAdmin(adminUpd.getIdAdmin());
        //adminOld.setEmail(adminUpd.getEmail());
        adminOld.setPassword(adminUpd.getPassword());
        adminOld.setName(adminUpd.getName());
        return repository.save(adminOld);
    }

    //DELETE
    public void deleteAdmin(long idAdmin){
        repository.deleteById(idAdmin);
    }
}
