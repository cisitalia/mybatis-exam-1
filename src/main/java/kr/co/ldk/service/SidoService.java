package kr.co.ldk.service;

import kr.co.ldk.domain.Sido;
import kr.co.ldk.dto.SidoPageRequest;
import kr.co.ldk.dto.SidoPageResponse;
import kr.co.ldk.mapper.SidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SidoService {
    
    private final SidoMapper sidoMapper;
    
    public List<Sido> findAll() {
        return sidoMapper.findAll();
    }
    
    public SidoPageResponse findPage(SidoPageRequest pageRequest) {
        List<Sido> content = sidoMapper.findPage(pageRequest);
        int totalElements = sidoMapper.countTotal(pageRequest.getSearchKeyword());
        return new SidoPageResponse(content, totalElements, pageRequest.getPage(), pageRequest.getSize());
    }
    
    public Sido findById(Integer seq) {
        return sidoMapper.findById(seq);
    }
    
    @Transactional
    public Sido save(Sido sido) {
        sidoMapper.insert(sido);
        return sido;
    }
    
    @Transactional
    public Sido update(Sido sido) {
        sidoMapper.update(sido);
        return sido;
    }
    
    @Transactional
    public void deleteById(Integer seq) {
        sidoMapper.deleteById(seq);
    }
}