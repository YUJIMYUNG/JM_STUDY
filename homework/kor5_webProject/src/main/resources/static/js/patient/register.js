console.log('register.js open')

// 1. 환자등록
const onRegister = () => {
    let name = document.querySelector('.nameInputValue').value; console.log(name);
    let birth = document.querySelector('.birthInputValue').value; console.log(birth);
    let phone = document.querySelector('.phoneInputValue').value; console.log(phone);
    let address = document.querySelector('.addressInputValue').value; console.log(address);

    const dto = {
        name : name,
        birthdate : birth,
        address : address,
        phone : phone
    }

    const option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( dto )
    }

    const isRegisterBtn = confirm("환자를 등록하시겠습니까?");

    if(isRegisterBtn == true) {
        fetch('/patient/register.do', option)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('환자가 등록 성공')
                location.href = '/patient/list';
            } else {
                alert('환자 등록 실패')
            }
        })
    } else return;

}
