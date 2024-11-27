package day241126.model;

public class ProductDto {

    //1.  필드
    private int idx; // 제품번호
    private String name; // 제품이름
    private int price; // 제품 가격

    //2. 생성자
    // 2-1 제품 추가에 필요한 생성자(제품명, 가격)
    public ProductDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //2-2. 전체제품 출력에 필요한 생성자(제품번호, 제품명, 가격)
    public ProductDto(int idx, String name, int price) {
        this.idx = idx;
        this.name = name;
        this.price = price;
    }

    //2-3. 제품 삭제에 필요한 생성자 X 객체 필요없어보임

    //2-4. 제품 수정시 필요한 생성자- 제품명, 가격 따로 수정
    public ProductDto(int price) {
        this.price = price;
    }

    public ProductDto(String name) {
        this.name = name;
    }

    // 3. 메소드(멤버함수- getter, setter)

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    // toString 재정의
    @Override
    public String toString() {
        return "ProductDto{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
