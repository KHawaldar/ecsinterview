package com.ecs.api.model.resources;

import com.ecs.api.model.CarDetail;
import com.ecs.api.model.CarMaker;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/ecs/carapi/v1")
@RestController
@Api(tags = "Car Detail")
public interface CarDetailResource {

    @PostMapping( value= "/cardetail",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(code = 202, value = "insert the new car" )
    @ApiResponses({
            @ApiResponse(code = 202, message = "car is created", responseHeaders = {
            })
    })
    ResponseEntity<String> save(@RequestBody() CarDetail carDetail
                                );
    @PutMapping( value= "/carupdate/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(code = 202, value = "update the car" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "car updated successfully", responseHeaders = {
            })
    })
    ResponseEntity<String> update(@RequestBody() CarDetail carDetail);

    @GetMapping( value= "/model/{modelId}/getcardetail",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(code = 200, value = "get car details" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "car is created", responseHeaders = {
            })
    })
    ResponseEntity<CollectionModel<CarDetail>> getCardetails(@PathVariable("modelId") String modelId);


}
