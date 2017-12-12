package com.sonnhe.entity;

/**
 * @author joqk
 * @Date 2017/12/6 11:31
 * @{description} 会话结果记录
 **/
public class SessionResult {
    /**
     * 语音会话Id会话的唯一标识
     */
    private String sessionId;
    /**
     * 会话名称，或者角色名称
     */
    private String SessionName;
   private String serialNum;
   private String timestamp;
   private String content;
   private String type;

    /**
     * 会话的一个构造函数
     * @param sessionId
     * @param sessionName
     * @param serialNum
     * @param timestamp
     * @param content
     * @param type
     */
    public SessionResult(String sessionId, String sessionName, String serialNum, String timestamp, String content, String type) {
        this.sessionId = sessionId;
        SessionName = sessionName;
        this.serialNum = serialNum;
        this.timestamp = timestamp;
        this.content = content;
        this.type = type;
    }

    public SessionResult(String serialNum, String timestamp, String content) {
        this.serialNum = serialNum;
        this.timestamp = timestamp;
        this.content = content;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return SessionName;
    }

    public void setSessionName(String sessionName) {
        SessionName = sessionName;
    }

    @Override
    public String toString() {
        return "SessionResult{" +
                "sessionId='" + sessionId + '\'' +
                ", SessionName='" + SessionName + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
