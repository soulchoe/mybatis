package com.mybatis.dy.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude= {"employees"})
public class Department {
	private String deptId;
	private String deptTitle;
	private String locationId;
	private List<Employee> employees;
}
