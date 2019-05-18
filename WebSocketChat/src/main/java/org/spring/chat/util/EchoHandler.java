package org.spring.chat.util;

import java.util.ArrayList;
import java.util.List;

import org.spring.chat.model.MessageVO;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class EchoHandler extends TextWebSocketHandler {
 
    /**
     * 서버에 연결한 사용자들을 저장하는 리스트
     */
    private List<WebSocketSession> connectedUsers;
 
    public EchoHandler() {
        connectedUsers = new ArrayList<WebSocketSession>();
        log.info("EchoHandler가 호출 되었다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
 
    /**
     * 접속과 관련된 Event Method
     *
     * @param WebSocketSession
     *            접속한 사용자
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        connectedUsers.add(session);
 
        log.info(session.getId() + "님이 접속했습니다.");
        log.info("연결 IP : " + session.getRemoteAddress().getHostName());
    }
 
    /**
     * 두 가지 이벤트를 처리
     *
     * 1. Send : 클라이언트가 서버에게 메시지를 보냄
     * 2. Emit : 서버에 연결되어 있는 클라이언트에게 메시지를 보냄
     *
     * @param WebSocketSession
     *            메시지를 보낸 클라이언트
     * @param TextMessage
     *            메시지의 내용
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
 
        MessageVO messageVO = MessageVO.converMessage(message.getPayload());
        //페이로드는 사용에 있어서 전송되는 데이터를 뜻한다.
        //페이로드는 전송의 근본적인 목적이 되는 데이터의 일부분으로 그 데이터와 함께 전송되는 헤더와 메타데이터와 같은 데이터는 제외한다.
        
        log.info("messgeVO : "+messageVO);
        log.info(connectedUsers.toString());
        String hostName = "";
 
        for (WebSocketSession webSocketSession : connectedUsers) {
        	//type이 all이면
            if (messageVO.getType().equals("all")) {
            	//type이 all일 때 내가 아닌 사람에게만 보낸다
                if (!session.getId().equals(webSocketSession.getId())) {
                    webSocketSession.sendMessage(
                            new TextMessage(session.getRemoteAddress().getHostName() + " ▶ " + messageVO.getMessage()));
                }
            //type이 all이 아니면(지정한 to가 있으면)
            } else {
                hostName = webSocketSession.getRemoteAddress().getHostName();
                //hostName을 가져와서 해당 host에게 보낸다
                if (messageVO.getTo().equals(hostName)) {
                    webSocketSession.sendMessage(
                            new TextMessage(
                                    "<span style='color:red; font-weight: bold;' >"
                                    + session.getRemoteAddress().getHostName() + "▶ " + messageVO.getMessage()
                                    + "</span>") );
                    break;
                }
            }
        }
 
        /*
         * Payload : 사용자가 보낸 메시지
         */
        log.info(session.getId() + "님의 메시지 : " + message.getPayload());
    }
 
    /**
     * 클라이언트가 서버와 연결을 끊었을때 실행되는 메소드
     *
     * @param WebSocketSession
     *            연결을 끊은 클라이언트
     * @param CloseStatus
     *            연결 상태(확인 필요함)
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
 
        connectedUsers.remove(session);
 
        for (WebSocketSession webSocketSession : connectedUsers) {
            /*
             * 자신이 보낸 메시지를 받지 않는다.
             */
            if (!session.getId().equals(webSocketSession.getId())) {
                webSocketSession.sendMessage(new TextMessage(session.getRemoteAddress().getHostName() + "퇴장했습니다."));
            }
        }
 
        log.info(session.getId() + "님이 퇴장했습니다.");
    }
}


