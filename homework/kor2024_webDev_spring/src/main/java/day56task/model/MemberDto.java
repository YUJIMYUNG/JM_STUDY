package day56task.model;

public class MemberDto {
    private int memberNo;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String memberPhonNum;

    public MemberDto(){};

    public MemberDto(int memberNo, String memberId, String memberPwd, String memberName, String memberPhonNum) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberPhonNum = memberPhonNum;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhonNum() {
        return memberPhonNum;
    }

    public void setMemberPhonNum(String memberPhonNum) {
        this.memberPhonNum = memberPhonNum;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhonNum='" + memberPhonNum + '\'' +
                '}';
    }
}
