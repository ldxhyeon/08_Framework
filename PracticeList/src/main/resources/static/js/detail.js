const pathname = location.pathname;

// 마지막 슬래시 이후 부터 값을 추출
const todoNo = pathname.substring(pathname.lastIndexOf('/') + 1);

// 목록으로 버튼 클릭 시
const goToListBtn = document.querySelector("#goToList");
goToListBtn.addEventListener("click", () => {
  location = "/";
});


// 완료 여부 변경 버튼 클릭 시
const completeBtn = document.querySelector("#completeBtn");
completeBtn.addEventListener("click", () => {

  // 현재 보고있는 Todo의 완료 여부 
  // (true)O <-> X(false) 변경 요청
  location.href = "/todo/complete?todoNo=" + todoNo;
});



// 삭제 버튼 클릭 시
const deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener("click", () => {
  
  const isConfirmed = confirm("삭제 하시겠습니까?");

  if (!isConfirmed) {
    return;
  }

  location.href = "/todo/delete?todoNo=" + todoNo;

});



// 삭제 버튼 클릭 시
const updateBtn = document.querySelector("#updateBtn");
updateBtn.addEventListener("click", () => {
  
  location.href = "/todo/update?todoNo=" + todoNo;

});