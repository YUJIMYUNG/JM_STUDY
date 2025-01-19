package day65task.controller;

import day65task.model.dto.MemberDto;
import day65task.model.dto.OrderDto;
import day65task.model.dto.ProductDto;
import day65task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;


    // 1. 회원가입 POST
    @PostMapping("/member/signup")
    public boolean signup(@RequestBody MemberDto memberDto){
        return memberService.signup(memberDto);
    }

//    // 2. 로그인 POST
//    @PostMapping("/member/login")
//    public boolean login(@RequestBody MemberDto memberDto){
//        return memberService.login(memberDto);
//    }
//
//    // 3. 전체 회원 목록 조회하기 G
//    @GetMapping("/member/findAll")
//    public List<MemberDto> findAll() {
//        return memberService.findAll();
//    }
//
//    // 4. 특정 회원 정보 조회하기 G
//    public List<MemberDto> findIdInfo(@RequestParam int mno) {
//        return memberService.findIdInfo(int mno);
//    }



    // 9. 상품 등록 POST

    // 10. 상품 수정 PUT

    // 11. 상품 조회 G

    // 12. 상품 삭제 D

    // 13. 특정 회원이 제품을 주문 POST
    @PostMapping("/member/product/order")
    public boolean myProductOrder(@RequestBody OrderDto orderDto){
        return memberService.myProductOrder(orderDto);
    }

    // 14. 특정 회원이 주문한 제품 내역 조회 G
    @GetMapping("/member/product/find")
    public List<OrderDto> myOrderList(@RequestParam int mno){
        return memberService.myOrderList(mno);
    }

    // 15. 주문내역 수정(주문상품의 갯수) PUT


    // 16. 주문 삭제 D



}
