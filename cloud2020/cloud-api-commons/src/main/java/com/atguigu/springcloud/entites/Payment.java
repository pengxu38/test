package com.atguigu.springcloud.entites;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String serial;
	
}
