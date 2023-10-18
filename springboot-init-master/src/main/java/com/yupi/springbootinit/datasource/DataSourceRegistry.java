package com.yupi.springbootinit.datasource;

import com.yupi.springbootinit.model.enums.SearchTypeEnum;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册器模式
 * 提前通过一个map或者其他数据接口存贮好后面需要的对象
 */
@Component
public class DataSourceRegistry {
    @Resource
    private PictureDataSource pictureDataSource;

    @Resource
    private PostDataSource postDataSource;

    private Map<String, DataSource<T>> typeDataSourcemap;

    @PostConstruct
    public void doInit(){
        typeDataSourcemap = new HashMap(){{
            put(SearchTypeEnum.POST.getValue(),postDataSource);
            put(SearchTypeEnum.PICTURE.getValue(),pictureDataSource);
        }};
    }
    public DataSource getByType(String type){
        if(typeDataSourcemap == null){
            return null;
        }
        return typeDataSourcemap.get(type);
    }
}
