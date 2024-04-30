package flab.optimization.controller;

import flab.optimization.dto.SanggaDto;
import flab.optimization.service.SanggaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sangga")
public class SanggaController {

    private final SanggaService sanggaService;

    public SanggaController(SanggaService sanggaService) {
        this.sanggaService = sanggaService;
    }

    @GetMapping("/V1/{name}")
    public Page<SanggaDto> searchByName(@PathVariable String name, Pageable pageable) {
        return sanggaService.searchByNameV1(name, pageable);
    }

    @GetMapping("/V2/{name}")
    public Page<SanggaDto> searchByNameV2(@PathVariable String name, Pageable pageable) {
        return sanggaService.searchByNameV2(name, pageable);
    }

    @GetMapping("/V3/{name}")
    public Page<SanggaDto> searchByNameV3(@PathVariable String name, Pageable pageable) {
        return sanggaService.searchByNameV3(name, pageable);

    }
}
