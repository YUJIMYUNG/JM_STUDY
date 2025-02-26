console.log("patient info.js open")

const doctorId = new URL(location.href).searchParams.get('doctorId');

// 1. 의사 개별정보 조회
const onInfo = () => {
    console.log('onInfo.load')
   
    fetch(`/doctor/findid.do?doctorId=${doctorId}`)
    .then(r => r.json())
    .then(data => {
        console.log(data)
        document.querySelector('.name').value = data.name;
        document.querySelector('.phone').value = data.phone;
        document.querySelector('.major').value = data.specialty;
        document.querySelector('.cdate').value = data.createdate;
    })
    .catch(e => {console.log(e)})
}

onInfo();

// 2. 의사 정보 수정
const onUpdateBtn = () => {
    console.log('onUpdate.load');

    const name = document.querySelector('.name').value; console.log(name);
    const phone = document.querySelector('.phone').value; console.log(phone);
    const major = document.querySelector('.major').value; console.log(major);

    const updateDto = {
        name : name,
        phone : phone,
        specialty : major
    }

    const option = {
        method : 'PUT',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( updateDto )
    }


    const isUpdateBtn = confirm("의사정보를 수정 하시겠습니까?");

    if(isUpdateBtn == true) {
        fetch(`/doctor/update.do?updatedDoctorId=${doctorId}`, option)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('의사 정보 수정 성공')
                location.href = `/doctor/info?doctorId=${doctorId}`;
            } else {
                alert('의사 정보 수정 실패')
            }
        })
    } else return;

}

// 3. 환자 정보 삭제
const onDelete = () => {
    console.log('onDelete.load')
    //진료 예약이 없는 경우 조건 추가하기

    const isDeleteBtn = confirm("의사 정보를 삭제 하시겠습니까?");

    if(isDeleteBtn == true) {
        fetch(`/doctor/delete.do?deleteDoctorId=${doctorId}`,  {method : 'delete'})
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data == true){
                alert('의사 정보 삭제')
                location.href = `/doctor/info?doctorId=${doctorId}`;
            } else {
                alert('의사 정보 삭제 실패')
            }
        })
    } else return;
}