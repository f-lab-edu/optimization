package flab.optimization.service;

import flab.optimization.dto.SanggaDto;
import flab.optimization.entity.Sangga;
import flab.optimization.repository.SanggaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Slf4j
@Service
public class SanggaService {
    private final SanggaRepository sanggaRepository;
    private final StopWatch stopWatch = new StopWatch();

    public SanggaService(SanggaRepository sanggaRepository) {
        this.sanggaRepository = sanggaRepository;
    }

    public Page<SanggaDto> searchByNameV1(String name, Pageable pageable) {
        stopWatch.start();
        Page<SanggaDto> sanggaByNameContaining = sanggaRepository.findSanggaByNameContaining(name, pageable).map(this::entityToDto);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return sanggaByNameContaining;
    }

    public Page<SanggaDto> searchByNameV2(String name, Pageable pageable) {
        stopWatch.start();
        Page<SanggaDto> sanggaByNameContaining = sanggaRepository.findSanggaByNameContainingV2(name, pageable).map(this::entityToDto);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return sanggaByNameContaining;
    }

    public Page<SanggaDto> searchByNameV3(String name, Pageable pageable) {
        stopWatch.start();
        Page<SanggaDto> sanggaByNameContaining = sanggaRepository.findSanggaByNameContainingV3(name, pageable).map(this::entityToDto);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return sanggaByNameContaining;
    }

    private SanggaDto entityToDto(Sangga sangga) {
        SanggaDto sanggaDto = new SanggaDto();
        sanggaDto.setName(sangga.getName());
        sanggaDto.setJibun_address(sangga.getJibun_address());
        sanggaDto.setDoro_address(sangga.getDoro_address());
        sanggaDto.setBigClassificationName(sangga.getBigClassificationName().getName());
        sanggaDto.setMediumClassificationName(sangga.getMediumClassificationName().getName());
        sanggaDto.setSmallClassificationName(sangga.getSmallClassificationName().getName());
        return sanggaDto;
    }
}