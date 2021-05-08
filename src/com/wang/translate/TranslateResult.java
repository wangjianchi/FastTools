package com.wang.translate;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.xtend.lib.annotations.Data;

import java.util.List;

/**
 * @author wangjc
 * date: 2021-05-08
 * description:
 */
public class TranslateResult {

    /**
     * type : ZH_CN2EN
     * errorCode : 0
     * elapsedTime : 0
     * translateResult : [[{"src":"你好","tgt":"hello"}]]
     */

    @JsonProperty("type")
    private String type;
    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("elapsedTime")
    private Integer elapsedTime;
    @JsonProperty("translateResult")
    private List<List<TranslateResultDTO>> translateResult;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public List<List<TranslateResultDTO>> getTranslateResult() {
        return translateResult;
    }

    public void setTranslateResult(List<List<TranslateResultDTO>> translateResult) {
        this.translateResult = translateResult;
    }

    public static class TranslateResultDTO {
        /**
         * src : 你好
         * tgt : hello
         */

        @JsonProperty("src")
        private String src;
        @JsonProperty("tgt")
        private String tgt;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTgt() {
            return tgt;
        }

        public void setTgt(String tgt) {
            this.tgt = tgt;
        }
    }
}
