console.log("patient info.js open")

const patientId = new URL(location.href).searchParams.get('patientId');

// 1. 환자 개별정보 조회
const onInfo = () => {
    console.log('onInfo.load')
   
    fetch(`/patient/findid.do?patientId=${patientId}`)
    .then(r => r.json())
    .then(data => {
        console.log(data)
        document.querySelector('.name').value = data.name;
        document.querySelector('.birth').value = data.birthdate;
        document.querySelector('.phone').value = data.phone;
        document.querySelector('.address').value = data.address;
        document.querySelector('.cdate').value = data.createdate;
    })
    .catch(e => {console.log(e)})
}

onInfo();

// 2. 환자 정보 수정
const onUpdateBtn = () => {
    console.log('onUpdate.load');

    const name = document.querySelector('.name').value; console.log(name);
    const phone = document.querySelector('.phone').value; console.log(phone);
    const address = document.querySelector('.address').value; console.log(address);

    const updateDto = {
        name : name,
        phone : phone,
        address : address
    }

    const option = {
        method : 'PUT',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( updateDto )
    }


    const isUpdateBtn = confirm("환자정보를 수정 하시겠습니까?");

    if(isUpdateBtn == true) {
        fetch(`/patient/update.do?updatedPatientId=${patientId}`, option)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('환자 정보 수정 성공')
                location.href = `/patient/info?patientId=${patientId}`;
            } else {
                alert('환자 정보 수정 실패')
            }
        })
    } else return;

}

// 3. 환자 정보 삭제
const onDelete = () => {
    console.log('onDelete.load')
    //진료 예약이 없는 경우 조건 추가하기

    const isDeleteBtn = confirm("환자 정보를 삭제 하시겠습니까?");

    if(isDeleteBtn == true) {
        fetch(`/patient/delete.do?deletePatientId=${patientId}`,  {method : 'delete'})
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('환자 정보 삭제')
                location.href = `/patient/info?patientId=${patientId}`;
            } else {
                alert('환자 정보 삭제 실패')
            }
        })
    } else return;
}