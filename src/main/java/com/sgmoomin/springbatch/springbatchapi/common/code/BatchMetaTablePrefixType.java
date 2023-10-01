package com.sgmoomin.springbatch.springbatchapi.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BatchMetaTablePrefixType {
    
    DEFAULT_META_PREFIX_TYPE("SGMOOMIN_");

    private String value;

}
