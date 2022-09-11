package com.example.gatewayservice.controller;

import com.example.gatewayservice.controller.documentation.ApiPageable;
import com.example.gatewayservice.dto.CompositeSensorResponse;
import com.example.gatewayservice.dto.Sensor;
import com.example.gatewayservice.service.CompositeRequestService;
import com.example.gatewayservice.validation.PageableMaxSize;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.example.gatewayservice.validation.ValidationPattern.SENSOR_STATUS;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("gate/v1/count-status")
@AllArgsConstructor
@Validated
@ApiPageable
public class CompositeController {

    private final CompositeRequestService compositeRequestService;

    @GetMapping(value = "/{status}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CompositeSensorResponse> getCountErrorWithStatus(
            @ApiParam(allowableValues = "NORMAL, LOADED, FAILED")
            @PathVariable @NotNull @Pattern(regexp = SENSOR_STATUS) String status,

            @PageableMaxSize(maxPageSize = 400) @PageableDefault(size = 20) @ApiIgnore Pageable page
    ) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Sensor>> allWithStatus = compositeRequestService.getAllWithStatusAsync(status, page);
        CompletableFuture<Long> errorCount = compositeRequestService.getErrorCountAsync();

        CompletableFuture.allOf(allWithStatus, errorCount).join();

        return ResponseEntity.ok(new CompositeSensorResponse(
                allWithStatus.get(),
                errorCount.get()
        ));
    }
}
