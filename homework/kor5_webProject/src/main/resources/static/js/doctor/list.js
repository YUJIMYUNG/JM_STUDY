

// 1. 환자 목록조회 함수
const findAll = () => {
    console.log('findall 함수 실행')

    fetch('/doctor/findall.do', {method: 'GET'})
    .then(r => r.json())
    .then(response => {
        console.log(response)
        
        const tbody = document.querySelector('tbody')
        let html = ``;
        
        response.forEach(doctor => {
            html += `
                <tr>
                    <td>${doctor.doctorid}</td>
                    <td><a href="/doctor/info?doctorId=${doctor.doctorid}">${doctor.name}</a></td>
                    <td>${doctor.phone}</td>
                    <td>${doctor.specialty}</td>
                    <td>${doctor.createdate}</td>
                </tr>
            `
        })// f end
        tbody.innerHTML = html;
    })
    .catch(e => {console.log(e)})
}

findAll();

