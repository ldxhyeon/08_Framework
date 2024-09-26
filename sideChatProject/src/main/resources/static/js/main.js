document.addEventListener('DOMContentLoaded', function() {
  var usernameForm = document.querySelector('#usernameForm');
  var chatContainer = document.querySelector('#chatContainer');
  var messageArea = document.querySelector('#messageArea');
  var messageInput = document.querySelector('#message');
  var sendMessageBtn = document.querySelector('#sendMessageBtn');
  var chatWith = document.querySelector('#chatWith');

  var stompClient = null;
  var username = null;

  function connect(event) {
      event.preventDefault(); // 폼 제출을 방지
      username = document.querySelector('#name').value.trim();

      if (username) {
          document.querySelector('#username-page').style.display = 'none';
          chatContainer.style.display = 'flex'; // flex로 변경하여 가시성을 유지

          chatWith.textContent = "대화 상대: " + "상대방 이름"; // 대화 상대 이름 설정

          var socket = new SockJS('/ws'); // WebSocket 서버의 URL을 적절히 수정해야 함
          stompClient = Stomp.over(socket);

          stompClient.connect({}, onConnected, onError);
      }
  }

  function onConnected() {
      stompClient.subscribe('/sub/chat/room/1', onMessageReceived);
  }

  function onError(error) {
      console.error('WebSocket connection error:', error);
  }

  function sendMessage(event) {
      var messageContent = messageInput.value.trim();
      if (messageContent && stompClient) {
          var chatMessage = {
              sender: username,
              content: messageContent
          };
          stompClient.send("/pub/chat/message", {}, JSON.stringify(chatMessage));
          messageInput.value = '';
      }
      event.preventDefault();
  }

  function onMessageReceived(payload) {
      var message = JSON.parse(payload.body);
      var messageElement = document.createElement('div');
      messageElement.classList.add('chat-message');

      var senderName = document.createElement('strong');
      senderName.textContent = message.sender;

      var messageText = document.createElement('span');
      messageText.textContent = message.content;

      messageElement.appendChild(senderName);
      messageElement.appendChild(messageText);
      messageArea.appendChild(messageElement);
      messageArea.scrollTop = messageArea.scrollHeight; // 스크롤을 가장 아래로
  }

  sendMessageBtn.addEventListener('click', sendMessage, true);
  usernameForm.addEventListener('submit', connect, true);
});
