package com.yupi.springbootinit.model.vo;

import com.yupi.springbootinit.model.entity.Picture;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 聚合搜索视图
 */
@Data
public class SearchVO implements Serializable {
    private List<PostVO> postList;
    private List<Picture> pictureList;
    private List<?> dataList;
}
