/* 다음 주소 API로 주소 검색하기 */

function findAddress() {

  var width = 500; //팝업의 너비
  var height = 600; //팝업의 높이

  new daum.Postcode({
    width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
    height: height,
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 각 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var addr = ''; // 주소 변수
      

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
        addr = data.roadAddress;
      } else { // 사용자가 지번 주소를 선택했을 경우(J)
        addr = data.jibunAddress;
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById('postcode').value = data.zonecode;
      document.getElementById("address").value = addr;
      // 커서를 상세주소 필드로 이동한다.
      document.getElementById("detailAddress").focus();
    }
  }).open({
    left: (window.screen.width / 2) - (width / 2),
    top: (window.screen.height / 2) - (height / 2)
  });
}

/* 주소 검색 버튼 클릭 시*/
document.querySelector("#findAddressBtn")
  .addEventListener("click", findAddress);

// 함수명만 작성하는 경우 
// 함수명() 작성하는 경우 : 함수에 정의된 내용을 실행