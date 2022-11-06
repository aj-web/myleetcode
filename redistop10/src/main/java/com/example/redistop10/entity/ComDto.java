package com.example.redistop10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : chezj
 * @date : 2022/11/6 15:04
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 值
     */
    private String value;

    /**
     * 分数
     */
    private Double score;

}
