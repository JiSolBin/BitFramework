package com.bit.sts23.boot03.mapper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

	private int deptno;
	private String dname, loc;
}
