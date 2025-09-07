package kr.co.ldk.mapper;

import kr.co.ldk.domain.Sido;
import kr.co.ldk.dto.SidoPageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SidoMapper {
    List<Sido> findAll();
    
    List<Sido> findPage(SidoPageRequest pageRequest);
    
    int countTotal(@Param("searchKeyword") String searchKeyword);
    
    Sido findById(@Param("seq") Integer seq);
    
    int insert(Sido sido);
    
    int update(Sido sido);
    
    int deleteById(@Param("seq") Integer seq);
}