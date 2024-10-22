  const changeInfo = document.querySelector("#changeInfo");
  const infoBox = document.querySelector('.info-box');
  const cancelBtn = document.querySelector('#cancelBtn');

  console.log(changeInfo);

  // 모달창 열기
  changeInfo.addEventListener("click", (e) => {
    e.preventDefault();
    console.log("클릭됨"); // 클릭 이벤트 확인
    infoBox.style.display = "block";
  });
