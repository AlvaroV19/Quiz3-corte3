package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IRepository.IProveedorRepository;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(String id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void update(Proveedor proveedor, String id) {
        //Obtener el objeto cliente y el id
        //Verificar con el id, si exiten los datos
        Optional<Proveedor> pv = proveedorRepository.findById(id);

        //Cargar nuevo objeto
        if (!pv.isEmpty()){
            Proveedor proveedorUpdate = pv.get();
            proveedorUpdate.setCodigo(proveedor.getCodigo());
            proveedorUpdate.setDireccion(proveedor.getDireccion());
            proveedorUpdate.setNombre(proveedor.getNombre());

            //Actualizar el objeto cliente
            proveedorRepository.save(proveedorUpdate);
        }else{
            System.out.println("No existe el cliente");
        }
    }

    @Override
    public void deleteLogical(Proveedor proveedor, String id) {
        //Obtener el objeto cliente y el id
        //Verificar con el id, si exiten los datos
        Optional<Proveedor> pv = proveedorRepository.findById(id);

        //Cargar nuevo objeto
        if (!pv.isEmpty()){
            Proveedor proveedorUpdate = pv.get();
            //Reportar fecha de eliminación
            //clienteUpdate.setNombre(cliente.getNombre());
            //Actualizar el objeto cliente
            proveedorRepository.save(proveedorUpdate);
        }else{
            System.out.println("No existe el cliente");
        }
    }

    @Override
    public void delete(String id) {
        proveedorRepository.deleteById(id);
    }

}
