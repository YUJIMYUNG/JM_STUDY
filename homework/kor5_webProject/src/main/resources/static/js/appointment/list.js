console.log('appointment.list load');



// 1. 예약 전체 목록조회 함수
const findAll = () => {
    console.log('appointment.findall 함수 실행')

    fetch('/appointment/list.do', {method: 'GET'})
    .then(r => r.json())
    .then(response => {
        console.log(response)
        
        const tbody = document.querySelector('tbody')
        let html = ``;
        
        response.forEach(appointment => {
            html += `
                <tr>
                    <td>${appointment.appointmentid}</td>
                    <td>${appointment.patientname}</td>
                    <td>${appointment.doctorname}</td>
                    <td>${appointment.appointmentdate}</td>
                    <td>${appointment.appointmenttime}</td>
                    ${appointment.status == 1 ? `<td>예약 완료</td>` : `<td>진료 마침 / 예약 취소</td>`}
                </tr>
            `
        })// f end
        tbody.innerHTML = html;
    })
    .catch(e => {console.log(e)})
}

findAll();
