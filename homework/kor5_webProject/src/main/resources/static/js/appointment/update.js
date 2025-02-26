console.log('appointment.update load');

// 1. 진료/예약 등록하기
const onRegister = () => {
    const patientNum = document.querySelector('.patientNumInputValue').value; console.log(patientNum);
    const doctorNum = document.querySelector('.doctorNumInputValue').value; console.log(doctorNum);
    const date = document.querySelector('.dateInputValue').value; console.log(date);
    const time = document.querySelector('.timeInputValue').value; console.log(time);

    const dto = {
        doctorid: Number(doctorNum),
        patientid: Number(patientNum),
        appointmentdate: date,
        appointmenttime: time
    }

    const option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( dto )
    }
    
    const isRegisterBtn = confirm("진료/예약을 등록하시겠습니까?");

    if(isRegisterBtn == true) {
        fetch('/appointment/register.do', option)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('진료/예약 등록 성공')
                location.href = '/patient/list';
            } else {
                alert('진료/예약 등록 실패')
            }
        })
    } else return;
    
    
}

// 진료예약 수정
const onUpdate = () => {
    
}