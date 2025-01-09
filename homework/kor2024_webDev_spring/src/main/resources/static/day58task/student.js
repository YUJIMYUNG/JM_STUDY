// 페이지 로드 시 자동 실행
window.addEventListener('DOMContentLoaded', function() {
    const viewSection = document.querySelector('.viewSection');
    if(viewSection) {  // viewSection이 존재하는 경우에만 실행
        view();
    }
});

// 학생코드
let sNoPK = 5;

//1. 학생등록함수
function regist(){
    console.log("학생 등록함수 실행됨")

    //1. html으로부터 input DOM객체 가져오기
    const sNameInput = document.querySelector('.sNameInput');
    const sKorInput = document.querySelector('.sKorInput');
    const sMathInput = document.querySelector('.sMathInput');
    const sEngInput = document.querySelector('.sEngInput');

    //2. 가져온 객체의 value속성 대입하기
    const getName  = sNameInput.value;
    const getKor  = sKorInput.value;
    const getMath  = sMathInput.value;
    const getEng  = sEngInput.value;
    console.log(getName, getKor, getMath, getEng);

    //3. 학생 점수 데이터 객체 구성
    const studentPointList = {
        sname : getName, skor : getKor, smath : getMath, seng : getEng
    }

    //fetch처리
    let option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(studentPointList)
    }

    fetch('/api/register', option)
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error => {console.log(error)})
    
    sNoPK++;

    //결과및종료
    sNameInput.value = ``;
    sKorInput.value = ``;
    sMathInput.value = ``;
    sEngInput.value = ``;
    
    return;
}


//2. 학생전체조회함수
function view(){
    console.log("학생 전체조회 함수 실행됨")

    const viewSection = document.querySelector('.viewSection');

    //fetch 처리
    fetch('/api/view')
        .then(r => r.json())
        .then(data => {
            console.log(data)
            let html = `
                <table>
                    <tr>
                        <th>번호</th>
                        <th>학생명</th>
                        <th>국어점수</th>
                        <th>수학점수</th>
                        <th>영어점수</th>
                    </tr>
            `;

            for(let i = 0; i < data.length; i++) {
                html += `
                    <tr>
                        <td>${data[i].sno}</td>
                        <td>${data[i].sname}</td>
                        <td>${data[i].skor}</td>
                        <td>${data[i].smath}</td>
                        <td>${data[i].seng}</td>
                    </tr>
                `;
            }

            html += '</table>';
            viewSection.innerHTML = html;
        })
        .catch(error => {console.log(error)})
}

//3. 특정학생 점수 수정 함수
function modify(){
    console.log("특정학생 점수 수정 함수 실행됨")
    const modifySno = document.querySelector(".modifySno");
    const modifySkor = document.querySelector(".modifySkor");
    const modifySmath = document.querySelector(".modifySmath");
    const modifySeng = document.querySelector(".modifySeng");

    const getModifySno = modifySno.value;
    const getModifySkor = modifySkor.value;
    const getModifySmath = modifySmath.value;
    const getModifySeng = modifySeng.value;

    let modifyScore = {
        'sno' : getModifySno,
        'skor' : getModifySkor,
        'smath' : getModifySmath,
        'seng' : getModifySeng
    }

    //fetch 처리
    let option2 = {
        method : 'PUT',
        headers :  {'Content-Type' : 'application/json'},
        body : JSON.stringify(modifyScore)
    }

    fetch(`/api/modify?sNo=${getModifySno}`, option2)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            alert("수정 완료")
            modifySno.value = '';
            modifySkor.value = '';
            modifySmath.value = '';
            modifySeng.value = '';
            view();
        })
        .catch(error => console.log(error))
}

//4. 특정학생 삭제 함수
function deleteStudent(){
    console.log("특정학생 점수 삭제 함수 실행됨");

    const delSno = document.querySelector(".delSno");
    console.log(delSno);
    const getDelSno = delSno.value;
    console.log(getDelSno);

    //fetch처리
     fetch(`/api/delete?sNo=${getDelSno}`, {method : 'DELETE'})
        .then(r => r.json())
        .then(data => {
            console.log(data)
            alert('삭제 성공');
            delSno.value = '';
            view();
        })
        .catch(error => {console.log(error)})
    
    return;
}