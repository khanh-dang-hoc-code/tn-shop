package com.tech.tnshop.dto.request;

/*
 * @created 02/04/2023 - 21:29
 * @project tn-shop
 * @author  ngockhanh
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String name;
    private String url;
}
