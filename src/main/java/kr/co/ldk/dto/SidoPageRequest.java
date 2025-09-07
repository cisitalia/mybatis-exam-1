package kr.co.ldk.dto;

import lombok.Data;

@Data
public class SidoPageRequest {
    private int page = 1;
    private int size = 10;
    private String searchKeyword = "";
    
    public int getOffset() {
        return (page - 1) * size;
    }
}