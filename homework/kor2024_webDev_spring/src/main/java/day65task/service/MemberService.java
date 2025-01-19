package day65task.service;

import day65task.model.dto.MemberDto;
import day65task.model.dto.OrderDto;
import day65task.model.entity.MemberEntity;
import day65task.model.entity.OrderEntity;
import day65task.repository.MemberRepository;
import day65task.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;


    // 1. 회원가입
    public boolean signup(@RequestBody MemberDto memberDto){
        //1. DTO를 Entity로 변환한한 toMemberEntity를 가져옴
        MemberEntity memberEntity = memberDto.toMemberEntity();

        // 2.
        MemberEntity saveEntity = memberRepository.save(memberEntity);

        // 3. 회원가입 해놓고 mno가 제대로 생성 되었는지 여부 확인해서 return값 반환
        if(saveEntity.getMno() > 0) {
            return true;
        } else{
            return false;
        }// if- else end
    }// signup end

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

    // 13. 특정 회원이 제품을 주문
    @Transactional
    public boolean myProductOrder(@RequestBody OrderDto orderDto){
        // 로그인 된 회원이 주문한다는 가정하기위해 로그인 mno 샘플값 넣어둠
        int loginMno = 1;

        // 1. 현재 회원번호의 회원엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);

        // 조회된 엔티티가 없으면
        if(optionalMember.isPresent() == false) {
            return false; //false 로 반환
        }// if end

        MemberEntity memberEntity = optionalMember.get(); //

        // 2. 주문 엔티티 생성
        OrderEntity orderEntity = orderDto.toOrderEntity();

        // 3. 주문 엔티티에 회원번호 넣어주기
        orderEntity.setMemberEntity(memberEntity);

        // 4. 주문 엔티티 꺼내기
        OrderEntity saveEntity = orderRepository.save(orderEntity);

        // 5. 엔티티 저장을 성공하면 PK번호(ono)를 확인하여 0보다 크면 성공
        if(saveEntity.getOno() > 0 ) {
            return true;
        } else {
            return false;
        }// if else end
    }// myProductOrder

    // 14. 특정 회원이 주문한 제품 내역 조회 G
    public List<OrderDto> myOrderList(@RequestParam int mno){
        // 1. 특정회원(mno) 회원 엔티티를 찾는다.
        Optional< MemberEntity> optionalMember = memberRepository.findById(mno);
        if(optionalMember.isPresent()){
            // findbyid로 찾은 회원번호의 엔티티가 존재하면
            MemberEntity memberEntity = optionalMember.get(); // optional 객체에서 엔티티를 꺼냄

            // 2. 찾은 엔티티에서 양방향으로 설정된 주문리스트 조회
            List< OrderEntity> orderEntityList = memberEntity.getOrderEntityList();

            // 3. 모든 주문 엔티티를 dtofh 변환
            List<OrderDto> orderList = orderEntityList.stream()
                    .map(OrderEntity :: toOrderDto)
                    .collect(Collectors.toList());

            // orderList 반환
            return orderList;
        }// if end
        return null;
    }// myOrderList end
}
