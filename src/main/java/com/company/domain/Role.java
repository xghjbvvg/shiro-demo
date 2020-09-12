package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 13:46
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions = new HashSet<>();

}
