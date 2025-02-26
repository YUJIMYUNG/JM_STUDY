

// 1. 환자 목록조회 함수
const findAll = () => {
    console.log('findall 함수 실행')

    fetch('/patient/findall.do', {method: 'GET'})
    .then(r => r.json())
    .then(response => {
        console.log(response)
        
        const tbody = document.querySelector('tbody')
        let html = ``;
        
        response.forEach( patient => {
            html += `
                <tr>
                    <td>${patient.patientid}</td>
                    <td><a href="/patient/info?patientId=${patient.patientid}">${patient.name}</a></td>
                    <td>${patient.birthdate}</td>
                    <td>${patient.phone}</td>
                    <td>${patient.address}</td>
                    <td>${patient.createdate}</td>
                </tr>
            `
        })// f end
        tbody.innerHTML = html;
    })
    .catch(e => {console.log(e)})
}

findAll();