package com.nice.shop.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class Pagination {



    private int blockLimit = 10;


    public int getStartPage(@PageableDefault(page = 1) Pageable pageable) {
        return ((int)(Math.ceil((double)(pageable.getPageNumber())  / blockLimit))-1)*blockLimit+1;
    }

   public int getEndPage(Page<?> page, int getStartPage){
        return ((getStartPage + blockLimit -1) < page.getTotalPages()) ? getStartPage + blockLimit -1 : page.getTotalPages();
   }
}
