package day65task.controller;

import day65task.model.dto.CategoryDto;
import day65task.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // 5. 카테고리 등록 POST
//    public boolean categortRegist(@RequestBody CategoryDto categoryDto) {
//        return categoryService.categoryRegist(categoryDto);
//    }

    // 6. 카테고리 조회 G
//    public List<CategoryDto> findCategoryList(){
//        return categoryService.findCategoryList();
//    }

    // 7. 카테고리 수정 PUT

    // 8. 카테고리 삭제 D
}
