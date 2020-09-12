package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 13:46
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer pid;
    private String name;
    private String url;
}
