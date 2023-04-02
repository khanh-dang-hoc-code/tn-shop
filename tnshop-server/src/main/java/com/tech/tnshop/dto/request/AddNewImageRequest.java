package com.tech.tnshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * @created 02/04/2023 - 20:25
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@AllArgsConstructor
public class AddNewImageRequest {
    private String parentId;

    private String name;

    private String url;
}
