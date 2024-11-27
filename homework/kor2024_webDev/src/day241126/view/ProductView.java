package day241126.view;


import day241126.controller.ProductController;
import day241126.model.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {

    Scanner scan = new Scanner(System.in);
    ProductController productController = new ProductController();

    public void mainPage(){
        while(true){
            System.out.print("1.제품 추가 2.전체제품 출력 3.제품삭제 4.제품명/가격수정 선택");
            int choose = scan.nextInt();

            if(choose == 1) {
                // 제품추가 메서드
                productAdd();
            } else if (choose ==2) {
                // 전체제품 출력 메서드
                productPrint();
            } else if ( choose == 3) {
                // 제품 삭제 메서드
                productDelete();
            } else if ( choose == 4) {
                // 제품 수정 메서드
                productUpdate();
            }// if-elseif end
        }// while end
    }// mainpage end

    //1. 제품 추가 함수
    void productAdd(){
        //1.제춤 입력받기
        scan.nextLine();
        System.out.print("제품명 : ");
        String name = scan.nextLine();
        System.out.print("제품가격 : ");
        int price = scan.nextInt();

        //2. 입력받은 값을 컨트롤러에 전달
        boolean result = productController.productAdd(name, price);

        //3. 컨트롤러에 전달 후 결과를 받아 출력하기
        if(result) {
            System.out.println("제품 등록 성공");
        } else {
            System.out.println("제품 등록 실패");
        } // if-else end

    }//productAdd end

    //2. 제품 전체출력 함수
    void productPrint(){
        //1. 컨트롤러에서 모든 제품 정보를 요청
        ArrayList<ProductDto> result = productController.producPrint();

        for(int i = 0; i < result.size(); i++){
            System.out.printf("제품번호 : %s, 제품명 : %s, 제품가격 : %s\n", result.get(i).getIdx(), result.get(i).getName(), result.get(i).getPrice());
        }// for end
    }//productPrint end

    //3. 제품 삭제 함수
    void productDelete(){
        //1.삭제할 제품번호 입력받기
        scan.nextLine();
        System.out.print("삭제할 제품 번호");
        int deleteIdx = scan.nextInt();

        //2. 컨트롤러에서 메서드 호출
        boolean result = productController.productDelete(deleteIdx);

        //3. 처리 후 응답한 결과를 반환된 결과를 출력
        if(result) {
            System.out.println("제품 삭제 완료");
        } else {
            System.out.println("제품 삭제 실패");
        } // if-else end

    }// productDelete end

    // 4. 제품 수정함수
    void productUpdate(){
        //1. 수정할 제품 번호 및 내용 입력받기- 제품 번호 입력받으면 제품명과 가격 모두 수정할 수 있게함
        System.out.print("수정할 제품 번호");
        int updateIdx = scan.nextInt();
        scan.nextLine();

        System.out.print("수정할 제품 이름");
        String updateName = scan.next();
        System.out.print("수정할 제품 가격");
        int updatePrice = scan.nextInt();

        // 2. 수정할 제품 객체 생성
        ProductDto updateProduct = new ProductDto(updateIdx, updateName, updatePrice);

        //3. controller에 전달
        boolean result = productController.productUpdate(updateProduct);

        //4. 결과 출력
        if(result) {
            System.out.println("제품 수정 완료");
        } else {
            System.out.println("주품 수정 실패");
        } // if-else end
    }//productUpdate end
}// class end
