console.log('register.js open')

// 1. 의사등록
const onRegister = () => {
    let name = document.querySelector('.nameInputValue').value; console.log(name);
    let phone = document.querySelector('.phoneInputValue').value; console.log(phone);
    let major = document.querySelector('.majorInputValue').value; console.log(major);

    const dto = {
        name : name,
        phone : phone,
        specialty : major,
    }

    const option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( dto )
    }

    const isRegisterBtn = confirm("의사를 등록하시겠습니까?");

    if(isRegisterBtn == true) {
        fetch('/doctor/register.do', option)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('의사 등록 성공')
                location.href = '/patient/list';
            } else {
                alert('의사 등록 실패')
            }
        })
    } else return;

}
