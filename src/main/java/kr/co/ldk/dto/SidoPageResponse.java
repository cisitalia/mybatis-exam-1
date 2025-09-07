package kr.co.ldk.dto;

import kr.co.ldk.domain.Sido;
import lombok.Data;

import java.util.List;

@Data
public class SidoPageResponse {
    private List<Sido> content;
    private int totalElements;
    private int totalPages;
    private int currentPage;
    private int size;
    
    public SidoPageResponse(List<Sido> content, int totalElements, int currentPage, int size) {
        this.content = content;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.size = size;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
    }
}