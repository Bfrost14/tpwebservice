/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isepdiamniodio.tp.resources;

import com.isepdiamniadio.tp.entities.Localite;
import com.isepdiamniadio.tp.entities.Meteo;
import com.isepdiamniadio.tp.facades.LocaliteFacade;
import com.isepdiamniadio.tp.facades.MeteoFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bfrost Sama
 */
@Path("méteo")
public class MeteosResource {
    
    @EJB
    private MeteoFacade meteoFacade;
    
    @EJB
    private LocaliteFacade localiteFacade;
    
    @GET
    @Operation(summary = "Renvoiye la liste des Localite",
           description = "cette methode return  la liste des Localites de format JSON ou XML")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Meteo> getMeteo() {
        return meteoFacade.findAll();

    }
    
    @GET
    @Path("/{local}/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Meteo findByDate(@PathParam("local") int local,@PathParam("date") String date) {
        Localite mete = localiteFacade.find(local);
        Meteo met ;
        if(mete != null){
           Meteo metee = meteoFacade.find(date);
           return metee;
        }
        met = meteoFacade.find(date);
        return met;
    }
    
    @PUT
    @Path("/{code}/{local}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "ajout d'une Méteo",
            description = "permet d'ajouter une meteo",
            responses = {
                @ApiResponse(description = " return la meteo ajouter",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Localite.class))),
                @ApiResponse(responseCode = "501", description = "erreur interne"),
                @ApiResponse(responseCode = "200", description = "save ok")
            })
    public Meteo addMeteoVille(Meteo meteo, @PathParam("code") String code,@PathParam("local") int local ){
        System.out.println("ajout meteo" + meteo);
        System.out.println("code" + code);
        Meteo met = meteoFacade.find(code);
        Localite mete = localiteFacade.find(local);
        if (mete != null) {
            meteoFacade.remove(meteo);
        }

        meteo.setJour(code);
        meteo.setLocalite(mete);

        meteoFacade.create(meteo);

        return meteo;
    }
    
    
}
