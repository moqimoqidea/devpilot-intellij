package com.zhongan.devpilot.webview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageModel {
    private String id;

    private Long time;

    private String role;

    private String content;

    private String username;

    private String avatar;

    private Boolean streaming;

    private List<CodeReferenceModel> codeRefs;

    private RecallModel recall;

    /**
     * 模式，无值则为开启上下文，with-ctrl则为不开启上下文
     */
    private String mode;

    @JsonIgnore
    private String msgType;

    public static MessageModel buildCodeMessage(String id, Long time, String content,
                                                String username, List<CodeReferenceModel> codeReference, String mode) {
        MessageModel messageModel = new MessageModel();
        messageModel.setId(id);
        messageModel.setTime(time);
        messageModel.setRole("user");
        messageModel.setContent(content);
        messageModel.setUsername(username);
        messageModel.setAvatar(null);
        messageModel.setStreaming(false);
        messageModel.setCodeRefs(codeReference);
        messageModel.setMode(mode);
        return messageModel;
    }

    public static MessageModel buildUserMessage(String id, Long time, String content, String username) {
        return buildCodeMessage(id, time, content, username, null, null);
    }

    public static MessageModel buildInfoMessage(String content) {
        return buildAssistantMessage(UUID.randomUUID().toString(), System.currentTimeMillis(), content, false, null);
    }

    public static MessageModel buildAssistantMessage(String id, Long time, String content, boolean streaming, RecallModel recall) {
        MessageModel messageModel = new MessageModel();
        messageModel.setId(id);
        messageModel.setTime(time);
        messageModel.setRole("assistant");
        messageModel.setContent(content);
        messageModel.setUsername(null);
        messageModel.setAvatar(null);
        messageModel.setStreaming(streaming);
        messageModel.setCodeRefs(null);
        messageModel.setRecall(recall);
        return messageModel;
    }

    public static MessageModel buildDividerMessage() {
        MessageModel messageModel = new MessageModel();
        messageModel.setId(System.currentTimeMillis() + "");
        messageModel.setTime(System.currentTimeMillis());
        messageModel.setRole("divider");
        messageModel.setContent(null);
        messageModel.setUsername(null);
        messageModel.setAvatar(null);
        messageModel.setStreaming(false);
        return messageModel;
    }

    public static MessageModel buildLoadingMessage() {
        MessageModel messageModel = new MessageModel();
        messageModel.setId(System.currentTimeMillis() + "");
        messageModel.setTime(System.currentTimeMillis());
        messageModel.setRole("assistant");
        messageModel.setContent("...");
        messageModel.setUsername(null);
        messageModel.setAvatar(null);
        messageModel.setStreaming(true);
        return messageModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getStreaming() {
        return streaming;
    }

    public void setStreaming(Boolean streaming) {
        this.streaming = streaming;
    }

    public List<CodeReferenceModel> getCodeRefs() {
        return codeRefs;
    }

    public void setCodeRefs(List<CodeReferenceModel> codeRefs) {
        this.codeRefs = codeRefs;
    }

    public RecallModel getRecall() {
        return recall;
    }

    public void setRecall(RecallModel recall) {
        this.recall = recall;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
