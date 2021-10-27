package com.ecs.api.model.resources;

import com.ecs.api.model.CarModel;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ecs/carapi/v1")
@RestController
@Api(tags = "Car Model")
@ApiModel("car model which gets the details of the car model")
public interface CarModelResource {
    @GetMapping( value= "/carmakers/{carmakerId}/model",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(code = 200, value = "list all car manufactureres" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "manufacturers found", responseHeaders = {}),
            @ApiResponse(code = 404, message = "Model is  found", responseHeaders = {})
            }
           )

    ResponseEntity<CollectionModel<CarModel>> getCarModels(@PathVariable("carmakerId") String carmakerId);
}
