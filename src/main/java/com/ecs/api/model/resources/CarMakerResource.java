package com.ecs.api.model.resources;

import com.ecs.api.model.CarMaker;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ecs/carapi/v1")
@RestController
@Api(tags = "Car Maker")
public interface CarMakerResource {

    @GetMapping( value= "/getCarMakers",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(code = 200, value = "list all car manufactureres" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "manufacturers found", responseHeaders = {
                    })
    })
    ResponseEntity<CollectionModel<CarMaker>> getCarMakers();

    @GetMapping( value= "/carmaker/{carmakerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(code = 200, value = "list the model for a given maker id" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "manufacturers found", responseHeaders = {
            })
    })
    ResponseEntity<CarMaker> getCarMakerById(@PathVariable("carmakerId") String carmakerId);

}
