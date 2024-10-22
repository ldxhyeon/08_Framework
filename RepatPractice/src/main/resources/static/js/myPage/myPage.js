  /* 회원정보 수정 모달 창 */
  const modifyModal = document.querySelector("#modifyModal");

  const modifyMenu = document.querySelector("#modifyMenu");

  const modifyBtn = document.querySelector('#modifyBtn');
  const modifyCancelBtn = document.querySelector('#modifyCancelBtn');


  // 모달창 열기
  modifyMenu.addEventListener("click", () => {
    
    modifyModal.style.display = "flex";
  });


  modifyCancelBtn.addEventListener("click",() => {

    modifyModal.style.display = "none";
  });


/* 회원탈퇴 모달 창 */
const deleteModal = document.querySelector("#deleteModal");

const deleteMenu = document.querySelector("#deleteMenu");

const deleteBtn = document.querySelector('#deleteBtn');
const deleteCancelBtn = document.querySelector('#deleteCancelBtn');


deleteMenu.addEventListener("click", (e) => {
    
  deleteModal.style.display = "flex";
});


deleteCancelBtn.addEventListener("click",() => {

  deleteModal.style.display = "none";
});