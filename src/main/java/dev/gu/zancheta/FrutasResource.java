package dev.gu.zancheta;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/frutas")
public class FrutasResource {

    @Inject
    FrutasService frutasService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {
        return frutasService.list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        frutasService.novaFruta(inserirFrutaDTO);
    }
}
