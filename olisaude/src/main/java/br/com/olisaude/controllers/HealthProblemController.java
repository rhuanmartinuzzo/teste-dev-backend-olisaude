package br.com.olisaude.controllers;


import br.com.olisaude.data.vo.v1.HealthProblemVO;
import br.com.olisaude.services.HealthProblemServices;
import br.com.olisaude.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/olisaude/healthproblem/v1")
@Tag(name = "HealthProblems", description = "Endpoint for managing HealthProblems")
public class HealthProblemController {

    @Autowired
    private HealthProblemServices service;

    @Operation(summary = "Finds all HealthProblems", description = "Finds all HealthProblems",
            tags = {"HealthProblems"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = HealthProblemVO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HealthProblemVO> findAll(){return service.findAll(); };


    @Operation(summary = "Finds one HealthProblem", description = "Finds one HealthProblem",
            tags = {"HealthProblems"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =@Content(schema = @Schema(implementation = HealthProblemVO.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthProblemVO findById(@PathVariable(value = "id") Long id){ return service.findById(id);};


    @Operation(summary = "Adds a new HealthProblem",
            description = "Adds a new HealthProblem by passing in a JSON representation of the HealthProblem!",
            tags = {"HealthProblem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =@Content(schema = @Schema(implementation = HealthProblemVO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthProblemVO create(@RequestBody HealthProblemVO user) {
        return service.create(user);
    }


    @Operation(summary = "Updates a HealthProblem",
            description = "Updates a HealthProblem by passing in a JSON representation of the HealthProblem!",
            tags = {"HealthProblem"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content =@Content(schema = @Schema(implementation = HealthProblemVO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthProblemVO update(@RequestBody HealthProblemVO user) {
        return service.update(user);
    }


    @Operation(summary = "Deletes a HealthProblem",
            description = "Deletes a HealthProblem by passing in a JSON representation of the HealthProblem!",
            tags = {"HealthProblem"},
            responses = {
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
