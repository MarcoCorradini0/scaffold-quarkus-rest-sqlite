package it.marcocorradini.mercatinocitta.web.resource;

import java.util.List;

import it.marcocorradini.mercatinocitta.persistence.entity.MercatinoEntity;
import it.marcocorradini.mercatinocitta.persistence.repository.MercatinoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/mercatini")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MercatinoResource {
    @Inject
    MercatinoRepository repository;

    @GET // All
    public List<MercatinoEntity> getAll(){
        return repository.listAll();
    }

    @GET // By id
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id){
        MercatinoEntity m=repository.findById(id);
        if (m==null){
            return Response.status(404).build();
        }
        return Response.ok(m).build();
    }

    @POST // Create
    @Transactional
    public Response create(MercatinoEntity entity){
        repository.persist(entity);
        // o solo return
        return Response.status(Response.Status.CREATED)
                .entity(entity)
                .build();
    }
}
