// 1. data 할일목록(배열) 전역변수 선언, 샘플데이터 포함
let todoList = [
    {todoNo : 1, todoContent : '1교시 수업듣기', todoState : false},
    {todoNo : 2, todoContent : '2교시 수업듣기', todoState : true},
]

// 2. 할일코드(pk) 부여하기위한 식별번호, auto_increment
let todoNoPK = 3;

// 3. 등록함수
function register(){    
    console.log("등록함수 실행");

    //1. HTML로부터 input DOM객체 가져오기
    const conInput = document.querySelector('.conInput');
    console.log(conInput);

    //2. 가져온 객체의 value속성 가져오기
    const getTodoContent = conInput.value;
    console.log(getTodoContent);

    //3. 할일 객체 구성
    const todo =  {
        todoNo : todoNoPK, todoContent : getTodoContent, todoState : false,
    }

    //4. 구성한 객체를 배열에 저장
    todoList.push(todo);

    // fetch 처리
    let option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(todo)
    }

    fetch('/register', option)
        .then(respone => respone.json())
        .then(data => {console.log(data);})
        .catch(error => {console.log(error);})

    //객체 저장 완료시 할일코드 +1
    todoNoPK++;

    //결과 및 종료
    alert("할일 등록 되었습니다.");
    conInput.value = ``;
    view();
    return;
}

// 4. 출력함수
view();
function view(){
    console.log('출력함수 실행');

    const todoBottom = document.querySelector('.todoBottom');

    let HTML = '';
    
    for(let i = 0; i < todoList.length ; i++){
        const todo = todoList[i];
        HTML += `<div class = "conBox ${todo.todoState ? 'success' : ''}">
                <div class = "cont"> ${todo.todoContent} </div>
                <div class="conBtns">
                    <button onclick = "modify(${todo.todoNo})" class="updateBtn"> 수정 </button>
                    <button onclikc = "deleteTodo(${todo.todoNo})" class = "deleteBtn"> 삭제 </button>
                </div>
            </div>`
    }
    
    // fetch 처리
    fetch('/view')
    .then(r => r.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
    
    todoBottom.innerHTML = HTML;
}

// 5. 수정함수
function modify(todoNo){
    console.log(`${todoNo} 수정함수`);

    let modifyTodoState = '';

    for(let i = 0; i < todoList.length ; i++ ){
        if(todoList[i].todoNo == todoNo){
            let todoState = todoList[i].todoState;
            modifyTodoState = todoList[i].todoState = !todoState;
            break;
        }
    }

    //fetch 처리
    let option2 = {
        method : 'PUT',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify({'todoNo' : todoNo, 'todoState' : modifyTodoState})
    }

    fetch('/modify', option2)
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error => {console.log(error)})

    view();
    return;
}

// 6. 삭제함수
function deleteTodo(todoNo) {
    console.log(`${todoNo} 삭제함수`);
    
    for(let i = 0; i < todoList.length ; i++){
        if(todoList[i].todoNo == todoNo){
            todoList.splice(i, 1);
            break;
        }
    }

    // fetch 처리
    fetch(`/delete?todoNo=${todoNo}`, {method : 'delete'})
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error =>{console.log(error)})

    view();
    return;
}