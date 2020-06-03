package com.mt.schedule.pojo;

/**
 * Created by Yeung on 2020/6/3.
 */
public class InsertJudgmentDTO {
    private int failCount;       //数据插入失败行数
    private int successCount;   //数据插入成功行数

    public InsertJudgmentDTO() {
    }

    public InsertJudgmentDTO(int failCount, int successCount) {
        this.failCount = failCount;
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }
}
