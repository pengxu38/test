package com.cloudalibaba.consumer.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	 private Long id;
	 
    /**
     * 产品id	 
     */
	 private Long productId;
	 
	 /**
	  * 总库存
	  */
	 private Integer total;
	 
	 /**
	  * 已用库存
	  */
	 private BigDecimal used;
	 
	 /**
	  * 剩余库存
	  */
	 private Integer residue; 
}
