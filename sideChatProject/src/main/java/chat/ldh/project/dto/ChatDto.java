package chat.ldh.project.dto;

public class ChatDto {
	 private String sender;
   private String content;

   // Getter와 Setter
   public String getSender() {
       return sender;
   }

   public void setSender(String sender) {
       this.sender = sender;
   }

   public String getContent() {
       return content;
   }

   public void setContent(String content) {
       this.content = content;
   }
}
