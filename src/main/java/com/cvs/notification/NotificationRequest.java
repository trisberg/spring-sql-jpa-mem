package com.cvs.notification;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bccAddresses",
    "ccAddresses",
    "files",
    "fromAddress",
    "subject",
    "template",
    "templateVariables",
    "toAddress"
})
public class NotificationRequest {

    @JsonProperty("bccAddresses")
    private List<String> bccAddresses = null;
    @JsonProperty("ccAddresses")
    private List<String> ccAddresses = null;
    @JsonProperty("files")
    private List<String> files = null;
    @JsonProperty("fromAddress")
    private String fromAddress;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("template")
    private String template;
    @JsonProperty("templateVariables")
    private TemplateVariables templateVariables;
    @JsonProperty("toAddress")
    private String toAddress;

    @JsonProperty("bccAddresses")
    public List<String> getBccAddresses() {
        return bccAddresses;
    }

    @JsonProperty("bccAddresses")
    public void setBccAddresses(List<String> bccAddresses) {
        this.bccAddresses = bccAddresses;
    }

    @JsonProperty("ccAddresses")
    public List<String> getCcAddresses() {
        return ccAddresses;
    }

    @JsonProperty("ccAddresses")
    public void setCcAddresses(List<String> ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    @JsonProperty("files")
    public List<String> getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(List<String> files) {
        this.files = files;
    }

    @JsonProperty("fromAddress")
    public String getFromAddress() {
        return fromAddress;
    }

    @JsonProperty("fromAddress")
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty("templateVariables")
    public TemplateVariables getTemplateVariables() {
        return templateVariables;
    }

    @JsonProperty("templateVariables")
    public void setTemplateVariables(TemplateVariables templateVariables) {
        this.templateVariables = templateVariables;
    }

    @JsonProperty("toAddress")
    public String getToAddress() {
        return toAddress;
    }

    @JsonProperty("toAddress")
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

}
