/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isepdiamniodio.tp.resources;

import com.isepdiamniadio.tp.entities.Localite;
import com.isepdiamniadio.tp.facades.LocaliteFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Bfrost Sama
 */
@Path("localité")
public class LocalitesResource {
    @EJB
    private LocaliteFacade localiteFacade;
    
    @GET
    @Operation(summary = "Renvoiye la liste des Localite",
           description = "cette methode return  la liste des Localites de format JSON ou XML")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Localite> getLocalite() {
        return localiteFacade.findAll();

    }

    
    @PUT
    @Path("/{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "ajout d'une localite",
            description = "permet d'ajouter une localite",
            responses = {
                @ApiResponse(description = " return la Localite ajouter",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Localite.class))),
                @ApiResponse(responseCode = "501", description = "erreur interne"),
                @ApiResponse(responseCode = "200", description = "save ok")
            })
    public Localite addLocalite(Localite localite, @PathParam("code") int code) {
        System.out.println("ajout Localite" + localite);
        System.out.println("code" + code);
        Localite local = localiteFacade.find(code);
        if (local != null) {
            localiteFacade.remove(localite);
        }

        localite.setId(code);

        localiteFacade.create(localite);

        return localite;
    }

    @DELETE
    @Path("/{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Localite deleteLocalite(@PathParam("code") int code) {
        Localite localite = localiteFacade.find(code);
        if (localite == null) {
            throw new WebApplicationException("id localite not Found", Response.Status.NOT_FOUND);
        }
        localiteFacade.remove(localite);
        return localite;
    }
}
