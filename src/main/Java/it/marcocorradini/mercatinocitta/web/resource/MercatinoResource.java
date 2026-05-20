package it.marcocorradini.mercatinocitta.web.resource;

import java.util.List;

import it.marcocorradini.mercatinocitta.persistence.entity.MercatinoEntity;
import it.marcocorradini.mercatinocitta.persistence.entity.Tema;
import it.marcocorradini.mercatinocitta.persistence.repository.MercatinoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/mercatini")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MercatinoResource {
    @Inject
    MercatinoRepository repository;

    @GET // All
    public List<MercatinoEntity> getAll(
            @QueryParam("tema") String tema,
            @QueryParam("search") String search
    ){
        if (tema!=null && search!=null){
            return repository.find(
                    "lower(titolo) like lower(?1) and tema= ?2",
                    "%" + search + "%",
                    Tema.valueOf(tema.toUpperCase())
            ).list();
        }
        if (tema!=null){
            return repository.find(
                    "tema",
                    Tema.valueOf(tema.toUpperCase())
            ).list();
        }
        if (search!=null){
            return repository.find(
                    "lower(titolo) like lower(?1)",
                    "%" + search + "%"
            ).list();
        }
        return repository.listAll();
    }

    @GET // By id
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id){
        MercatinoEntity m=repository.findById(id);
        if (m==null){
            return Response.status(404).build();
        } else {
            return Response.ok(m).build();
        }
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
