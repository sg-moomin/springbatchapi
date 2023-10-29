package com.sgmoomin.springbatch.springbatchapi.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BatchJobNameType {
    
    DEFAULT_JOB_NAME("B0000", "getJob", "Default Job"),
    GET_MEMBER_JOB_NAME("B0001", "getMemberJob", "맴버 조회"),
    SELECT_MEMBER_JOB_NAME("BC001", "selectMemberJob", "맴버 조회(컨트롤러)"),
    GET_ACCOUNT_JOB_NAME("B0002", "getAccountJob", "계약 조회"),
    SELECT_ACCOUNT_JOB_NAME("BC001", "selectAccountJob", "계약 조회(컨트롤러)");

    private String code;
    private String value;
    private String label;
    

    /*
     * Annotation enum 사용을 위한 설정  
     */
    @Getter
    public static class JOB_ANNOTATAION{
        // Default
        public static final String DEFAULT_JOB = "getJob";
     
        // Member
        public static final String GET_MEMBER_JOB = "getMemberJob";
     
        // Account
        public static final String GET_ACCOUNT_JOB = "getAccountJob";

        // Select Member
        public static final String SELECT_MEMBER_JOB = "selectMemberJob";

        // Select Account 
        public static final String SELECT_ACCOUNT_JOB = "selectAccountJob";

    }

}
