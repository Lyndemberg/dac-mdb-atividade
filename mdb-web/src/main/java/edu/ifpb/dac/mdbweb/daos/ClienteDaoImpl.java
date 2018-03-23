package edu.ifpb.dac.mdbweb.daos;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.service.ClienteDao;
import java.util.Optional;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author romulo
 */
@Stateless
@Local(ClienteDao.class)
public class ClienteDaoImpl implements ClienteDao {

    @PersistenceContext(unitName = "mdb")
    EntityManager entityManager;

    @Override
    public void cadastrarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

//    //tratar erro de restrição de chave
//    public void removerCliente(int idCliente) {
//        Cliente cliente = entityManager.find(Cliente.class, idCliente);
//        entityManager.remove(cliente);
//    }
    @Override
    public Cliente autenticarCliente(String email, String senha) {
        String querySql = "SELECT c FROM Cliente c WHERE c.email= :email "
                + "AND c.senha= :senha";
        TypedQuery<Cliente> query = entityManager
                .createQuery(querySql, Cliente.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        Optional<Cliente> cliente = query.getResultList().stream().findFirst();
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean clienteExiste(String email) {
        TypedQuery<Cliente> query = entityManager.
                createQuery("SELECT c FROM Cliente c WHERE c.email=:email",Cliente.class);
        query.setParameter("email", email);
        Optional<Cliente> cliente = query.getResultList().stream().findFirst();
        return cliente.isPresent();
    }

}
