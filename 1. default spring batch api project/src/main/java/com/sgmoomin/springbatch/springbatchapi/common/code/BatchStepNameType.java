package com.sgmoomin.springbatch.springbatchapi.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BatchStepNameType {
    
    DEFAULT_STEP_NAME("B0000", "getStep", "Default Job"),
    GET_MEMBER_STEP_NAME("B0001", "getMemberStep", "맴버 조회"),
    SELECT_MEMBER_STEP_NAME("BC001", "selectMemberStep", "맴버 조회(컨트롤러)"),
    GET_ACCOUNT_STEP_NAME("B0002", "getAccountStep", "계약 조회"),
    SELECT_ACCOUNT_STEP_NAME("BC001", "selectAccountStep", "계약 조회(컨트롤러)");

    private String code;
    private String value;
    private String label;
    

    /*
     * Annotation enum 사용을 위한 설정  
     */
    @Getter
    public static class STEP_ANNOTATAION{
        // Default
        public static final String DEFAULT_STEP = "getStep";
     
        // Member
        public static final String GET_MEMBER_STEP = "getMemberStep";
     
        // Account
        public static final String GET_ACCOUNT_STEP = "getAccountStep";

        // Select Member
        public static final String SELECT_MEMBER_STEP = "selectMemberStep";

        // Select Account 
        public static final String SELECT_ACCOUNT_STEP = "selectAccountStep";

    }

}
