package com.sgmoomin.springbatch.springbatchapi.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BatchSchedulerNameType {
    
    DEFAULT_SCHEDULER_NAME("B0000", "getScheduler", "Default Scheduler"),
    GET_MEMBER_SCHEDULER_NAME("B0001", "getMemberScheduler", "맴버 조회"),
    SELECT_MEMBER_SCHEDULER_NAME("BC001", "selectMemberScheduler", "맴버 조회(컨트롤러)"),
    GET_ACCOUNT_SCHEDULER_NAME("B0002", "getAccountScheduler", "계약 조회"),
    SELECT_ACCOUNT_SCHEDULER_NAME("BC001", "selectAccountScheduler", "계약 조회(컨트롤러)");

    private String code;
    private String value;
    private String label;
    

    /*
     * Annotation enum 사용을 위한 설정  
     */
    @Getter
    public static class Scheduler_ANNOTATAION{
        // Default
        public static final String DEFAULT_SCHEDULER = "getScheduler";
     
        // Member
        public static final String GET_MEMBER_SCHEDULER = "getMemberScheduler";
     
        // Account
        public static final String GET_ACCOUNT_SCHEDULER = "getAccountScheduler";

        // Select Member
        public static final String SELECT_MEMBER_SCHEDULER = "selectMemberScheduler";

        // Select Account 
        public static final String SELECT_ACCOUNT_SCHEDULER = "selectAccountScheduler";

    }

}
